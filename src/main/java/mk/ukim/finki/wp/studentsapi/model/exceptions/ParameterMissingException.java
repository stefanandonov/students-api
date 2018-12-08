package mk.ukim.finki.wp.studentsapi.model.exceptions;

import java.lang.*;

public class ParameterMissingException extends Exception {

    private int parametersCount;

    public ParameterMissingException(int parametersCount){
        this.parametersCount=parametersCount;
    }

    public void message () {
        System.out.println(String.format("You have entered %d parameters, but you need to enter 4 parameters\n", this.parametersCount));
    }
}
