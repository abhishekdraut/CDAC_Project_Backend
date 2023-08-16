package com.app.invoice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.invoice.entity.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
}
