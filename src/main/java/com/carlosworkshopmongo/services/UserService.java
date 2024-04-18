package com.carlosworkshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosworkshopmongo.domain.User;
import com.carlosworkshopmongo.repository.UserRepository;

@Service // é para falar para o spring que esta é o serviço que vai ser usado na outras classes
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		 return repo.findAll();
	}

}
