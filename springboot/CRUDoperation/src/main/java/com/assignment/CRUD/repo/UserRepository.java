package com.assignment.CRUD.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.assignment.CRUD.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
