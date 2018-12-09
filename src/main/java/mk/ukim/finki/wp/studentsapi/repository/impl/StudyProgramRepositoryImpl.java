//package mk.ukim.finki.wp.studentsapi.repository.impl;
//
//
//import mk.ukim.finki.wp.studentsapi.model.StudyProgram;
//import mk.ukim.finki.wp.studentsapi.repository.StudyProgramRepository;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository
//@Profile("in-memory-db")
//public class StudyProgramRepositoryImpl  implements StudyProgramRepository {
//    private static List<StudyProgram> studyPrograms;
//
//    public StudyProgramRepositoryImpl () {
//        studyPrograms = new ArrayList<> ();
//    }
//
//    @Override
//    public List<StudyProgram> findAll() {
//        return studyPrograms;
//    }
//
//    @Override
//    public StudyProgram save(String studyProgramName) {
//        StudyProgram sp = new StudyProgram();
//        sp.setName(studyProgramName);
//        studyPrograms.add(sp);
//        return studyPrograms.get(studyPrograms.size()-1);
//    }
//
//    @Override
//    public StudyProgram delete(Long id) {
//        StudyProgram sp = studyPrograms.stream().filter(x -> x.getId()==id).findFirst().orElse(null);
//        if (sp!=null)
//            studyPrograms.remove(sp);
//        return sp;
//    }
//}
