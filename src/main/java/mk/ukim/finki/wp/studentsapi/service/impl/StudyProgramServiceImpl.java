package mk.ukim.finki.wp.studentsapi.service.impl;

import mk.ukim.finki.wp.studentsapi.model.StudyProgram;
import mk.ukim.finki.wp.studentsapi.model.exceptions.StudyProgramNotFoundException;
import mk.ukim.finki.wp.studentsapi.repository.StudyProgramRepository;
import mk.ukim.finki.wp.studentsapi.service.StudyProgramService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyProgramServiceImpl implements StudyProgramService {

    private final StudyProgramRepository studyProgramRepository;

    public StudyProgramServiceImpl(StudyProgramRepository studyProgramRepository) {
        this.studyProgramRepository = studyProgramRepository;
    }

    @Override
    public List<StudyProgram> findAll() {
        return studyProgramRepository.findAll();
    }

    @Override
    public StudyProgram findById(Long id) {
        return studyProgramRepository.findById(id).orElseThrow(() -> new StudyProgramNotFoundException("Study program is not found!"));
    }

    @Override
    public StudyProgram findByStudyProgramName(String name) {
        return studyProgramRepository.findByName(name).orElseThrow(() -> new StudyProgramNotFoundException("Study program is not found!", name));
    }

    @Override
    public StudyProgram save(String studyProgramName) {
        StudyProgram sp = new StudyProgram();
        sp.setName(studyProgramName);
        return studyProgramRepository.save(sp);
    }

    @Override
    public void delete(Long id) {
        studyProgramRepository.deleteById(id);
    }
}
