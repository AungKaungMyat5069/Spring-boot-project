package com.example.springapiexception.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record EmployeeDto(
        Integer id,
        @NotBlank(message = "First Name can not be blank")
        @NotEmpty(message = "First Name can not be empty")
        String firstName,
        String lastName,
        String email,
        Double salary
) {
}
