package com.sport.mvc.services;

import com.sport.mvc.dao.StudentDao;
import com.sport.mvc.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "studentService")
public interface StudentService {
    List<Student> getAll();

  //  void addStudent(Student student);

    public void deleteListOfStudents(Long id);

    public Student getStudent(long theId);

    public void saveStudent(Student theStudent);

}
