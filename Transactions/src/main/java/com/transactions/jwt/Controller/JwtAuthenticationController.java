package com.transactions.jwt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.transactions.Register.Service.RegistrationService;
import com.transactions.Register.model.RegisterDto;
import com.transactions.jwt.Config.JwtTokenUtil;
import com.transactions.jwt.model.JwtReponse;
import com.transactions.jwt.model.JwtRequest;
import com.transactions.jwt.model.UserDto;
import com.transactions.jwt.service.JwtUserDetailsService;



@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private RegistrationService service; 

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		if(token==null)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Does not exits");
			
		}
		return ResponseEntity.ok(new JwtReponse(token));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

//	@RequestMapping(value = "/newuser", method = RequestMethod.POST)
//	public ResponseEntity<?> saveUser(@RequestBody RegisterDto user) throws Exception {
//		return ResponseEntity.ok(service.save(user));
//	}
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			System.out.println("user disabled");
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
}
