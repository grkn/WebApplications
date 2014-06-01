package com.grkn.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.grkn.dao.layer.UserDao;
import com.grkn.dao.models.UserModel;

@Component
public class UserService implements UserDetailsService{

	@Autowired
	UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		UserModel user = userDao.getUserByUsername(userName);
		if(user == null){
			throw new UsernameNotFoundException("User Not Found");
		}
		Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE1","ROLE2","ROLE3");
		return new User(user.getName(), user.getPassword(), authorities);
	}

}
