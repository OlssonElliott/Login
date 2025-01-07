package com.login.login.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.login.login.models.User;

public interface LoginRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}
