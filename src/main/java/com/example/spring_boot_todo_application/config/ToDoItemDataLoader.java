package com.example.spring_boot_todo_application.config;

import com.example.spring_boot_todo_application.models.ToDoItem;
import com.example.spring_boot_todo_application.repositories.ToDoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ToDoItemDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(ToDoItemDataLoader.class);

    @Autowired
    ToDoItemRepository toDoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if (toDoItemRepository.count() == 0) {
            ToDoItem toDoItem1 = new ToDoItem("get the milk");
            ToDoItem toDoItem2 = new ToDoItem("rake the leaves");
            toDoItemRepository.save(toDoItem1);
            toDoItemRepository.save(toDoItem2);
        }
        logger.info("Number of ToDoItems: {}", toDoItemRepository.count());
    }
}
