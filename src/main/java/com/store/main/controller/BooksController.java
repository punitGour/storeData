package com.store.main.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;

import com.store.main.model.Books;
import com.store.main.service.BooksRepository;
import com.store.main.service.BooksService;

@Controller
public class BooksController {
	
	@Autowired
	private BooksService booksService;
	
	

	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<Books> books = booksService.getAllBooks();
	    model.addAttribute("books", books);
	    return "index";
	}
	
	@GetMapping("/addbooks")
	public String addBooks(Books books) {
		return "add-book";
		
	}
	
	@PostMapping("add")
	 public String addStudent(@Valid Books books, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-student";
        }

        booksService.addBooks(books);
        return "redirect:/";
    }
 
	
	@RequestMapping("/books/{id}")
	public Optional<Books> getBooks(@PathVariable String Id) {
		return booksService.getBook(Id);
		
	}
	
//	@RequestMapping(method = RequestMethod.POST, value = "/books")
//	public void addBook(@RequestBody Books book) {
//		booksService.addBooks(book);
//	}
	
	@GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable String id, Model model) {
        
        model.addAttribute("books", booksService.getBook(id));
        
        return "update-student";
    }
	
	@PostMapping( value = "/update/{id}")
	public String updateBooks(@Valid Books book,@PathVariable("id") String ID, Model model) {
		System.out.println("in update");
		booksService.updateBooks(book, ID);
		List<Books> books = booksService.getAllBooks();
	    model.addAttribute("books", books);
	    
	    return "redirect:/";
	}
	
//	@RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
//	public void deleteBook(@PathVariable String id) {
//		booksService.deleteBooks(id);
//	}
	
	@GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") String id, Model model) {
   //     Optional<Books> books = booksService.getBook(id);
        booksService.deleteBooks(id);
        model.addAttribute("students", booksService.getAllBooks());
        return "redirect:/";
    }

}
