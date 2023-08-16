package com.app.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.invoice.entity.Client;
import com.app.invoice.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	@Autowired
	private ClientService clientService;

	@GetMapping("/getClients")
	public ResponseEntity<?> getAllClients() {
		try {
			return new ResponseEntity<List<Client>>(clientService.getClients(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			return new ResponseEntity<>("Bad request", HttpStatus.OK);
		}

	}
	@GetMapping("/getClient/{id}")
	public ResponseEntity<?> getClient(@PathVariable int id){
		try {
			return new ResponseEntity<Client>(clientService.getClient(id),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Bad Request",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/createClient")
	public ResponseEntity<?> createClient(@RequestBody Client client){
		try {
			System.out.println("in controller=================>");
			return new ResponseEntity<Client>(clientService.createClient(client),HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println("in controller exception");
			return new ResponseEntity<>("Bad Request",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateClient")
	public ResponseEntity<?> updateClient(@RequestBody Client client){
		try {
			return new ResponseEntity<Client>(clientService.updateClient(client),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Bad Request",HttpStatus.BAD_REQUEST);
		}
	} 
	@DeleteMapping("/deleteClient/{id}")
	public ResponseEntity<?> deleteClient(@PathVariable int id){
		try {
			return new ResponseEntity<Client>(clientService.deleteClient(id),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Bad Request",HttpStatus.BAD_REQUEST);
		}
	}
}
