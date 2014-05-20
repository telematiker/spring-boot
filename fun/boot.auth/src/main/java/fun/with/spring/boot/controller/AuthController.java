package fun.with.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fun.with.spring.boot.boundaries.Authentication;
import fun.with.spring.boot.boundaries.Credentials;
import fun.with.spring.boot.boundaries.ExternalService;
import fun.with.spring.boot.boundaries.Token;
import fun.with.spring.boot.boundaries.UserRepository;
import fun.with.spring.boot.impl.User;
import fun.with.spring.boot.services.ConfiguiredWebServices;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthController.
 */
@RestController
public class AuthController implements Authentication {

	/** The configuration. */
	@Autowired
	private ConfiguiredWebServices configuration;
	
	/** The user storage. */
	@Autowired
	private UserRepository userStorage;	

	/**
	 * Test.
	 *
	 * @return the http entity
	 */
	@RequestMapping("/test")
	@ResponseBody
	public HttpEntity<String> test() {

		List<ExternalService> services = configuration.getServices();
		for (ExternalService service : services) {
			System.out.println(service.toString());
		}
		
		List<User> findAll = userStorage.findAll();
		String users = "";
		for (User user : findAll) {
			users+=users+"\n";
		}
		
		
		return new ResponseEntity<String>(users, HttpStatus.OK);
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public HttpEntity<Token> register(Credentials credentials){
		if(userStorage.exists(credentials.getUserIdentification())){
			return new ResponseEntity<Token>(HttpStatus.NOT_ACCEPTABLE);
		}
		userStorage.save(new User(credentials));
		
		return new ResponseEntity<Token>(HttpStatus.OK);
		
	}

	/* (non-Javadoc)
	 * @see fun.with.spring.boot.boundaries.Authentication#login(java.lang.String, java.lang.String)
	 */
	@Override
	public Token login(String userIdentification, String hashedPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fun.with.spring.boot.boundaries.Authentication#validAccess(fun.with.spring.boot.boundaries.Token, java.lang.String)
	 */
	@Override
	public Token validAccess(Token applicationToken, String applicationId) {
		// TODO Auto-generated method stub
		return null;
	}

}
