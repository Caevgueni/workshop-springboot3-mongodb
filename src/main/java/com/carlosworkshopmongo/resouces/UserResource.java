package com.carlosworkshopmongo.resouces;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carlosworkshopmongo.domain.User;
import com.carlosworkshopmongo.dto.UserDTO;
import com.carlosworkshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	 // @GetMapping tambem funcinava no lugar de " @RequestMapping"
	 @RequestMapping(method=RequestMethod.GET)      // para dizer que este motodo vai ser o enpoint nesse caminho "/users"
	
	   public ResponseEntity<List<UserDTO>> findAll(){ // metodo que retona uma liata de usuarios "findAll e o metodo que busta td"
		
		
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	 
	        @RequestMapping(value= "/{id}", method=RequestMethod.GET)
	        public ResponseEntity<UserDTO> findById(@PathVariable String id){ 
		  
			User obj = service.findById(id);
			return ResponseEntity.ok().body( new UserDTO(obj));
		} 
	        @RequestMapping(method=RequestMethod.POST)
	     	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
	    		User obj = service.fromDTO(objDto);
	    		obj = service.insert(obj);
	    		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	    		return ResponseEntity.created(uri).build();
	    	}
	        @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	     	public ResponseEntity<Void> delete(@PathVariable String id) {
	    		service.delete(id);
	    		return ResponseEntity.noContent().build();
	    	}

}
