package com.sport.mvc.dao.impl;

import com.sport.mvc.dao.TypeOfSportDao;
import com.sport.mvc.models.TypeOfSport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "typeOfSportFileDao")
public class TypeOfSportFileDao extends FileAbstractDao<TypeOfSport> implements TypeOfSportDao {

    public TypeOfSportFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<TypeOfSport> getAll() {
        return null;
    }

    @Override
    public TypeOfSport getById(Long id) {
        return null;
    }
}
