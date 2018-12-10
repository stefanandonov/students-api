package mk.ukim.finki.wp.studentsapi.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.*;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "ParameterMissingException")
public class ParameterMissingException extends Exception {

    private int parametersCount;

    public ParameterMissingException(int parametersCount){
        super (String
                .format("%d parameters are missing\n", 3-parametersCount));
        this.parametersCount=parametersCount;
    }


}
