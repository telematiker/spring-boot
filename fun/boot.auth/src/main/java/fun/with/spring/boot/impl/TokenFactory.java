package fun.with.spring.boot.impl;

import org.springframework.stereotype.Service;

import fun.with.spring.boot.boundaries.Token;
import fun.with.spring.boot.boundaries.Token.Type;

@Service
public class TokenFactory {

	public Token generateToken(User user){
		return new TokenImpl(user.getHashedPassword(), Type.SESSION);
	}
	
}
