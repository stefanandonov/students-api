package mk.ukim.finki.wp.studentsapi.web.rest;

import mk.ukim.finki.wp.studentsapi.model.Student;
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
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{index}")
    public Student getStudentByIndex (@PathVariable("index") String index) throws StudentNotFoundException {
        return studentService.getStudent(index);
    }

    @GetMapping("/by_study_program/{id}")
    public List<Student> getStudentByStudyProgramId (@PathVariable("id") Long id)  {
        return studentService.getStudentsByStudyProgram(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Student> addNewStudent (@RequestBody Student student, HttpServletResponse response) {
        try {
            Student newStudent = studentService.addStudent(student);
            response.setHeader("Location", "/students/"+student.getIndex());
            response.setStatus(201);
            return studentService.getAllStudents();
        } catch (ParameterMissingException e) {
            e.printStackTrace();
            /* response.getOutputStream().write() */
            response.setStatus(400);
        } catch (IndexNotValidException e) {
            e.printStackTrace();
            response.setStatus(400);
        } catch (StudyProgramNotFoundException e) {
            e.printStackTrace();
            response.setStatus(400);
        }

        return studentService.getAllStudents();
    }






}
