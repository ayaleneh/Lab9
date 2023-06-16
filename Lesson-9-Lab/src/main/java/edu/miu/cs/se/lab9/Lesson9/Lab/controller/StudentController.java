package edu.miu.cs.se.lab9.Lesson9.Lab.controller;

import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Student;
import edu.miu.cs.se.lab9.Lesson9.Lab.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllStudents() {
        try {
            return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable Long studentId) {
        try {
            return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addNewStudent(student));
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateExisingStudent(@PathVariable Long studentId, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateExistingStudentById(studentId, student));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long studentId) {
        try {
            studentService.deleteStudentById(studentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudentByFirstName(@RequestParam String firstname) {
        return new ResponseEntity<>(studentService.searchStudentsByFirstName(firstname),HttpStatus.OK);
    }

}
