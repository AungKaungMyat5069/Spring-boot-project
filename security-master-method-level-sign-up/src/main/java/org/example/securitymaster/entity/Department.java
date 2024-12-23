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
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "code can not be empty")
    @Size(min = 2, max = 5, message = "Range characters between 2 and 5")
    @Pattern(regexp = "[A-Za-z]*", message = "Code can not contain Illegal Characters")
    private String code;
    @NotBlank(message = "name can not be empty")
    @Pattern(regexp = "[A-Za-z ]*", message = "Name can not contain Illegal Characters")
    private String name;
    @NotBlank(message = "country can not be empty")
    @Pattern(regexp = "[A-Za-z ]*", message = "Country can not contain Illegal Characters")
    private String country;

}
