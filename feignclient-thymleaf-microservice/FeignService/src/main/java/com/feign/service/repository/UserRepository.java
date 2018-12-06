package com.feign.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feign.service.bean.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
