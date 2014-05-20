package fun.with.spring.boot.impl;

import org.springframework.data.annotation.Id;

import fun.with.spring.boot.controller.Credentials;

public class User {

	@Id
	private String userIdentification;

	private String hashedPassword;

	public User() {
	}

	public User(Credentials credentials) {
    	this(credentials.getUserIdentification(), credentials.getHashedPassword());
    }

	public User(String userIdentification, String hashedPassword) {
		this.userIdentification = userIdentification;
		this.hashedPassword = hashedPassword;
	}

	@Override
	public String toString() {
		return "User [userIdentification=" + userIdentification
				+ ", hashedPassword=" + hashedPassword + "]";
	}

}
