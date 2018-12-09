package mk.ukim.finki.wp.studentsapi.model.dto;

public class StudentDTO {
    public String index;
    public String name;
    public String lastName;

    public StudentDTO(String index, String name, String lastName) {
        this.index = index;
        this.name = name;
        this.lastName = lastName;
    }
}
