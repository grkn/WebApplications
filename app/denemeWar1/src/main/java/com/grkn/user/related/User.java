package com.grkn.user.related;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.grkn.dao.layer.UserDao;
import com.grkn.dao.models.UserModel;
import com.grkn.user.interfaces.AppMessage;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope(value="prototype")
public class User extends ActionSupport implements AppMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2502323202231227632L;

	@Autowired
	private UserDao userDao;
	
	private List<UserModel> userList;
	
	private String helloString;
	
	public String getHelloString() {
		return helloString;
	}

	public void setHelloString(String helloString) {
		this.helloString = helloString;
	}

	
	public String initialize() {
		userList = userDao.getUsers();
		System.out.println("User List : "+userList.size());
		return SUCCESS;
	}

	@Override
	public String prepareMessage() {
		return "Hello From User.java";
	}	
}
