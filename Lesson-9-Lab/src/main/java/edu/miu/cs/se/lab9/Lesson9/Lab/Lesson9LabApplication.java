package edu.miu.cs.se.lab9.Lesson9.Lab;

import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Classroom;
import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Course;
import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Student;
import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Transcript;
import edu.miu.cs.se.lab9.Lesson9.Lab.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Lesson9LabApplication implements CommandLineRunner {
    @Autowired
    StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(Lesson9LabApplication.class, args);
    }

    public Student saveStudent() {
        var transcript = new Transcript("BS in Computer Science");
        studentService.saveTranscript(transcript);

        var classroom = new Classroom("McLaughlin building", "M105");
        studentService.saveClassRoom(classroom);

        var course= new Course("CS401","Software Engineering");

        var student = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2019, 5, 24));
        student.setTranscript(List.of(transcript));
        student.setClassroom(classroom);
        student.setCourseList(List.of(course));
        course.setStudents(List.of(student));
        studentService.saveStudent(student);

        return student;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Student Service is running..");
        System.out.println(saveStudent());
    }
}
