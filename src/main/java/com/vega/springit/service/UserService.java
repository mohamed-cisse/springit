package com.vega.springit.service;

import com.vega.springit.domain.User;
import com.vega.springit.repository.UserRepository;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {

    UserRepository userRepository;

    private final Logger logger= (Logger) LoggerFactory.getLogger(UserService.class);
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User regester(User user)
    {
     return user;
    }

    public User save(User user)
    {
        return userRepository.save(user);
    }
}
