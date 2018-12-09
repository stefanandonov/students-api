package mk.ukim.finki.wp.studentsapi.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudyProgramNotFoundException extends RuntimeException {

    private String studyProgramName;

    public StudyProgramNotFoundException(String message) {
        super(message);
    }

    public StudyProgramNotFoundException(String message, String studyProgramName) {
        super(studyProgramName+" does not exist");
        this.studyProgramName = studyProgramName;
    }
}
