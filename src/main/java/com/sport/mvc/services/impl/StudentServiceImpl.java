package com.sport.mvc.services.impl;

import com.sport.mvc.dao.StudentDao;
import com.sport.mvc.models.Student;
import com.sport.mvc.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

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
    public List<Student> getAllByAge(){
        return   studentDao.getAllByAge();
    }

    @Override
    @Transactional
    public List<Student> getStudentAgeAfterSixteen(){

        List<Student> afterSixteenList = new ArrayList<>();

            for (Student s:getAllByAge()){

            int age =Integer.parseInt(s.getAge());
            if(age>=16){
                afterSixteenList.add(s);

            }

        }


        return afterSixteenList;
    }


    @Override
    @Transactional
    public List<Student> getStudentAgeBeforSixteen(){

        List<Student> beforeSixteenList = new ArrayList<>();

        for (Student s:getAllByAge()){

            int age =Integer.parseInt(s.getAge());
            if(age<16){
                beforeSixteenList.add(s);

            }

        }


        return beforeSixteenList;
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
        studentDao.add(student);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        studentDao.update(student);

    }

    @Override
    @Transactional
    public  void deleteListOfStudents(Long id) {
        studentDao.remove(studentDao.getById(id));

    }

    @Transactional
    @Override
    public Student getStudent(long theId) {
     return  studentDao.getById(theId);
}
        }

