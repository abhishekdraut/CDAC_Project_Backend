package com.app.invoice.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.invoice.entity.Client;

@Repository

public interface ClientDao extends JpaRepository<Client, Integer> {
	
}
