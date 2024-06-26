package com.carlosworkshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.carlosworkshopmongo.domain.Post;
import com.carlosworkshopmongo.domain.User;
import com.carlosworkshopmongo.dto.AuthorDTO;
import com.carlosworkshopmongo.repository.PostRepository;
import com.carlosworkshopmongo.repository.UserRepository;

@Configuration // isso para spring entender que isso é uma confiiracao
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postReposiroty;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		
		userRepository.deleteAll(); // isto vai limpar a nossa colecao no mongo db e inserirr novamento os usuarios de baixo
		postReposiroty.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
	
		postReposiroty.saveAll(Arrays.asList(post1, post2));
	
	    maria.getPosts().addAll(Arrays.asList(post1,post2));
	    userRepository.save(maria);
	
	}
	
	

}
