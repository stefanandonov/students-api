package mk.ukim.finki.wp.studentsapi.service;
import mk.ukim.finki.wp.studentsapi.model.*;
import mk.ukim.finki.wp.studentsapi.model.exceptions.IndexNotValidException;
import mk.ukim.finki.wp.studentsapi.model.exceptions.ParameterMissingException;
import mk.ukim.finki.wp.studentsapi.model.exceptions.StudentNotFoundException;
import mk.ukim.finki.wp.studentsapi.model.exceptions.StudyProgramNotFoundException;

import java.util.*;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudent (String index) throws StudentNotFoundException;

    List<Student> getStudentsByStudyProgram(Long id);

    Student addStudent (String index, String name, String lastName, String studyProgramName) throws IndexNotValidException, StudyProgramNotFoundException, ParameterMissingException;

    Student editStudent (String index, String name, String lastName, String studyProgramName) throws StudentNotFoundException;

    Student deleteStudent (String index);

    List<StudyProgram> getAllStudyPrograms();

    StudyProgram createStudyProgram(String studyProgramName);


}
