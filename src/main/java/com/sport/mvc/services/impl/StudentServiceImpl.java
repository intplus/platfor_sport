package com.sport.mvc.services.impl;

import com.sport.mvc.dao.StudentDao;
import com.sport.mvc.dao.UserDao;
import com.sport.mvc.models.Student;
import com.sport.mvc.models.User;
import com.sport.mvc.services.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    SessionFactory sessionFactory;

    @Qualifier("studentDatabaseDao")
    @Autowired
    private StudentDao studentDao;

    public StudentServiceImpl() {
    }


    @Transactional
    public List<Student> getAll() {
        return studentDao.getAll();
    }

//    @Override
//    @Transactional
//    public void addStudent(Student student) {
//        studentDao.add(student);
//    }

    @Transactional
    @Override
    public void deleteListOfStudents(Long id) {
        studentDao.remove(studentDao.getById(id));
    }

    @Transactional
    @Override
    public Student getStudent(long theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Student theStudent = currentSession.get(Student.class, theId);

        return theStudent;
    }

    @Transactional
    @Override
    public void saveStudent(Student theStudent) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save the customer
        currentSession.saveOrUpdate(theStudent);
    }

}
