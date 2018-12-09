//package mk.ukim.finki.wp.studentsapi.repository.impl;
//
//import mk.ukim.finki.wp.studentsapi.model.Student;
//import mk.ukim.finki.wp.studentsapi.model.exceptions.StudentNotFoundException;
//import mk.ukim.finki.wp.studentsapi.repository.StudentRepository;
//import mk.ukim.finki.wp.studentsapi.repository.StudyProgramRepository;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Repository;
//import mk.ukim.finki.wp.studentsapi.model.*;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Repository
//@Profile("in-memory-db")
//public class StudentRepositoryImpl implements StudentRepository {
//
//    private static List<Student> students;
//
//    public StudentRepositoryImpl() {
//        students = new ArrayList<>();
//        Student s = new Student();
//        s.setIndex("151020");
//        s.setName("Stefan");
//        s.setLastName("Andonov");
//        StudyProgram sp = new StudyProgram();
//        sp.setId((long) 1);
//        sp.setName("KNI");
//
//        s.setStudyProgram(sp);
//
//        students.add(s);
//    }
//
//
//    @Override
//    public List<Student> findAll() {
//        return students;
//    }
//
//    @Override
//    public Student getStudentByIndex(String index) {
//
//        return students.stream().filter(x -> x.getIndex().equals(index)).findFirst().orElse(null);
//
//    }
//
//    @Override
//    public List<Student> getStudentsByStudyProgram(Long id) {
//
//        return students.stream().filter(x -> x.getStudyProgram().getId().equals(id)).collect(Collectors.toList());
//    }
//
//    @Override
//    public Student addStudent(String index, String name, String lastName, String studyProgramName) {
//        Student s = new Student();
//        s.setIndex(index);
//        s.setName(name);
//        s.setLastName(lastName);
//        StudyProgram sp = new StudyProgram();
//        sp.setName(studyProgramName);
//        s.setStudyProgram(sp);
//
//        students.add(s);
//        return students.get(students.size() - 1);
//    }
//
//    @Override
//    public Student deleteByIndex(String index) {
//        Student s = students.stream().filter(x -> x.getIndex().equals(index)).findFirst().orElse(null);
//        if (s != null)
//            students.remove(s);
//        return s;
//    }
//
//    @Override
//    public Student updateStudent(String index, String name, String lastName, String studyProgramName) {
//        students.stream().filter(x -> x.getIndex().equals(index)).forEach(x -> {
//            if (name != null)
//                x.setName(name);
//            if (lastName != null)
//                x.setLastName(lastName);
//            /*TODO
//            Implement change of studyProgram by the studyProgramName
//             *  */
//
//        });
//
//        return students.stream().filter(x -> x.getIndex().equals(index)).findFirst().orElse(null);
//    }
//}
