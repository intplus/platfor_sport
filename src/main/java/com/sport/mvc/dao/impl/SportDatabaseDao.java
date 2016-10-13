package com.sport.mvc.dao.impl;

import com.sport.mvc.dao.SportDao;
import com.sport.mvc.models.Sport;
import org.springframework.stereotype.Repository;

@Repository(value = "SportDatabaseDao")
public class SportDatabaseDao extends HibernateAbstractDao<Sport> implements SportDao {

    public SportDatabaseDao() {
    }

}
