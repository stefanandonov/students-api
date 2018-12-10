package mk.ukim.finki.wp.studentsapi.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends Exception {

    private String index;

    public StudentNotFoundException(String index) {
        super("Student with index: " + index + "is not found!");
        this.index = index;
    }
}
