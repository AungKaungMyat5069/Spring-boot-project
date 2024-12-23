package org.example.connectiondemo.ds;

import lombok.*;

import java.sql.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hiredDate;
    private double salary;

}
