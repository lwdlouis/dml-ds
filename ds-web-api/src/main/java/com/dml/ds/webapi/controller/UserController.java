package com.dml.ds.webapi.controller;

import com.dml.ds.domain.db.User;
import com.dml.ds.webapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{staffId}")
    public Mono<User> getUser(@PathVariable String staffId) {
        return userRepository.findByStaffId(staffId);
    }
}
