package com.sport.mvc.services;

import com.sport.mvc.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    void addStudent(Student student);

    public void deleteListOfStudents(List <Long> id);

    public Student getStudent(long theId);

//    public void saveStudent(Student theStudent);

}
