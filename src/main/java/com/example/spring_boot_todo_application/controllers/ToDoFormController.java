package com.example.spring_boot_todo_application.controllers;

import com.example.spring_boot_todo_application.models.ToDoItem;
import com.example.spring_boot_todo_application.repositories.ToDoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ToDoFormController {

    private final Logger logger = LoggerFactory.getLogger(ToDoFormController.class);

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @GetMapping("/create-todo")
    public String showCreateFormToDoItem(ToDoItem toDoItem){
        return "add-todo-item";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        ToDoItem toDoItem = toDoItemRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ToDoItem id: " + id + " not found"));
        model.addAttribute("toDo", toDoItem);
        return "update-todo-item";

    }
    @GetMapping("/delete/{id}")
    public String deleteToDoItem(@PathVariable("id") long id, Model model){
        ToDoItem toDoItem = toDoItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ToDoItem id: " + id + " not found"));
        toDoItemRepository.delete(toDoItem);
        return "redirect:/";
    }

}
