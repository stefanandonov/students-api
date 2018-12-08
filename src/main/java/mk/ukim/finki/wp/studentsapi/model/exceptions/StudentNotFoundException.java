package mk.ukim.finki.wp.studentsapi.model.exceptions;

public class StudentNotFoundException extends Exception {

    private String index;

    public StudentNotFoundException(String message, String index) {
        super("Student with index: " + index + "is not found!");
        this.index = index;
    }
}
