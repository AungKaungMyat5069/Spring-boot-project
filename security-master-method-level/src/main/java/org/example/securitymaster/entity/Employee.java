package org.example.securitymaster.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "First Name can not be blank")
    @Pattern(regexp = "[A-Za-z]*",message = "First Name can not contain Illegal Character")
    private String firstName;
    @NotBlank(message = "Last Name can not be blank")
    @Pattern(regexp = "[A-Za-z]*",message = "Last Name can not contain Illegal Character")
    private String lastName;
    @NotBlank(message = "Phone can be not be empty")
    @Pattern(regexp = "[0-9\\-+]*", message = "Phone Number can not contain Illegal Character")
    private String phoneNumber;
    @NotBlank(message = "Address can not be blank")
    @Pattern(regexp = "[\\w .\\-/]*", message = "Address can not contain Illegal Character")
    private String address;
    @NotBlank(message = "cubicle Number can not be blank")
    @Pattern(regexp = "[A-Za-z0-9\\-]*", message = "cubicle can not contain Illegal Character")
    private String cubicleNo;
}
