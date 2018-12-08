package mk.ukim.finki.wp.studentsapi.model;

import javax.persistence.*;

@Entity
//@Table(name = "students")
public class Student {

    @Id
    private String index;
    private String name;
    private String lastName;

    @ManyToOne
    private StudyProgram studyProgram;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StudyProgram getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(StudyProgram studyProgram) {
        this.studyProgram = studyProgram;
    }
}
