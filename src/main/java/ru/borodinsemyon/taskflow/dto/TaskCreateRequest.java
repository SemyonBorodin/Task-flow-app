package ru.borodinsemyon.taskflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

public record TaskCreateRequest(
        @NotBlank(message = "Details cannot be empty")
        @Size(min = 1, max = 500, message = "Details must be between 1 and 500 characters")
        String details,
        List<UUID> responsibleIds)
{}
