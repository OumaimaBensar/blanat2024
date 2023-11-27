package Ensak.Blanat.Blanat;

import Ensak.Blanat.Blanat.entities.client;
import Ensak.Blanat.Blanat.repositories.clientrepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class BlanatApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlanatApplication.class, args);
	}

	@Bean
	CommandLineRunner init(clientrepository clientRepository) {
		return args -> {
			Stream.of("Hassan", "Yassine", "Aicha").forEach(name -> {
				client client = new client();
				client.setName(name);
				client.setLname("AL"+name);
				client.setEmail(name + "@gmail.com");
				clientRepository.save(client);
			});
		};
	}
}
