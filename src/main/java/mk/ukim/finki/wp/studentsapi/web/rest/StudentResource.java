package mk.ukim.finki.wp.studentsapi.web.rest;

import mk.ukim.finki.wp.studentsapi.model.Student;
import mk.ukim.finki.wp.studentsapi.model.dto.StudentDTO;
import mk.ukim.finki.wp.studentsapi.model.exceptions.IndexNotValidException;
import mk.ukim.finki.wp.studentsapi.model.exceptions.ParameterMissingException;
import mk.ukim.finki.wp.studentsapi.model.exceptions.StudentNotFoundException;
import mk.ukim.finki.wp.studentsapi.model.exceptions.StudyProgramNotFoundException;
import mk.ukim.finki.wp.studentsapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentResource {

    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<StudentDTO> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{index}")
    public Student getStudentByIndex(@PathVariable("index") String index) throws StudentNotFoundException {
        return studentService.getStudent(index);
    }

    @GetMapping("/by_study_program/{id}")
    public List<Student> getStudentByStudyProgramId(@PathVariable("id") Long id) {
        return studentService.getStudentsByStudyProgram(id);
    }

    @PostMapping
    public Student addNewStudent(@RequestParam String index,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) String lastName,
                                 @RequestParam(required = false) String studyProgramName,
                                 HttpServletResponse response) throws ParameterMissingException, IndexNotValidException {

        Student newStudent = studentService.addStudent(index, name, lastName, studyProgramName);
        response.setHeader("Location", "/students/" + index);
        response.setStatus(201);
        return newStudent;

    }

    @PatchMapping("/{index}")
    public Student updateNewStudent(@PathVariable String index,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) String lastName,
                                    @RequestParam(required = false) String studyProgramName
    ) throws StudentNotFoundException {
        return this.studentService.editStudent(index, name, lastName, studyProgramName);
    }

    @DeleteMapping("/{index}")
    public void deleteStudent(@PathVariable String index) throws StudentNotFoundException {
        this.studentService.deleteStudent(index);
    }


}
