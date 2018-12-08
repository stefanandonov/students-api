package mk.ukim.finki.wp.studentsapi.model.exceptions;

public class StudyProgramNotFoundException extends Exception {

    private String studyProgramName;

    public StudyProgramNotFoundException(String message, String studyProgramName) {
        super(studyProgramName+" does not exist");
        this.studyProgramName = studyProgramName;
    }
}
