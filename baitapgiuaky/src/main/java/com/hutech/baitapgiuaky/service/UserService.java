package com.hutech.baitapgiuaky.service;

import com.hutech.baitapgiuaky.entities.User;

public interface UserService {

    User save(User user) ;

     User findByUsername(String username) ;
}