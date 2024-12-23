package org.example.studentmappingdemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Subject extends IdClass{

    private String subjectName;
    private double fee;
    private Integer duration;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.PERSIST)
    private List<StudentSubject> studentSubjects = new ArrayList<>();

    public Subject(String subjectName, double fee, Integer duration) {
        this.subjectName = subjectName;
        this.fee = fee;
        this.duration = duration;
    }

    public void addStudentSubject(StudentSubject studentSubject) {
        studentSubject.setSubject(this);
        studentSubjects.add(studentSubject);
    }
}
