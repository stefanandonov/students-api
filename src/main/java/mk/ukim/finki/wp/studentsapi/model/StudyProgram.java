package mk.ukim.finki.wp.studentsapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "programs")
public class StudyProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "studyProgram")
    private List<Student> studentList;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
