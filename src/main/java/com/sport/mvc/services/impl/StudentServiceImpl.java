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

        List <Student> listStudentsUpdate = studentDao.getAll();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

            for (int i = 0; i < listStudentsUpdate.size(); ++i) {
                try {
                    listStudentsUpdate.get(i).
                            setAge(Integer.toString(calculateAge(listStudentsUpdate.get(i).getBirthday())));
                    listStudentsUpdate.get(i).
                            setStrBirthday(df.format(listStudentsUpdate.get(i).getBirthday()));
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        return listStudentsUpdate;
    }


    //method, who return list only student with age>16
    @Override
    @Transactional
    public List<Student> getStudentAgeAfterSixteen(){

        List<Student> afterSixteenList = new ArrayList<>();

            for (Student s:getAll()){
                if (s.getBirthday() == null) continue;
                int age = calculateAge(s.getBirthday());
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
            int age = calculateAge(s.getBirthday());

            if (age < 16) {
                beforeSixteenList.add(s);

            }
        }
        return beforeSixteenList;
    }

    public Integer calculateAge(final Date birthday) {

        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.setTime(birthday);
        // include day of birth
        dob.add(Calendar.DAY_OF_MONTH, -1);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }



    @Transactional
    public List<Student> getStudentByOnlyUnknownStudent() {
        List<Student> unknownPhoneList = new ArrayList<>();
        for (Student s : studentDao.getAll()) {
            if (!s.getName().equals("") || !s.getSurname().equals("") || !s.getEmail().equals("")) {
                continue;
            }
            unknownPhoneList.add(s);
        }
        return unknownPhoneList;

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

