package com.harshit.jpahibernate.repository;

import java.math.BigInteger;

import com.harshit.jpahibernate.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, BigInteger>, JpaSpecificationExecutor<User> {}