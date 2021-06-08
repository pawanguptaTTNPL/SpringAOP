package com.example.SpringAOP.repository;

import com.example.SpringAOP.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends  JpaRepository<User,Long> {


}
