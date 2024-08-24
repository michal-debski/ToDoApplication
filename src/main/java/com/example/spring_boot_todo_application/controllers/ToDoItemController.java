package com.example.spring_boot_todo_application.controllers;


import com.example.spring_boot_todo_application.repositories.ToDoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ToDoItemController {
    private final Logger logger = LoggerFactory.getLogger(ToDoItemController.class);

    @Autowired
    private ToDoItemRepository toDoItemRepository;
    @GetMapping("/")
    public ModelAndView index(){
        logger.debug("request to GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", toDoItemRepository.findAll());
        return modelAndView;
    }

}
