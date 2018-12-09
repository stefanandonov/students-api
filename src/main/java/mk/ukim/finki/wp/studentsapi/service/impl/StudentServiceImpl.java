package mk.ukim.finki.wp.studentsapi.service.impl;

import mk.ukim.finki.wp.studentsapi.model.Student;
import mk.ukim.finki.wp.studentsapi.model.StudyProgram;
import mk.ukim.finki.wp.studentsapi.model.dto.StudentDTO;
import mk.ukim.finki.wp.studentsapi.model.exceptions.*;
import mk.ukim.finki.wp.studentsapi.repository.StudentRepository;
import mk.ukim.finki.wp.studentsapi.repository.StudyProgramRepository;
import mk.ukim.finki.wp.studentsapi.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudyProgramRepository studyProgramRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudyProgramRepository studyProgramRepository) {
        this.studentRepository = studentRepository;
        this.studyProgramRepository = studyProgramRepository;
    }

    private boolean checkIndexValidity(String index) {
        for (char c :
                index.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }

        return index.length() == 6;

    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAllWithoutStudyProgram();
    }

    @Override
    public Student getStudent(String index) throws StudentNotFoundException {
        return studentRepository.findByIndex(index).orElseThrow(() -> new StudentNotFoundException("Student is not found!", index));
    }

    @Override
    public List<Student> getStudentsByStudyProgram(Long id) {
        return studentRepository.findAllByStudyProgramId(id);
    }

    @Override
    public Student addStudent(String index, String name, String lastName, String studyProgramName) throws IndexNotValidException, StudyProgramNotFoundException, ParameterMissingException {
        if (name == null || lastName == null || studyProgramName == null)
            throw new ParameterMissingException(0);

        if (!checkIndexValidity(index))
            throw new IndexNotValidException(index);

        StudyProgram sp = studyProgramRepository.findByName(studyProgramName).orElseThrow(() -> new StudyProgramNotFoundException("", studyProgramName));
        return studentRepository.save(new Student(index, name, lastName, sp));
    }

    @Override
    public Student addStudent(Student student) throws ParameterMissingException, IndexNotValidException, StudyProgramNotFoundException {
        if (student.getName() == null || student.getLastName() == null || student.getStudyProgram().getName() == null)
            throw new ParameterMissingException(0);

        if (!checkIndexValidity(student.getIndex()))
            throw new IndexNotValidException(student.getIndex());
        if (studyProgramRepository.findAll().stream().noneMatch(x -> x.getName().equals(student.getStudyProgram().getName())))
            throw new StudyProgramNotFoundException("", student.getStudyProgram().getName());
        return null;
    }

    @Override
    public Student editStudent(String index, String name, String lastName, String studyProgramName) throws StudentNotFoundException {
        Student student = getStudent(index);

        if (studyProgramName != null) {
            StudyProgram sp = studyProgramRepository.findByName(studyProgramName).orElseThrow(() -> new StudyProgramNotFoundInUpdatingStudentException("Study program not found!"));
            student.setStudyProgram(sp);
        }
        if (name != null) {
            student.setName(name);
        }
        if (lastName != null) {
            student.setLastName(lastName);
        }
        return this.studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String index) throws StudentNotFoundException {
        studentRepository.findByIndex(index).orElseThrow(() -> new StudentNotFoundException("Student not found!", index));
        studentRepository.deleteById(index);
    }

}
