package pOhjelmointi.BookstoreLeevi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pOhjelmointi.BookstoreLeevi.domain.User;
import pOhjelmointi.BookstoreLeevi.domain.UserRepository;
import pOhjelmointi.BookstoreLeevi.domain.Book;
import pOhjelmointi.BookstoreLeevi.domain.BookRepository;
import pOhjelmointi.BookstoreLeevi.domain.Category;
import pOhjelmointi.BookstoreLeevi.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreLeeviApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreLeeviApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			crepository.save(new Category("Kauhu"));
			crepository.save(new Category("Fantasia"));
			crepository.save(new Category("Keittokirja"));
			
			brepository.save(new Book("Puppe laivalla", "Esko Aho", "1234567", 20.50, 2020, crepository.findByName("Kauhu").get(0)));
			brepository.save(new Book("Puppe pihalla", "Esko Aho", "1234568", 20.50, 2021, crepository.findByName("Kauhu").get(0)));
			brepository.save(new Book("Puppe ihan pihalla", "Esko Aho", "1234569", 20.50, 2022, crepository.findByName("Kauhu").get(0)));
			
			User user1 = new User("user", "$2a$10$R8ce.TMwGBMttQl4X6cMd.C2jHhTk0IGQKgg0b5WSUmO0fcysdRnC", "USER");
			User user2 = new User("admin", "$2a$10$BEha3HxdOxYGUAC6Xil0jOf6QH/8PpPbrqAXxa.HipkYGClwq6KjO", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			for (Book book : brepository.findAll()) {
				System.out.println("kirja: " + book.toString());
			}
	
		};
	}

}
