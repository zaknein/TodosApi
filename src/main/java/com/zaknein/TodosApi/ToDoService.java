package com.zaknein.TodosApi;

// import com.zaknein.TodosApi.ToDoItem;
// import com.zaknein.TodosApi.TodoRequest;

// import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ToDoService {
    
    private final Map<Integer, ToDoItem> toDoMap = new HashMap<>();

    private int nextToDoId = 1;

    public ToDoItem createToDo(TodoRequest request){
        int newId = nextToDoId++;

        ToDoItem newToDo = new ToDoItem(newId, request.getTitle(), request.getDescription());

        toDoMap.put(newId, newToDo);

        return newToDo;
    }

    public List<ToDoItem> findAll() {
        return new ArrayList<>(toDoMap.values());
    }

    public ToDoItem findById(int id) {
        return toDoMap.get(id); 
    }

    public ToDoItem updateToDo(int id, TodoRequest request){
        ToDoItem oldToDo = toDoMap.get(id);

        oldToDo.setTitle(request.getTitle());
        oldToDo.setDescription(request.getDescription());

        return oldToDo;
    }

    public void deleteToDoById(int id){
        toDoMap.remove(id);
    }
}
