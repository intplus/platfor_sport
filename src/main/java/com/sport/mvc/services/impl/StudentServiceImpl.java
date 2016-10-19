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

//    @Autowired
//    SessionFactory sessionFactory;

    @Qualifier("studentDatabaseDao")
    @Autowired
    private StudentDao studentDao;

    public StudentServiceImpl() {
    }


    @Transactional
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
        studentDao.add(student);
    }


//    @Override
//    @Transactional
//    public void deleteListOfStudents(Long id) {
//        studentDao.remove(studentDao.getById(id));
//
//    }

    //test this moment
//    @Transactional
//    @Override
//    public void deleteListOfStudents(List<Long> id) {
//        studentDao.deleteListOfStudents(id);
//    }
    @Transactional
    @Override
    public void deleteListOfStudents(List<Long> ids) {
        System.out.println("in method delete");
//        Session session = sessionFactory.getCurrentSession();
        for (int i = 0; i < ids.size(); i++) {
//            Student students = (Student) session.load(Student.class, new Long(id.get(i)));
            if (ids != null)
                studentDao.remove(getStudent(i));
        }
    }



    @Transactional
    @Override
    public Student getStudent(long theId) {
        return  studentDao.getById(theId);
    }



}
