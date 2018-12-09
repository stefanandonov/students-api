package mk.ukim.finki.wp.studentsapi.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class StudyProgramNotFoundInUpdatingStudentException extends RuntimeException {
    public StudyProgramNotFoundInUpdatingStudentException(String msg) {
        super(msg);
    }
}
