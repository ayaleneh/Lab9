package edu.miu.cs.se.lab9.Lesson9.Lab.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "studentId")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotEmpty
    @NotBlank(message = "student number can't be empty")
    private String studentNumber;

    @NotEmpty
    @NotBlank
    private String firstname;
    private String middlename;
    @NotEmpty
    @NotBlank
    private String lastname;
    private Double cgpa;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "enrollment date can't be null")
    private LocalDate dateOfEnrollment;
    private Boolean isInternational;
    @OneToMany
    @JoinColumn(name = "studentid")
    private List<Transcript> transcript;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classroomid")
    private Classroom classroom;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Course> courseList;

    public Student(String studentNumber, String firstName, String middleName, String lastName, Double cgpa, LocalDate dateOfEnrollment, Boolean isInternational) {
        this.studentNumber = studentNumber;
        this.firstname = firstName;
        this.middlename = middleName;
        this.lastname = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.isInternational=isInternational;
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
