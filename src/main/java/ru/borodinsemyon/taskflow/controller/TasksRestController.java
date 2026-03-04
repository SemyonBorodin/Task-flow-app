package ru.borodinsemyon.taskflow.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.borodinsemyon.taskflow.dto.TaskResponse;
import ru.borodinsemyon.taskflow.repository.TaskRepository;
import ru.borodinsemyon.taskflow.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TasksRestController {
    private final TaskRepository taskRepository;
    private final TaskService taskService;

    public TasksRestController(TaskRepository taskRepository, TaskService taskService) {
        this.taskRepository = taskRepository;
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        List<TaskResponse> tasks = taskService.getAllTasks();

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(tasks);
    }
}
