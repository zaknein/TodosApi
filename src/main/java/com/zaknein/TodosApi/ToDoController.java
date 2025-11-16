package com.zaknein.TodosApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
public class ToDoController{

    private final ToDoStorage toDoStorage;

    @Autowired
    public ToDoController(ToDoStorage toDoStorage){
        this.toDoStorage = toDoStorage;
    }
   
    /* GET METHODS */
    
    @GetMapping("/health-check")
    public String getHealthCheck(){
        return "Heeell yeah all working up";
    }

    @GetMapping("/todos")
    public List<ToDoItem>  getAllToDos() {
        return toDoStorage.findAll();
    }

    @GetMapping("/todos/{id}")
    public ToDoItem getToDoById(@PathVariable int id) { 
        return toDoStorage.findById(id); 
    }

    /* POST METHODS */

    @PostMapping("/todos")
    public ToDoItem createNewDoItem(@RequestBody TodoRequest request){
        return toDoStorage.createToDo(request);
    }

    @PutMapping("/todos/{id}")
    public ToDoItem updateToDo(@PathVariable int id, @RequestBody TodoRequest request){        
        ToDoItem newToDo = toDoStorage.updateToDo(id, request);
        return newToDo; 
    }

    @DeleteMapping("/todos/{id}")
    public void deleteToDoById(@PathVariable int id){
        toDoStorage.deleteToDoById(id);
    }
}
