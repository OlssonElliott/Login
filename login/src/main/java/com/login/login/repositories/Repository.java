package com.login.login.repositories;

import org.springframework.data.repository.CrudRepository;

import com.login.login.models.User;

public interface Repository extends CrudRepository<User, Integer> {

}
