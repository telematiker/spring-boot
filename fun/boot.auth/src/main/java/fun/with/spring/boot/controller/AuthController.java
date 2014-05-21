package fun.with.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fun.with.spring.boot.boundaries.Authentication;
import fun.with.spring.boot.boundaries.Credentials;
import fun.with.spring.boot.boundaries.ExternalService;
import fun.with.spring.boot.boundaries.Token;
import fun.with.spring.boot.boundaries.UserRepository;
import fun.with.spring.boot.impl.TokenFactory;
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
	
	/** The factory. */
	@Autowired
	private TokenFactory factory;

	/**
	 * Test.
	 *
	 * @return the http entity
	 */
	@RequestMapping(value ="/test", method = RequestMethod.GET)
	@ResponseBody
	public HttpEntity<String> test() {

		List<ExternalService> services = configuration.getServices();
		for (ExternalService service : services) {
			System.out.println(service.toString());
		}
		
		List<User> findAll = userStorage.findAll();
		String users = "";
		for (User user : findAll) {
			users+=user+"\n";
		}
		
		
		return new ResponseEntity<String>(users, HttpStatus.OK);
	}
	
	/**
	 * Register.
	 *
	 * @param credentials
	 *            the credentials
	 * @return the http entity
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody	  
	public HttpEntity<Token> register(@RequestBody  Credentials credentials){
		String userIdentification = credentials.getUserIdentification();
		if(userStorage.exists(userIdentification)){
			return new ResponseEntity<Token>(HttpStatus.NOT_ACCEPTABLE);
		}
		User entity = new User(credentials);
		userStorage.save(entity);
		
		return new ResponseEntity<Token>(factory.generateToken(entity), HttpStatus.OK);
		
	}
	
	/**
	 * Entity example.
	 *
	 * @return the http entity
	 */
	@RequestMapping(value = "/example", method = RequestMethod.GET)
	@ResponseBody
	public HttpEntity<Credentials> entityExample(){
		Credentials body = new Credentials("abc","0131");

		return new ResponseEntity<Credentials>(body, HttpStatus.OK);
		
		
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
