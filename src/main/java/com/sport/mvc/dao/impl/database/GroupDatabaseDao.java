package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.GroupDao;
import com.sport.mvc.dao.StudentDao;
import com.sport.mvc.models.Group;
import com.sport.mvc.models.Student;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository(value = "groupDatabaseDao")
public class GroupDatabaseDao extends HibernateAbstractDao<Group> implements GroupDao {


    public GroupDatabaseDao() {
    }

    public void   saveToDBGroupIdANdStudentId(Student theStudent, Group theGroup ){
        System.out.println("id student "+theStudent.getId()+"  "+theStudent.getName()+" name st");
        System.out.println("group id "+theGroup.getId()+"  "+theGroup.getName()+" name choose group");

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(theStudent);
        theGroup.setStudents(studentSet);

//        Set<Group> groupSet = new HashSet<>();
//        groupSet.add(theGroup);
//        theStudent.setGroups(groupSet);
        System.out.println("Done");
    }
}
