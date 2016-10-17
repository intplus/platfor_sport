package com.sport.mvc.services;

import com.sport.mvc.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    void addStudent(Student student);

    public void deleteListOfStudents(Long id);

}
