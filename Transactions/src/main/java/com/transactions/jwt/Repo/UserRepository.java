package com.transactions.jwt.Repo;

import org.springframework.data.repository.CrudRepository;

import com.transactions.jwt.model.UserDao;

public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);
}