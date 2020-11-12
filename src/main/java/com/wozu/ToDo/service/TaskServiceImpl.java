package com.wozu.ToDo.service;

import com.wozu.ToDo.model.Task;
import com.wozu.ToDo.repo.TaskRepo;
import org.json.simple.JSONObject;

import java.util.Optional;
import java.util.UUID;

public class TaskServiceImpl implements TaskService {

    TaskRepo taskRepo;

    public TaskServiceImpl(TaskRepo taskRepo){
        this.taskRepo = taskRepo;
    }

    @Override
    public Optional<Task> getTaskById(UUID id) {
        return taskRepo.findById(id);
    }

    @Override
    public Iterable<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public JSONObject deleteAllTasks() {
        taskRepo.deleteAll();
        JSONObject response = new JSONObject();
        response.put("message", "deleted all tasks");
        return response;
    }

    @Override
    public JSONObject deleteById(UUID id) {
        taskRepo.deleteById(id);
        JSONObject response = new JSONObject();
        response.put("message", "deleted task");
        return null;
    }

    @Override
    public JSONObject updateTaskById(UUID id, Task task) {
        Optional<Task> optionalTodoList = taskRepo.findById(id);
        optionalTodoList.map(newTask -> {
           newTask.setDescription(task.getDescription());
           newTask.setComplete(task.getComplete());
           newTask.setTodoList(task.getTodoList());
           return newTask;
        });
        return null;
    }

    @Override
    public JSONObject postTask(Task task) {
        taskRepo.save(task);
        JSONObject response = new JSONObject();
        response.put("message", "posted task!");
        return response;
    }
}
