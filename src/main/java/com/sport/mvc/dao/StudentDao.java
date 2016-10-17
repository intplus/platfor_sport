package com.sport.mvc.dao;

import com.sport.mvc.models.Student;

import java.util.List;

public interface StudentDao extends ItemDao<Student> {

    public Student getByUsername(String username);

    public void deleteListOfStudents(List<Long> id);

}
