package mk.ukim.finki.wp.studentsapi.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Index is not valid")
public class IndexNotValidException extends RuntimeException {
    private String index;

    public IndexNotValidException(String index){
        this.index=index;
    }

    public void message() {
        System.out.println(index+" is not valid");
    }

}
