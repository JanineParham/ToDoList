package com.wozu.ToDo.repo;

import com.wozu.ToDo.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TaskRepo extends CrudRepository<Task, UUID> {
}
