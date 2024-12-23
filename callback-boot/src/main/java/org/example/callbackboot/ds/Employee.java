package org.example.callbackboot.ds;

import lombok.*;

import java.sql.Date;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private Date hired_date;
    private double salary;
}
