package mk.ukim.finki.wp.studentsapi.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.*;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "ParameterMissingException")
public class ParameterMissingException extends Exception {

    private int parametersCount;

    public ParameterMissingException(int parametersCount){
        this.parametersCount=parametersCount;
    }

    public void message () {
        System.out.println(String.format("You have entered %d parameters, but you need to enter 4 parameters\n", this.parametersCount));
    }
}
