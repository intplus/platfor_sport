package com.sport.mvc.services.impl;

import com.sport.mvc.dao.StudentDao;
import com.sport.mvc.models.Student;
import com.sport.mvc.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
                if (s.getBirthday() == null) continue;
                int age = Age(s.getBirthday());
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
            if (s.getBirthday() == null) continue;
            int age = Age(s.getBirthday());
            if (age < 16) {
                beforeSixteenList.add(s);

            }
        }
        return beforeSixteenList;
    }

    private int Age(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy");
        Date today = Calendar.getInstance().getTime();
        int formatToday = Integer.parseInt(df.format(today));
        int formatDate = Integer.parseInt(df.format(date));
        int age = formatToday - formatDate;
        return age;
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

