package mk.ukim.finki.wp.studentsapi.repository;

import mk.ukim.finki.wp.studentsapi.model.StudyProgram;

import java.util.List;

public interface StudyProgramRepository {

    List<StudyProgram> findAll ();

    StudyProgram save (String studyProgramName);

    StudyProgram delete (Long id);
}
