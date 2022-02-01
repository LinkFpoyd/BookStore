package pOhjelmointi.BookstoreLeevi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pOhjelmointi.BookstoreLeevi.domain.BookRepository;

@SpringBootApplication
public class BookstoreLeeviApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreLeeviApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
	// Your code...add some demo data to db
	};
	}

}
