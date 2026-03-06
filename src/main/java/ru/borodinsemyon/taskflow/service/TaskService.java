package ru.borodinsemyon.taskflow.service;

import ru.borodinsemyon.taskflow.dto.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAllTasks();
}
