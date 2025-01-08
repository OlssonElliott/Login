package com.login.login.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.login.login.models.User;

@Repository
public interface LoginRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
