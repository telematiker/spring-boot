package fun.with.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fun.with.spring.boot.boundaries.Authentication;
import fun.with.spring.boot.boundaries.Token;
import fun.with.spring.boot.services.ConfiguiredWebServices;

@RestController
public class AuthController implements Authentication {

	@Autowired
	ConfiguiredWebServices configuration;

	@RequestMapping("/test")
	@ResponseBody
	public HttpEntity<String> test() {

		List<Link> services = configuration.getServices();
		for (Link link : services) {
			System.out.println(link.toString());
		}
		
		return new ResponseEntity<String>("test", HttpStatus.OK);
	}

	@Override
	public Token login(String userIdentification, String hashedPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Token validAccess(Token applicationToken, String applicationId) {
		// TODO Auto-generated method stub
		return null;
	}

}
