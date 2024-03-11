package com.codingdojo.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.models.UserLogin;
import com.codingdojo.bookclub.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public UserService() {}

	
	public User register(User registeringUser) {
		//hash password
			
		String hashed= BCrypt.hashpw(registeringUser.getPassword(), BCrypt.gensalt());
		registeringUser.setPassword(hashed);
		return userRepo.save(registeringUser);
		
		//check if email is taken
		}
		public User getUser(String email) {
			Optional<User> user = userRepo.findByEmail(email);
			return user.isPresent()? user.get() : null;
		}
		
		public User getUser(Long id) {
			Optional<User> user = userRepo.findById(id);
			return user.isPresent()? user.get() : null;
		}
		
		public User create(User user) {
			return userRepo.save(user);
		}
		
		public User login(UserLogin loginUser, BindingResult result) {
			if(result.hasErrors()) {
				return null;
			}
			User existingUser = getUser(loginUser.getEmail());
			if(existingUser ==null) {
				result.rejectValue("email","Unique", "Unknown email");
				return null;
			}
			if(!BCrypt.checkpw(loginUser.getPassword(), existingUser.getPassword())) {
				result.rejectValue("password", "Matches", "Incorrect password");
				return null;
			}
			return existingUser;
		}
}


