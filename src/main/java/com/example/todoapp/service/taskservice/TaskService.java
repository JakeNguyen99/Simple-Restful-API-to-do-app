package com.example.todoapp.service.taskservice;

import com.example.todoapp.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    List<Task> getAllTasks();

    Task getByTaskId(String id);

    Task create(Task task);

    Task update(Task task);

    String delete(String id);

}
