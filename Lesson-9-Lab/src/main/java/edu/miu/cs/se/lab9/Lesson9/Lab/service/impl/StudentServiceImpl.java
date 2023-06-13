package edu.miu.cs.se.lab9.Lesson9.Lab.service.impl;

import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Classroom;
import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Student;
import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Transcript;
import edu.miu.cs.se.lab9.Lesson9.Lab.repository.ClassroomRepository;
import edu.miu.cs.se.lab9.Lesson9.Lab.repository.StudentRepository;
import edu.miu.cs.se.lab9.Lesson9.Lab.repository.TranscriptRepository;
import edu.miu.cs.se.lab9.Lesson9.Lab.service.StudentService;
import org.springframework.stereotype.Service;

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

}
