package ru.borodinsemyon.taskflow.mapper;

import org.springframework.stereotype.Component;
import ru.borodinsemyon.taskflow.dto.TaskCreateRequest;
import ru.borodinsemyon.taskflow.dto.TaskResponse;
import ru.borodinsemyon.taskflow.dto.UserResponse;
import ru.borodinsemyon.taskflow.model.Task;

import java.util.List;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public TaskResponse toResponse(Task task) {
        if (task == null) return null;

        List<UserResponse> userResponsibles = task.getResponsibles().stream()
                .map(user -> new UserResponse(user.getId(), user.getName()))
                .toList();

        return new TaskResponse(
                task.getId(),
                task.getDetails(),
                task.isCompleted(),
                userResponsibles
        );

    }

    @Override
    public Task toEntity(TaskCreateRequest request) {
        if (request == null) return null;

        Task task = new Task();

        task.setDetails(request.details());
        task.setCompleted(false);
        // Ответственных в в сервисе заполни, не хочу тут логику

        return task;
    }
}
