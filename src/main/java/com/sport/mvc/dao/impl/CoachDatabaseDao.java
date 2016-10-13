package com.sport.mvc.dao.impl;

import com.sport.mvc.dao.CoachDao;
import com.sport.mvc.models.Coach;
import org.springframework.stereotype.Repository;

@Repository(value = "coachDatabaseDao")
public class CoachDatabaseDao extends HibernateAbstractDao<Coach> implements CoachDao {

    public CoachDatabaseDao() {
    }

}
