package com.harshit.jpahibernate.repository;

import com.harshit.jpahibernate.repository.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    
}