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


//
//    // method with select only data  witch age . The first implementation in HibernateAbstractDao
//    @Override
//    @Transactional
//    public List<Student> getAllByAge(){
//        return   studentDao.getAllByAge();
//    }


    //method, who return list only student with age>16
    @Override
    @Transactional
    public List<Student> getStudentAgeAfterSixteen(){

        List<Student> afterSixteenList = new ArrayList<>();

        for (Student s:getAll()){
            System.err.println(s.getAge());
            if (s.getAge() == null) continue;
            int age =Integer.parseInt(s.getAge());
            System.out.println("age = " + age);
            if(age>=16){
                afterSixteenList.add(s);
            }
        }
        return afterSixteenList;
    }

    // method, who return list only student with age<16
    @Override
    @Transactional
    public List<Student> getStudentAgeBeforSixteen(){

        List<Student> beforeSixteenList = new ArrayList<>();

        for (Student s:getAll()){
            if (s.getAge() == null) continue;
            int age =Integer.parseInt(s.getAge());
            if (age < 16) {
                beforeSixteenList.add(s);

            }
        }
        return beforeSixteenList;
    }


    // dont work
    @Transactional
    public List<Student> getStudentByOnlyUnknownStudentTwo(){
        System.out.println("in method");
        List<Student> unknownPhoneList =new ArrayList<>();

        for (Student s: studentDao.getAll()){
            System.out.println(s.getSurname());
            if( s.getPhone()!=null && s.getName()==null  && s.getSurname()==null &&
                    s.getEmail()==null   ||
                    s.getPhone()!="" && s.getName()=="" && s.getSurname()=="" &&
                            s.getEmail()==""  ){
                System.out.println("in if statment" + s.getPhone());
                unknownPhoneList.add(s);
            }
        }

        return  unknownPhoneList;

    }

    // method , hwom return unknown student date( it's if you have only phone number and maby age).
    @Override
    @Transactional
    public List<Student> getStudentByOnlyUnknownStudent(){
        return studentDao.getStudentByOnlyUnknownStudent();
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

