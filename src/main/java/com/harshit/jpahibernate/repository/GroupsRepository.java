package com.harshit.jpahibernate.repository;

import com.harshit.jpahibernate.repository.model.Groups;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepository extends JpaRepository<Groups, String> {
    
}