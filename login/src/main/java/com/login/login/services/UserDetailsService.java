package com.login.login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.login.login.models.UserDto;
import com.login.login.repositories.UserRepository;

//Service klass för user, metod för att hämta användare.
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .map(UserDto::new)
                .orElseThrow(() -> new UsernameNotFoundException("Hittade ingen användare"));
    }

}
