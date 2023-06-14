package edu.miu.cs.se.lab9.Lesson9.Lab.service;

import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Classroom;
import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Student;
import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Transcript;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public Transcript saveTranscript(Transcript transcript);
    public Classroom saveClassRoom(Classroom classroom);

    public abstract List<Student> getAllStudents();
    public abstract Student getStudentById(Long studentId);
    public abstract Student addNewStudent(Student student);
    public abstract Student updateExistingStudentById(Long studentId, Student student);
    public abstract void  deleteStudentById(Long studentId);
    public abstract List<Student> searchStudentsByFirstName(String firstname);

}
