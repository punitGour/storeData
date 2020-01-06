package com.store.main.service;

import org.springframework.data.repository.CrudRepository;

import com.store.main.model.Users;

public interface UserRepository extends CrudRepository<Users, String> {

}
