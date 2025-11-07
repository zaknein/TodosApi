package com.zaknein.TodosApi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@CrossOrigin
public class toDoController{

    @GetMapping("/health-check")
    public String getHealthCheck(){
        return "Heeell yeah all working up";
    }



}