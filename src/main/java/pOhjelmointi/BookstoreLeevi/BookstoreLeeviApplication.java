package pOhjelmointi.BookstoreLeevi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pOhjelmointi.BookstoreLeevi.domain.Book;
import pOhjelmointi.BookstoreLeevi.domain.BookRepository;
import pOhjelmointi.BookstoreLeevi.domain.Category;
import pOhjelmointi.BookstoreLeevi.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreLeeviApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreLeeviApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
//		return (args) -> {
//			
//			crepository.save(new Category("Kauhu"));
//			crepository.save(new Category("Fantasia"));
//			crepository.save(new Category("Keittokirja"));
//			
//			brepository.save(new Book("Puppe laivalla", "Esko Aho", "1234567", 20.50, 2020, crepository.findByName("Kauhu").get(0)));
//			brepository.save(new Book("Puppe pihalla", "Esko Aho", "1234568", 20.50, 2021, crepository.findByName("Kauhu").get(0)));
//			brepository.save(new Book("Puppe ihan pihalla", "Esko Aho", "1234569", 20.50, 2022, crepository.findByName("Kauhu").get(0)));
//			
//			
//			for (Book book : brepository.findAll()) {
//				System.out.println("kirja: " + book.toString());
//			}
//	
//		};
//	}

}
