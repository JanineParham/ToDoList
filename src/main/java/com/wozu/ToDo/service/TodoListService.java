package com.wozu.ToDo.service;

import com.wozu.ToDo.model.TodoList;
import org.json.simple.JSONObject;

import java.util.Optional;
import java.util.UUID;

public interface TodoListService {

    //get one by id
    Optional<TodoList> getTodoListById(UUID id);

    //get one by title
    Optional<TodoList> getTodoListByTitle(String title);

    //get all
    Iterable<TodoList> getAllTodoList();

    //delete all
    JSONObject deleteAllTodoList();

    //delete by Id
    JSONObject deleteById(UUID id);

    //update by Id
    JSONObject updateTodoListById(UUID id, TodoList todoList);

    //post
    JSONObject postTodoList(TodoList todoList);
}
