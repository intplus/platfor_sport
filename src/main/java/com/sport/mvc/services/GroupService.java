package com.sport.mvc.services;

import com.sport.mvc.models.Group;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GroupService {
    List<Group> getAll();

    void addStudent(Group group);

    public void deleteListOfGroup(Long id);
}
