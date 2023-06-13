package edu.miu.cs.se.lab9.Lesson9.Lab.service;

import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Classroom;
import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Student;
import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Transcript;

public interface StudentService {
    public Student saveStudent(Student student);
    public Transcript saveTranscript(Transcript transcript);
    public Classroom saveClassRoom(Classroom classroom);
}
