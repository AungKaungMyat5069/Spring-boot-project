package org.example.securitymaster.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "this code can not be blank")
    @Size(min = 2, max = 5, message = "range between character 2 and 5")
    @Pattern(regexp = "[A-Za-z]*", message = "Can not contain Illegal Character")
    private String code;
    @NotBlank(message = "First Name can not be blank")
    @Pattern(regexp = "[A-Za-z]*",message = "First Name can not contain Illegal Character")
    private String firstName;
    @NotBlank(message = "Last Name can not be blank")
    @Pattern(regexp = "[A-Za-z]*",message = "Last Name can not contain Illegal Character")
    private String lastName;
    @NotBlank(message = "Address can not be blank")
    @Pattern(regexp = "[\\w .\\-/]*", message = "Address can not contain Illegal Character")
    private String address;
}
