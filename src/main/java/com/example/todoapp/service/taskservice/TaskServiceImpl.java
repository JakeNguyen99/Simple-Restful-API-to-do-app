package com.example.todoapp.service.taskservice;

import com.example.todoapp.entity.Task;
import com.example.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getByTaskId(String id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        Task existingTask = taskRepository.findById(task.getId()).get();
        existingTask.setDescription(task.getDescription());
        existingTask.setTitle(task.getTitle());
        existingTask.setStatus(task.getStatus());
        return taskRepository.save(existingTask);
    }

    @Override
    public String delete(String id) {
        taskRepository.deleteById(id);
        return "Task deleted";
    }
}
