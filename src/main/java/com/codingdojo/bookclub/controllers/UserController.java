package com.codingdojo.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.models.UserLogin;
import com.codingdojo.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userServ;

	public UserController() {}

	@GetMapping("/login/register")
	public String loginRegUser(@ModelAttribute("user") User user, @ModelAttribute("loginUser") UserLogin loginUser) {
		return "user/LoginReg.jsp";
	
}
	
	@PostMapping("/process/register")
	public String processRegister(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		//reject if email is taken
		if(userServ.getUser(user.getEmail()) != null) {
			result.rejectValue("email", "Unique", "Email already in use!");
		}
		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("password", "Match", "password dont match");
		}
		//reject if password don't match
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new UserLogin());
			return "user/loginReg.jsp";
		}
		User newUser = userServ.register(user);
		session.setAttribute("user_id", newUser.getId());
		
		//redirect if errors
		return "redirect:/home";
	}
	
	@PostMapping("/process/login")
	public String processLoginUser(@Valid @ModelAttribute("loginUser") UserLogin loginUser, BindingResult result, Model model, HttpSession session) {
		User logginUser = userServ.login(loginUser,  result);
		if (result.hasErrors()) {
			model.addAttribute("user", new User());
			return"user/loginReg.jsp";
		}
		session.setAttribute("user_id", logginUser.getId());
		return "redirect:/home";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/users/login/register";
	}

}
