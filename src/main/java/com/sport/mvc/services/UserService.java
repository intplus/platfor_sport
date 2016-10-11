package com.sport.mvc.services;

import com.sport.mvc.dao.UserDao;
import com.sport.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userService")
public class UserService {

    @Autowired
    @Qualifier("userDatabaseDao")
    private UserDao userDao;

    public UserService() {
    }


    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }

}
