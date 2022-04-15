package com.vega.springit.service;

import com.vega.springit.domain.User;
import com.vega.springit.repository.UserRepository;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import javax.transaction.Transactional;


@Service
public class UserService {

    UserRepository userRepository;

    private final Logger logger=  LoggerFactory.getLogger(UserService.class);
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
    @Transactional
    public void saveAll(User... users)
    {
        for (User user: users) {
            logger.info("saving user"+ user.getEmail());
            userRepository.save(user);

        }

    }
}
