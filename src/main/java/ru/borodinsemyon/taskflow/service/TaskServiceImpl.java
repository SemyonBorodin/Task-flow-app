package ru.borodinsemyon.taskflow.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.borodinsemyon.taskflow.mapper.TaskMapper;
import ru.borodinsemyon.taskflow.dto.TaskResponse;
import ru.borodinsemyon.taskflow.model.Task;
import ru.borodinsemyon.taskflow.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper mapper;

    public List<TaskResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();

        return tasks.stream()
                .map(mapper::toResponse)
                .toList();
    }
}
