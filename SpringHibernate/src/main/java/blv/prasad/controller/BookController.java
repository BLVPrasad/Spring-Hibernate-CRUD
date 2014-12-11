package blv.prasad.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blv.prasad.domain.Book;
import blv.prasad.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/")
	public String listBooks(Map<String, Object> map) {
		map.put("book", new Book());
		map.put("bookList", bookService.listBooks());
		return "book";
	}

	@RequestMapping(value = "/book/add", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") Book book,
			BindingResult result) {
		if (null == book.getId()) {
			bookService.addBook(book);
		} else {
			bookService.updateBook(book);
		}
		return "redirect:/";
	}

	@RequestMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") Integer bookId) {
		bookService.removeBook(bookId);
		return "redirect:/";
	}

	@RequestMapping("/edit/{bookId}")
	public String editBook(@PathVariable("bookId") Integer bookId,
			Map<String, Object> map) {
		map.put("book", bookService.getBookById(bookId));
		map.put("bookList", bookService.listBooks());
		
		return "book";
	}
}
