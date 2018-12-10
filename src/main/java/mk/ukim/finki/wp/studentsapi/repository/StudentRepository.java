package mk.ukim.finki.wp.studentsapi.repository;

import mk.ukim.finki.wp.studentsapi.model.Student;
import mk.ukim.finki.wp.studentsapi.model.dto.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {

    @Query("select new mk.ukim.finki.wp.studentsapi.model.dto.StudentDTO(s.index, s.name, s.lastName) from Student s")
    List<StudentDTO> findAllWithoutStudyProgram();

    List<Student> findAllByStudyProgramId(Long id);

    Optional<Student> findByIndex(String index);


}
