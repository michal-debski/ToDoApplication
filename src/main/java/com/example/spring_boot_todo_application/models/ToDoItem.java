package com.example.spring_boot_todo_application.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name="todo_item")
@Getter
@Setter
@AllArgsConstructor
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private boolean complete;

    private Instant createdDate;
    private Instant modifiedDate;

    public ToDoItem (){}

    public ToDoItem(String description){
        this.description = description;
        this.complete = false;
        this.createdDate = Instant.now();
        this.modifiedDate = Instant.now();

    }
    @Override
    public String toString(){
        return String.format("ToDoItem{id=%d, description='%s', complete='%s', createdDate='%s',modifiedDate='%s'}"
        ,id,description,complete,createdDate,modifiedDate);
    }

}
