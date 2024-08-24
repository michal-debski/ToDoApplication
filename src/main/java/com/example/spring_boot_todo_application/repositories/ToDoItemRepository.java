package com.example.spring_boot_todo_application.repositories;

import com.example.spring_boot_todo_application.models.ToDoItem;
import org.springframework.data.repository.CrudRepository;

public interface ToDoItemRepository extends CrudRepository<ToDoItem,Long> {

}
