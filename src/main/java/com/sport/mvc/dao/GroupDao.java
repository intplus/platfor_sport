package com.sport.mvc.dao;

import com.sport.mvc.models.Group;

public interface GroupDao extends ItemDao<Group> {

    void saveToDBGroupIdANdStudentId(Long studentId, Long groupId);
}
