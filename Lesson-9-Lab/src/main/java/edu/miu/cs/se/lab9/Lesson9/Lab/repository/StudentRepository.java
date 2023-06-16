package edu.miu.cs.se.lab9.Lesson9.Lab.repository;

import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("select s from Student s where s.firstname=:firstname")
    List<Student> getAllStudentByFirstName(String firstname);
    List<Student> getStudentsByFirstnameStartingWith(String firstname);

}
