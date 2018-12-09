package mk.ukim.finki.wp.studentsapi.service;

import mk.ukim.finki.wp.studentsapi.model.StudyProgram;

import java.util.List;

public interface StudyProgramService {
    List<StudyProgram> findAll();
    StudyProgram findById(Long id);
    StudyProgram findByStudyProgramName(String name);
    StudyProgram save(String studyProgramName);
    void delete(Long id);
}
