package org.example.restapidemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmployeeDto {

    private Integer id;
    private String name;
    private String address;
    private String phone;
    private String email;
}
