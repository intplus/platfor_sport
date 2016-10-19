//package com.sport.mvc.services.impl;
//
//import com.sport.mvc.dao.StudentDao;
//import com.sport.mvc.dao.UserDao;
//import com.sport.mvc.models.Student;
//import com.sport.mvc.models.User;
//import com.sport.mvc.services.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service(value = "studentService")
//public class StudentServiceImpl implements StudentService {
//
//    @Qualifier("studentDatabaseDao")
//    @Autowired
//    private StudentDao studentDao;
//
//    public StudentServiceImpl() {
//    }
//
//
//    @Transactional
//    public List<Student> getAll() {
//        return studentDao.getAll();
//    }
//
//    @Override
//    @Transactional
//    public void addStudent(Student student) {
//        studentDao.add(student);
//    }
//
//
//    @Override
//    @Transactional
//    public void deleteListOfStudents(Long id) {
//        studentDao.remove(studentDao.getById(id));
//    }
//
//    @Override
//    public Student getStudent(long theId) {
//<<<<<<< HEAD
//        return null;
//    }
//
//    @Override
//    public void saveStudent(Student theStudent) {
//
//    }
//=======
//
//        return studentDao.getById(theId);
//    }
////
////    @Override
////    public void saveStudent(Student theStudent) {
////        studentDao.add(theStudent);
////    }
//
//>>>>>>> locatTestMerge
//}
