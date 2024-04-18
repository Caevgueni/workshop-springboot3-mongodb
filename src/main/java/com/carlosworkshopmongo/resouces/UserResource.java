package com.carlosworkshopmongo.resouces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carlosworkshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	 // @GetMapping tambem funcinava no lugar de " @RequestMapping"
	 @RequestMapping(method=RequestMethod.GET)      // para dizer que este motodo vai ser o enpoint nesse caminho "/users"
	
	public ResponseEntity<List<User>> findAll(){ // metodo que retona uma liata de usuarios "findAll e o metodo que busta td"
		
		User maria = new User("1", "Maria Brown","maria@gmail.com");
		User alex = new User("2", "Alex Green","alaxe@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.ok().body(list);
	}
	

}
