package edu.miu.cs.se.lab9.Lesson9.Lab.repository;

import edu.miu.cs.se.lab9.Lesson9.Lab.domain.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
}
