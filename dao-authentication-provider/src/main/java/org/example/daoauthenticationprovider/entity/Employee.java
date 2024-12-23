package org.example.daoauthenticationprovider.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String authority;

    public Employee(String name, String email, String phone, String password, String authority) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.authority = authority;
    }
}
