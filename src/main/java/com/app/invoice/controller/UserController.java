package com.app.invoice.controller;

import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.invoice.entity.AuthenticateObject;
import com.app.invoice.entity.User;
import com.app.invoice.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getAllUser() {
		try {

			return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/getSingleUser/{id}")
	public ResponseEntity<User> getSingleUser(@PathVariable("id") int id) {
		try {

			return new ResponseEntity<User>(userService.getSingleUser(id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/createUser")
	public ResponseEntity<?> postUser(@RequestBody User user) {
		try {
			return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.toString());
			return new ResponseEntity<String>("Bad Request Something wrong !", HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User userData) {
		try {
			return new ResponseEntity<User>(userService.updateUser(userData), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.toString());
			return new ResponseEntity<String>("Bad Request Something wrong !", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
		try {
			return new ResponseEntity<User>(userService.deleteUser(id), HttpStatus.OK);

		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<String>("Data with this id is not exist!", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			System.out.println(e.toString());
			return new ResponseEntity<String>("Bad Request Something wrong !", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/AuthenticateUser")
	public ResponseEntity<?> authenticateUser(@RequestBody AuthenticateObject body) {
		try {
			EntityNotFoundException e = new EntityNotFoundException();
			User u = userService.authenticateUser(body.getUsername(), body.getPassword());
			if (u != null) {
				return new ResponseEntity<User>(u, HttpStatus.OK);
			}
			throw e;
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>("Wrong username or password", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
