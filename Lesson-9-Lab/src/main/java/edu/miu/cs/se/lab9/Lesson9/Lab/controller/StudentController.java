package edu.miu.cs.se.lab9.Lesson9.Lab.controller;

import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Student;
import edu.miu.cs.se.lab9.Lesson9.Lab.service.StudentService;
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
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Long studentId){
       return studentService.getStudentById(studentId);
    }
    @PostMapping("/")
    public Student addNewStudent(@RequestBody Student student){
        return studentService.addNewStudent(student);
    }
    @PutMapping("/{studentId}")
    public Student updateExisingStudent(@PathVariable Long studentId, @RequestBody Student student){
        return studentService.updateExistingStudentById(studentId,student);
    }
    @DeleteMapping("/{studentId}")
    public void deleteStudentById(@PathVariable Long studentId){
        studentService.deleteStudentById(studentId);
    }
    @GetMapping("/search")
    public List<Student> searchStudentByFirstName(@RequestParam String firstname){
        return studentService.searchStudentsByFirstName(firstname);
    }

}
