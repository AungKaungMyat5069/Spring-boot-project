package org.example.affablebeanui.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RequestDataDto(@JsonProperty("credit_number") String creditNumber, String name, double amount) {
}
