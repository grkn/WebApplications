package com.grkn.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class CustomAccessDecisionManager extends AbstractAccessDecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication auth, Object arg1,
			Collection<ConfigAttribute> arg2) throws AccessDeniedException,
			InsufficientAuthenticationException {
		
		for (Iterator<? extends GrantedAuthority> it = auth.getAuthorities().iterator();it.hasNext();) {
			GrantedAuthority authority = it.next();
			for(Iterator<ConfigAttribute> iter = arg2.iterator();iter.hasNext();){
				ConfigAttribute conf = iter.next();
				if(authority.getAuthority().matches(conf.toString())){
					return;
				}
			}
		}
		throw new AccessDeniedException("Access Denied. This user has not been granted permission");
	}

	@Override
	public boolean supports(ConfigAttribute configure) {
		return configure.toString().contains("ROLE");
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
