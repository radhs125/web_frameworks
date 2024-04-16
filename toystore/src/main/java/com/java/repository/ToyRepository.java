package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.Model.*;
@Repository
public interface ToyRepository extends JpaRepository<User, Integer> {    
}