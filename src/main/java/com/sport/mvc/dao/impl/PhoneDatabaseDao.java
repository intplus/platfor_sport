package com.sport.mvc.dao.impl;

import com.sport.mvc.dao.PhoneDao;
import com.sport.mvc.models.Phone;
import org.springframework.stereotype.Repository;

@Repository(value = "phoneDatabaseDao")
public class PhoneDatabaseDao extends HibernateAbstractDao<Phone> implements PhoneDao {

    public PhoneDatabaseDao() {
    }

}
