package mk.ukim.finki.wp.studentsapi.repository;

import mk.ukim.finki.wp.studentsapi.model.StudyProgram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudyProgramRepository extends JpaRepository<StudyProgram, Long> {
    Optional<StudyProgram> findByName(String name);
}
