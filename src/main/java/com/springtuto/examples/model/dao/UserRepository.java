package com.springtuto.examples.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtuto.examples.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
