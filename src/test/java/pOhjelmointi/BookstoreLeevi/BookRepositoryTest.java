package pOhjelmointi.BookstoreLeevi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import pOhjelmointi.BookstoreLeevi.domain.Book;
import pOhjelmointi.BookstoreLeevi.domain.BookRepository;
import pOhjelmointi.BookstoreLeevi.domain.Category;
import pOhjelmointi.BookstoreLeevi.domain.CategoryRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	CategoryRepository cRepo;
	
	@Test
	public void findByTitleShouldReturnAuthor() {
		List<Book> books = bookRepo.findByTitle("Puppe laivalla");
		assertThat(books.get(0).getTitle()).isEqualTo("Puppe laivalla");
	}
	
	@Test
	public void findByTitleShouldReturnSize() {
		List<Book> books = bookRepo.findByTitle("Puppe laivalla");
		assertThat(books).hasSize(1);
	}
	
	@Test
	public void insertNewBook() {
		Book book = new Book("Puppe ruotsinlaivalla", "Juha Sipsilä", "123657", 200, 2014, cRepo.findByName("Kauhu").get(0));
		bookRepo.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test 
	public void deleteBook() {
		List<Book> books = bookRepo.findByTitle("Puppe laivalla");
		Book dbook = books.get(0);
		bookRepo.delete(dbook);
		List<Book> dbooks = bookRepo.findByTitle("Puppe laivalla");
		assertThat(dbooks).hasSize(0);
	}
	
	@Test
	public void findByNameShouldReturnSize() {
		List<Category> categories = cRepo.findByName("Kauhu");
		assertThat(categories).hasSize(1);
	}
	
	@Test
	public void insertNewCategory() {
		Category cgory = new Category("Kalastus");
		cRepo.save(cgory);
		assertThat(cgory.getId()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		List<Category> cgories = cRepo.findByName("Kauhu");
		Category cgory = cgories.get(0);
		cRepo.delete(cgory);
		List<Category> cgoriesdel = cRepo.findByName("Kauhu");
		assertThat(cgoriesdel).hasSize(0);
	}

}
