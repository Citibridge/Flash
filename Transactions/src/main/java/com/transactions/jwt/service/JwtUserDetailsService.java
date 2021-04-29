package com.transactions.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.transactions.jwt.Repo.UserRepository;
import com.transactions.jwt.model.UserDao;
import com.transactions.jwt.model.UserDto;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDao user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public ResponseEntity<?> save(UserDto user) {
		
		UserDao check = userDao.findByUsername(user.getUsername());
		UserDao newUser = new UserDao();
		if (check != null) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exits");
		}
		else
		{			
			newUser.setUsername(user.getUsername());
			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			newUser.setfName(user.getfName());
			newUser.setlName(user.getlName());
			newUser.setEmail(user.getEmail());
		}
		
		return ResponseEntity.ok(userDao.save(newUser));
	}
}