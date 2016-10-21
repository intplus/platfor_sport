package com.sport.mvc.authorization.service;



public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
