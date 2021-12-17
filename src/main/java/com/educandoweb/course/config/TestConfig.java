package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration //falando para o Spring que esta é uma classe especifica de configuração
@Profile("test") //falando que esta classe vai ser uma configuração específica para o perfil de teste. "test" porque estáno application.properties
public class TestConfig implements CommandLineRunner{ //Command necessário para implementar para executar a instanciação quando o programa for iniciado
	
	//injeção de dependência
	@Autowired //associando uma instancias de userRepository no Test
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception { //tudo que estiver dentro deste método vai ser executada quando a aplicação for iniciada

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

		//salvando os 2 usuarios (u1 e u2) no banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2));
	}	
}
