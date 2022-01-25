package pOhjelmointi.BookstoreLeevi.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
	
	@GetMapping("/index")
	public String bookStore (Model model) {
		return "index";
	}

}
