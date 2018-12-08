package mk.ukim.finki.wp.studentsapi.model.exceptions;

public class IndexNotValidException extends Exception {
    private String index;

    public IndexNotValidException(String index){
        this.index=index;
    }

    public void message() {
        System.out.println(index+" is not valid");
    }

}
