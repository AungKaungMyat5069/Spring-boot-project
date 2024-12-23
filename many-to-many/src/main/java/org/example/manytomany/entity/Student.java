package org.example.manytomany.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String school;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Subject> subjects = new ArrayList<>();

    public Student(String firstName, String lastName, String email, String school) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.school = school;
    }

    public void addSubject(Subject subject) {
        subject.getStudents().add(this);
        subjects.add(subject);

    }

}
