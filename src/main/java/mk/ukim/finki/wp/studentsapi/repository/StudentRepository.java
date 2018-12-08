package mk.ukim.finki.wp.studentsapi.repository;

import mk.ukim.finki.wp.studentsapi.model.Student;
import mk.ukim.finki.wp.studentsapi.model.exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentRepository  {

    List<Student> findAll ();

    Student getStudentByIndex (String index) ;

    List<Student> getStudentsByStudyProgram (Long id);

    Student addStudent (String index, String name, String lastName, String studyProgramName);

    Student deleteByIndex (String index);

    Student updateStudent (String index, String name, String lastName, String studyProgramName);


}
