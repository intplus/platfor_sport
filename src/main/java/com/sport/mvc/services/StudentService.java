package com.sport.mvc.services;

import com.sport.mvc.dao.StudentDao;
import com.sport.mvc.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "studentService")
public class StudentService {

    @Autowired
    @Qualifier("studentDatabaseDao")
    private StudentDao studentDao;

    public StudentService() {
    }

    @Transactional
    public List<Student> getAll() {
        return studentDao.getAll();
    }

}
