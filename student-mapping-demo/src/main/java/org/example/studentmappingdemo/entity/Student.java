package org.example.studentmappingdemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @Getter
@NoArgsConstructor
public class Student extends IdClass{

    private String firstName;
    private String lastName;
    private String email;
    private String school;

    @ManyToOne
    private Province province;

   @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
   private List<StudentSubject> studentSubjects = new ArrayList<StudentSubject>();

    public Student(String firstName, String lastName, String email, String school) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.school = school;
    }

    public void addStudentSubject(StudentSubject studentSubject) {
        studentSubject.setStudent(this);
        studentSubjects.add(studentSubject);
    }
}
