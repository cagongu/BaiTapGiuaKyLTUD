package com.hutech.baitapgiuaky.service;

import com.hutech.baitapgiuaky.entities.User;
import com.hutech.baitapgiuaky.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public User save(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username)  {
        return userRepository.findByUsername(username);
    }
}
