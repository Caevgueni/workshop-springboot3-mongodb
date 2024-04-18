package com.carlosworkshopmongo.resouces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carlosworkshopmongo.domain.User;
import com.carlosworkshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	 // @GetMapping tambem funcinava no lugar de " @RequestMapping"
	 @RequestMapping(method=RequestMethod.GET)      // para dizer que este motodo vai ser o enpoint nesse caminho "/users"
	
	public ResponseEntity<List<User>> findAll(){ // metodo que retona uma liata de usuarios "findAll e o metodo que busta td"
		
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	

}
