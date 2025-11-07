package com.zaknein.TodosApi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@CrossOrigin
public class toDoController{

    static ToDoItem toDoItem = new ToDoItem();
    @GetMapping("/health-check")
    public String getHealthCheck(){
        return "Heeell yeah all working up";
    }

    @GetMapping("/todos")
    public TodoItem getToDoItem(){
        return toDoItem;
    }

    @GetMapping("/todos/{id}")
    public int getId(@PathVariable String id){
        /* BUILDING IN PROGRESS */
    }

}