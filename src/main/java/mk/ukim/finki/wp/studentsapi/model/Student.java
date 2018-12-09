package mk.ukim.finki.wp.studentsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "a_studentss")
public class Student {

    @Id
    @Column(name = "student_index")
    private String index;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_last_name")
    private String lastName;

    @ManyToOne
    private StudyProgram studyProgram;

    public Student() {}

    public Student(String index, String name, String lastName, StudyProgram studyProgram) {
        this.index = index;
        this.name = name;
        this.lastName = lastName;
        this.studyProgram = studyProgram;
    }

    public Student(String index, String name, String lastName) {
        this.index = index;
        this.name = name;
        this.lastName = lastName;
    }

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
