package edu.miu.cs.se.lab9.Lesson9.Lab.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotEmpty
    @NotBlank(message = "student number can't be empty")
    private String studentNumber;

    @NotEmpty
    @NotBlank
    private String firstName;
    private String middleName;
    @NotEmpty
    @NotBlank
    private String lastName;
    private Double cgpa;
    private LocalDate dateOfEnrollment;
    @OneToMany
    @JoinColumn(name = "studentid")
    private List<Transcript> transcript;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroomid")
    private Classroom classroom;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Course> courseList;

    public Student(String studentNumber, String firstName, String middleName, String lastName, Double cgpa, LocalDate dateOfEnrollment) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Student() {

    }

    public void setTranscript(List<Transcript> transcript) {
        this.transcript = transcript;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
