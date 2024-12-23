package org.example.manytomany.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subjectName;
    private int duration;
    private double fee;

    public Subject(String subjectName, int duration, double fee) {
        this.subjectName = subjectName;
        this.duration = duration;
        this.fee = fee;
    }

    @ManyToMany(mappedBy = "subjects")
    private List<Student> students = new ArrayList<>();
}
