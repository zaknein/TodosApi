package com.zaknein.TodosApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.zaknein.TodosApi.ToDoItem;
import com.zaknein.TodosApi.TodoRequest;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;




public class ToDoStorage implements ToDoRepository {
     private static final File todoFile = new File("todos.json");

    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    private HashMap<Integer,ToDoItem> ToDoMap = new HashMap<>();

    public ToDoStorage() throws IOException {
        if (todoFile.exists()) {
            ToDoMap = mapper.readValue(todoFile, mapper.getTypeFactory().constructMapLikeType(HashMap.class, Integer.class, ToDoItem.class));
        } else {
            ToDoMap = new HashMap<>();
        }
    }

    private int nextToDoId = 1;

    /*--------------------------------------------------------------------------------- */

    public void add(Expense expense) {

    }

    public List<Expense> list() {
        return new ArrayList(expenses.values());
    }

    public void delete(int id) {
        expenses.remove(id);
        save();
    }
    public Expense get(int id){
        return expenses.get(id);
    }
    public void update(int id, Expense expense){
        expenses.replace(id, expense);
        save();
    }



    @Override
    public ToDoItem createToDo(TodoRequest request) {
        int newId = nextToDoId++;
        ToDoItem newToDo = new ToDoItem(newId, request.getTitle(), request.getDescription());
        ToDoMap.put(newId, newToDo);
        sync();
        return null;
    }

    @Override
    public void deleteToDoById(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<ToDoItem> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ToDoItem findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ToDoItem updateToDo(int id, TodoRequest request) {
        // TODO Auto-generated method stub
        return null;
    }


    public void sync(){
        try {
            mapper.writeValue(todoFile, ToDoMap);
        } catch (IOException e) {
            System.out.println("No existe archivo");
            e.printStackTrace();
        }
    }




}
