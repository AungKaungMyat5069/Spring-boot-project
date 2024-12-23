package org.example.studentmappingdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class StudentSubject extends IdClass{
    private double marks;

    public StudentSubject(double marks) {
        this.marks = marks;
    }

    @ManyToOne
    private Student student;
    @ManyToOne
    private Subject subject;
}
