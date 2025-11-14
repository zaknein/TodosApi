package com.zaknein.TodosApi;

import java.util.List;

public interface ToDoRepository {


    ToDoItem createToDo(TodoRequest request);

    List<ToDoItem> findAll();

    ToDoItem findById(int id);

    ToDoItem updateToDo(int id, TodoRequest request);
    
    void deleteToDoById(int id);
}
