package com.zaknein.TodosApi;

public class toDoItem {
    int id;
    String  title;
    String description;

    public toDoItem() { }

    public toDoItem(String title, String description){
        this.id = nextId++;
        this.title = title;
        this.description = description;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }
}