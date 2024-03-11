package com.codingdojo.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private BookService bookServ;
	
	@Autowired
	private UserService userServ;
	
	public HomeController() {}

	@GetMapping("")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/users/login/register";
	}
	model.addAttribute("allBooks", bookServ.getAll());
	return"main/dashboard.jsp";
	
	}
}
