package mk.ukim.finki.wp.studentsapi.web.rest;

import mk.ukim.finki.wp.studentsapi.model.StudyProgram;
import mk.ukim.finki.wp.studentsapi.service.StudyProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/study_programs", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudyProgramResource {
    private final StudyProgramService studyProgramService;

    public StudyProgramResource(StudyProgramService studyProgramService) {
        this.studyProgramService = studyProgramService;
    }


    @GetMapping
    public List<StudyProgram> getAllStudyPrograms () {
        return studyProgramService.findAll();
    }


    @GetMapping("/{id}")
    StudyProgram getStudyProgramById(@PathVariable Long id) {
        return studyProgramService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudyProgram addNewStudyProgram (@RequestParam String name, HttpServletResponse response)   {

        StudyProgram sp = studyProgramService.save(name);
        response.setStatus(201);
        response.setHeader("Location", "/study_programs");
        return sp;
    }

    @DeleteMapping("/{id}")
    public void deleteStudyProgramById(@PathVariable Long id) {
        this.studyProgramService.delete(id);
    }

}
