package com.gradle.sample.repository;


import com.gradle.sample.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUsernameAndAndPassword(String username, String password);
    public User findByUsername(String username);

}
