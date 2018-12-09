package mk.ukim.finki.wp.studentsapi.web.rest;

import mk.ukim.finki.wp.studentsapi.model.StudyProgram;
import mk.ukim.finki.wp.studentsapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/study_programs", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudyProgramResource {
    private final StudentService studentService;

    @Autowired
    public StudyProgramResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudyProgram> getAllStudyPrograms () {
        return studentService.getAllStudyPrograms();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<StudyProgram> addNewStudyProgram (@RequestBody String name, HttpServletResponse response)   {

        studentService.createStudyProgram(name);
        response.setStatus(201);
        response.setHeader("Location", "/study_programs");
        return studentService.getAllStudyPrograms();
    }

    //@DeleteMapping

}
