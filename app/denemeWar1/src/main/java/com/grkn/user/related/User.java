package com.grkn.user.related;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.grkn.user.interfaces.AppMessage;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope(value="prototype")
public class User extends ActionSupport implements AppMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2502323202231227632L;

	private String helloString;
	
	public String getHelloString() {
		return helloString;
	}

	public void setHelloString(String helloString) {
		this.helloString = helloString;
	}

	
	public String initialize() {
		helloString = prepareMessage();
		return SUCCESS;
	}

	@Override
	public String prepareMessage() {
		return "Hello From User.java";
	}
	
}
