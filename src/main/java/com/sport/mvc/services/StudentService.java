package com.sport.mvc.services;

import com.sport.mvc.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    void addStudent(Student student);

    // void deleteListOfStudents(Long id);

    //test this moment
    void deleteListOfStudents(List<Long> id);

     Student getStudent(long theId);



}
