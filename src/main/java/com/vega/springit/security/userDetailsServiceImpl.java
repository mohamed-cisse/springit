package com.vega.springit.security;

import com.vega.springit.domain.User;
import com.vega.springit.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public userDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user= userRepository.getUserByEmail(email);

        if(!user.isPresent())
        {
            throw new UsernameNotFoundException(email);
        }
        return user.get();
    }
}
