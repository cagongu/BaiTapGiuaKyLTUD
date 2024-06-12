package com.hutech.baitapgiuaky.service;

import com.hutech.baitapgiuaky.Exception.UserNotFoundException;
import com.hutech.baitapgiuaky.entities.User;
import com.hutech.baitapgiuaky.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUserByUserName(String username) throws UserNotFoundException {
        Optional<User> user1=userRepository.findByUsername(username);

        if (user1.isPresent()){
            return user1.get();
        }else {
            throw new UserNotFoundException();
        }
    }
    @Override
    public List<User> getAll() throws UserNotFoundException {
        List<User> users=userRepository.findAll();
        if (users.isEmpty()){
            throw new UserNotFoundException();
        }else {
            return users;
        }
    }

    @Override
    public User getUserById(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }

}
