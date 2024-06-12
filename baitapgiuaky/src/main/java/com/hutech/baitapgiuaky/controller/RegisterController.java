package com.hutech.baitapgiuaky.controller;

import com.hutech.baitapgiuaky.entities.Role;
import com.hutech.baitapgiuaky.entities.User;
import com.hutech.baitapgiuaky.repository.RoleRepository;
import com.hutech.baitapgiuaky.repository.UserRepository;
import com.hutech.baitapgiuaky.response.RegisterRequest;
import com.hutech.baitapgiuaky.service.PasswordEncoderImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequiredArgsConstructor
public class RegisterController {
    private static final String REGISTER_PATH = "/api/auth/register";

    @Autowired
    private PasswordEncoderImpl passwordEncoder;

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping(REGISTER_PATH)
    public ResponseEntity<User> registerUser(@RequestBody RegisterRequest registerRequest) {
        User user = repository.findByUsername(registerRequest.getUsername()).orElse(null);

        if (user == null){
            user = User.builder()
                    .username(registerRequest.getUsername())
                    .email(registerRequest.getEmail())
                    .build();
            String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
            user.setPassword(encodedPassword);

            Role role = roleRepository.findByName("USER");
            user.addRole(role);

            repository.save(user);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", REGISTER_PATH + "/" + user.getUserId().toString());

            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        else  return ResponseEntity.badRequest().build();
    }
}
