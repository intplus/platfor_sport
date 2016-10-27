package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.StudentDao;
import com.sport.mvc.dao.impl.database.HibernateAbstractDao;
import com.sport.mvc.models.Group;
import com.sport.mvc.models.Student;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;


@Repository(value = "studentDatabaseDao")
public class StudentDatabaseDao extends HibernateAbstractDao<Student> implements StudentDao {

    public StudentDatabaseDao() {
    }



}



