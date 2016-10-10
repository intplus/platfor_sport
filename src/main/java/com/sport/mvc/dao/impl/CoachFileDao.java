package com.sport.mvc.dao.impl;

import com.sport.mvc.dao.CoachDao;
import com.sport.mvc.models.Coach;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "coachFileDao")
public class CoachFileDao extends FileAbstractDao<Coach> implements CoachDao {
    public CoachFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<Coach> getAll() {
        return null;
    }

    @Override
    public Coach getById(Long id) {
        return null;
    }
}
