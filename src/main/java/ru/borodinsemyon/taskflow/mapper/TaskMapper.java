package ru.borodinsemyon.taskflow.mapper;


import ru.borodinsemyon.taskflow.dto.TaskCreateRequest;
import ru.borodinsemyon.taskflow.dto.TaskResponse;
import ru.borodinsemyon.taskflow.model.Task;

public interface TaskMapper {
    TaskResponse toResponse(Task task);
    Task toEntity(TaskCreateRequest request);
}
