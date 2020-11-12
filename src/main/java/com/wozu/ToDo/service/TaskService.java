package com.wozu.ToDo.service;

import com.wozu.ToDo.model.Task;
import org.json.simple.JSONObject;

import java.util.Optional;
import java.util.UUID;

public interface TaskService {
    //get one by id
    Optional<Task> getTaskById(UUID id);

    //get all
    Iterable<Task> getAllTasks();

    //delete all
    JSONObject deleteAllTasks();

    //delete by Id
    JSONObject deleteById(UUID id);

    //update by Id
    JSONObject updateTaskById(UUID id, Task task);

    //post
    JSONObject postTask(Task task);
}
