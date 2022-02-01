package pOhjelmointi.BookstoreLeevi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pOhjelmointi.BookstoreLeevi.domain.Book;
import pOhjelmointi.BookstoreLeevi.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value="/books")
	public String bookList(Model model) {
	model.addAttribute("books", repository.findAll());
	return "booklist";
	}
	
	@RequestMapping(value = "/add")
	public String addBook(Model model){
	model.addAttribute("book", new Book(null, null, null, 0, 0));
	return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book){
	repository.save(book);
	return "redirect:books";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id, Model model) {
	repository.deleteById(id);
	return "redirect:../books";
	}
	
	@RequestMapping(value = "edit/{id}")
	public String editbook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		return "editbook";
	}
	
	@GetMapping("/index")
	public String bookStore (Model model) {
		return "index";
	}

}
