package com.wozu.ToDo.repo;

import com.wozu.ToDo.model.TodoList;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface TodoListRepo extends CrudRepository<TodoList, UUID> {

    Optional<TodoList> findByTodoListByTitle(String title);
}
