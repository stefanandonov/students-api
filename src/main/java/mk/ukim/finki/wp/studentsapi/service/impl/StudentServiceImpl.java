package mk.ukim.finki.wp.studentsapi.service.impl;

import mk.ukim.finki.wp.studentsapi.model.Student;
import mk.ukim.finki.wp.studentsapi.model.StudyProgram;
import mk.ukim.finki.wp.studentsapi.model.exceptions.IndexNotValidException;
import mk.ukim.finki.wp.studentsapi.model.exceptions.ParameterMissingException;
import mk.ukim.finki.wp.studentsapi.model.exceptions.StudentNotFoundException;
import mk.ukim.finki.wp.studentsapi.model.exceptions.StudyProgramNotFoundException;
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

    private boolean checkIndexValidity (String index) {
        for (char c:
                index.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }

        return index.length()==6;

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(String index) throws StudentNotFoundException {
        return studentRepository.getStudentByIndex(index);
    }

    @Override
    public List<Student> getStudentsByStudyProgram(Long id) {
        return studentRepository.getStudentsByStudyProgram(id);
    }

    @Override
    public Student addStudent(String index, String name, String lastName, String studyProgramName) throws IndexNotValidException, StudyProgramNotFoundException, ParameterMissingException {
        if (name==null || lastName==null || studyProgramName==null)
            throw new ParameterMissingException(0);

        if (!checkIndexValidity(index))
            throw new IndexNotValidException(index);
        if (studyProgramRepository.findAll().stream().filter(x -> x.getName().equals(studyProgramName)).count()==0)
            throw new StudyProgramNotFoundException("",studyProgramName);
        return studentRepository.addStudent(index,name,lastName,studyProgramName);
    }

    @Override
    public Student editStudent(String index, String name, String lastName, String studyProgramName) throws StudentNotFoundException {
        if (studentRepository.getStudentByIndex(index)==null)
            throw new StudentNotFoundException("",index);

        return studentRepository.updateStudent(index,name,lastName,studyProgramName);
    }

    @Override
    public Student deleteStudent(String index) {
        return studentRepository.deleteByIndex(index);
    }

    @Override
    public List<StudyProgram> getAllStudyPrograms() {
        return studyProgramRepository.findAll();
    }

    @Override
    public StudyProgram createStudyProgram(String studyProgramName) {
        return studyProgramRepository.save(studyProgramName);
    }
}
