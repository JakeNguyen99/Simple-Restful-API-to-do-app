package com.example.todoapp.controller;

import com.example.todoapp.entity.Task;
import com.example.todoapp.service.taskservice.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id){
        return taskService.getByTaskId(id);
    }

    @PostMapping
    public Task create(@RequestBody Task task){
        return taskService.create(task);
    }

    @PutMapping
    public Task update(@RequestBody Task task){
        return taskService.update(task);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        return taskService.delete(id);
    }

}
