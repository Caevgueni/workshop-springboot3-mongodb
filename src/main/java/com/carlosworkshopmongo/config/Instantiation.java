package com.carlosworkshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.carlosworkshopmongo.domain.User;
import com.carlosworkshopmongo.repository.UserRepository;

@Configuration // isso para spring entender que isso é uma confiiracao
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll(); // isto vai limpar a nossa colecao no mongo db e inserirr novamento os usuarios de baixo
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}
	
	

}
