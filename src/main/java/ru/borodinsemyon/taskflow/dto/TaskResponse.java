package ru.borodinsemyon.taskflow.dto;

import java.util.List;
import java.util.UUID;

public record TaskResponse(
        UUID id,
        String details,
        boolean completed,
        List<UserResponse> responsibles
) {}
