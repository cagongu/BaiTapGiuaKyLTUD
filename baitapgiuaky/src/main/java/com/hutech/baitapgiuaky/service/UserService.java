package com.hutech.baitapgiuaky.service;


import com.hutech.baitapgiuaky.Exception.UserNotFoundException;
import com.hutech.baitapgiuaky.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User getUserByUserName(String username) throws UserNotFoundException;
    List<User> getAll() throws UserNotFoundException;
    User getUserById(UUID userId);
}
