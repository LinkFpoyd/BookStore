package pOhjelmointi.BookstoreLeevi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pOhjelmointi.BookstoreLeevi.domain.Book;
import pOhjelmointi.BookstoreLeevi.domain.BookRepository;

@SpringBootApplication
public class BookstoreLeeviApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreLeeviApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			
			repository.save(new Book("Puppe laivalla", "Esko Aho", "1234567", 20.50, 2020));
			repository.save(new Book("Puppe pihalla", "Esko Aho", "1234568", 20.50, 2021));
			repository.save(new Book("Puppe ihan pihalla", "Esko Aho", "1234569", 20.50, 2022));
			
			
			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
			}
	
		};
	}

}
