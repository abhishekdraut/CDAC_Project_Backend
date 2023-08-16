package com.app.invoice.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.invoice.dao.ClientDao;
import com.app.invoice.entity.Client;
import com.app.invoice.entity.User;

@Service
@Transactional
public class ClientService {
	@Autowired
	private ClientDao client;

	public List<Client> getClients() {
		return client.findAll();
	}

	public Client getClient(int id) {
		return client.getReferenceById(id);
	}
	
	public Client createClient(Client data) {
		System.out.println("Admin id ==>");
		return client.save(data);
	}
	public Client updateClient(Client data) throws EntityNotFoundException {
		Client c = client.getReferenceById(data.getId());

		if (data.getName() != null) {
			c.setName(data.getName());
		}
		if (data.getEmail() != null) {
			c.setEmail(data.getEmail());
		}
		if (data.getStatus() != null) {
			c.setStatus(data.getStatus());
		}
		if (data.getPhone() != null) {
			c.setPhone(data.getPhone());
		}
		if (data.getState() != null) {
			c.setState(data.getState());
		}
		if (data.getPostalCode() != null) {
			c.setPostalCode(data.getPostalCode());
		}
		if (data.getCountry() != null) {
			c.setCountry(data.getCountry());
		}
		if (data.getAddress() != null) {
			c.setAddress(data.getAddress());
		}
		if (data.getCity() != null) {
			c.setCity(data.getCity());
		}

		return client.save(c);

	}

	public Client deleteClient(int id) throws EntityNotFoundException{
		Client c=client.getReferenceById(id);
		client.deleteById(id);
		return c;
		
	}
}
