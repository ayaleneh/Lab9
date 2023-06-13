package edu.miu.cs.se.lab9.Lesson9.Lab.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "classroom")
@Data
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classroomId;
    private String buildingName;
    private String roomNumber;
    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, orphanRemoval = true)
//orphanRemoval= if classroom got deleted, it will not affect Student
    private List<Student> studentList;

    public Classroom(String buildingName, String roomNumber) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }

    public Classroom() {

    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomId=" + classroomId +
                ", buildingName='" + buildingName + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
