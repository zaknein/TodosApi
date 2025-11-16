package com.zaknein.TodosApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.zaknein.TodosApi.ToDoItem;
import com.zaknein.TodosApi.TodoRequest;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import java.util.HashMap;



@Service
public class ToDoStorage implements ToDoRepository {
     private static final File todoFile = new File("todos.json");

    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    private HashMap<Integer,ToDoItem> toDoMap = new HashMap<>();

    public ToDoStorage() throws IOException {
        if (todoFile.exists()) {
            toDoMap = mapper.readValue(todoFile, mapper.getTypeFactory().constructMapLikeType(HashMap.class, Integer.class, ToDoItem.class));
        } else {
            toDoMap = new HashMap<>();
        }
    }

    private int nextToDoId = 1;

    /*--------------------------------------------------------------------------------- */

    @Override
    public ToDoItem createToDo(TodoRequest request) {
        int newId = nextToDoId++;
        ToDoItem newToDo = new ToDoItem(newId, request.getTitle(), request.getDescription());
        toDoMap.put(newId, newToDo);
        sync();
        return null;
    }

    @Override
    public void deleteToDoById(int id) {
        toDoMap.remove(id);
        sync();        
    }

    @Override
    public List<ToDoItem> findAll() {
        
        return new ArrayList(toDoMap.values());
    }

    @Override
    public ToDoItem findById(int id) {
        return toDoMap.get(id); 
    }
    @Override
    public ToDoItem updateToDo(int id, TodoRequest request) {

        ToDoItem ancientToDo = toDoMap.get(id);

        ancientToDo.setTitle(request.getTitle());
        ancientToDo.setDescription(request.getDescription());

        return ancientToDo;
    }


    public void sync(){
        try {
            mapper.writeValue(todoFile, toDoMap);
        } catch (IOException e) {
            System.out.println("No existe archivo");
            e.printStackTrace();
        }
    }




}
