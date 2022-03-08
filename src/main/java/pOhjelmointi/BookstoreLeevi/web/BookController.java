package pOhjelmointi.BookstoreLeevi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pOhjelmointi.BookstoreLeevi.domain.Book;
import pOhjelmointi.BookstoreLeevi.domain.BookRepository;
import pOhjelmointi.BookstoreLeevi.domain.Category;
import pOhjelmointi.BookstoreLeevi.domain.CategoryRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/books")
	public String bookList(Model model) {
	model.addAttribute("books", repository.findAll());
	return "booklist";
	}
	
	@RequestMapping(value = "/add")
	public String addBook(Model model){
	model.addAttribute("book", new Book());
	model.addAttribute("categories", crepository.findAll());
	return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book){
	repository.save(book);
	return "redirect:books";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id, Model model) {
	repository.deleteById(id);
	return "redirect:../books";
	}
	
	@RequestMapping(value = "edit/{id}")
	public String editbook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
	
	@GetMapping("/index")
	public String bookStore (Model model) {
		return "index";
	}

}
