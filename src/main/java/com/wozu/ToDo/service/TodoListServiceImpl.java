package com.wozu.ToDo.service;

import com.wozu.ToDo.model.TodoList;
import com.wozu.ToDo.repo.TodoListRepo;
import org.json.simple.JSONObject;

import java.util.Optional;
import java.util.UUID;

public class TodoListServiceImpl implements TodoListService {

    TodoListRepo todoListRepo;

    public TodoListServiceImpl(TodoListRepo todoListRepo){
        this.todoListRepo = todoListRepo;
    }

    @Override
    public Optional<TodoList> getTodoListById(UUID id) {
        return todoListRepo.findById(id);
    }

    @Override
    public Optional<TodoList> getTodoListByTitle(String title) {
        return todoListRepo.findByTodoListByTitle(title);
    }

    @Override
    public Iterable<TodoList> getAllTodoList() {
        return todoListRepo.findAll();
    }

    @Override
    public JSONObject deleteAllTodoList() {
        todoListRepo.deleteAll();
        JSONObject response = new JSONObject();
        response.put("message", "deleted all todo lists");
        return response;
    }

    @Override
    public JSONObject deleteById(UUID id) {
        todoListRepo.deleteById(id);
        JSONObject response = new JSONObject();
        response.put("message", "deleted todo list!");
        return null;
    }

    @Override
    public JSONObject updateTodoListById(UUID id, TodoList todoList) {
        Optional<TodoList> optionalTodoList = todoListRepo.findById(id);
        optionalTodoList.map(newtodoList -> {
            newtodoList.setTitle(todoList.getTitle());
            newtodoList.setTasks(todoList.getTasks());
            return todoList;
        });
        return null;
    }

    @Override
    public JSONObject postTodoList(TodoList todoList) {
        todoListRepo.save(todoList);
        JSONObject response = new JSONObject();
        response.put("message", "posted todo list!");
        return response;
    }
}
