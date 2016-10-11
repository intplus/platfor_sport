package com.sport.mvc.dao.impl;

import com.sport.mvc.dao.TypeOfSportDao;
import com.sport.mvc.models.TypeOfSport;
import org.springframework.stereotype.Repository;

@Repository(value = "typeOfSportDatabaseDao")
public class TypeOfSportDatabaseDao extends HibernateAbstractDao<TypeOfSport> implements TypeOfSportDao {

    public TypeOfSportDatabaseDao() {
    }

}
