package com.codingdojo.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.services.BookService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookServ;
	public BookController() {}

	@GetMapping("/create")
	public String createBook(@ModelAttribute("book") Book book, HttpSession session) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/users/login/register";
		}
		return "book/create.jsp";
	}
	
	@PostMapping("/process/create")
	public String processCreateBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "book/create.jsp";
			
		}
		bookServ.create(book);
		return "redirect:/home";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookServ.getOne(id));
		return "book/edit.jsp";
	}
	
	@PatchMapping("process/edit/{id}")
	public String processEditBook(@Valid @ModelAttribute("book") Book book, BindingResult result)
	{
		if(result.hasErrors()) {
			return "book/edit.jsp";
		}
		bookServ.update(book);
		return "redirect:/home";
	}
	
	@GetMapping("/display/{id}")
	public String displayOneBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookServ.getOne(id));
		return "book/showone.jsp";
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookServ.delete(id);
		return "redirect:/home";
	}
	
}
