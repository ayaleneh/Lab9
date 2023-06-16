package edu.miu.cs.se.lab9.Lesson9.Lab.service.impl;

import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Classroom;
import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Student;
import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Transcript;
import edu.miu.cs.se.lab9.Lesson9.Lab.repository.ClassroomRepository;
import edu.miu.cs.se.lab9.Lesson9.Lab.repository.StudentRepository;
import edu.miu.cs.se.lab9.Lesson9.Lab.repository.TranscriptRepository;
import edu.miu.cs.se.lab9.Lesson9.Lab.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final TranscriptRepository transcriptRepository;
    private final ClassroomRepository classroomRepository;

    public StudentServiceImpl(StudentRepository studentRepository,
                              TranscriptRepository transcriptRepository,
                              ClassroomRepository classroomRepository) {
        this.studentRepository = studentRepository;
        this.transcriptRepository = transcriptRepository;
        this.classroomRepository = classroomRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Transcript saveTranscript(Transcript transcript) {
        return transcriptRepository.save(transcript);
    }

    @Override
    public Classroom saveClassRoom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }



    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        return studentOptional.orElse(null);

    }

    @Override
    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }


    @Override
    public Student updateExistingStudentById(Long studentId, Student student) {
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if (existingStudent.isPresent()) {
            Student existingStudentEntity = existingStudent.get();
            BeanUtils.copyProperties(student, existingStudentEntity, "studentId");
            studentRepository.save(existingStudentEntity);
            return existingStudentEntity;
        }
        return null;
    }


    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> searchStudentsByFirstName(String firstname) {
        //we can check if the passed string is what we have as an attribute and do search for each using if else.
        //return studentRepository.getAllStudentByFirstName(firstname);
        return studentRepository.getStudentsByFirstnameStartingWith(firstname);
    }


}
