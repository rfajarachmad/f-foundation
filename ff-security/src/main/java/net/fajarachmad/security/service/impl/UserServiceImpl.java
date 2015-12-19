package net.fajarachmad.security.service.impl;

import java.util.List;

import javax.naming.AuthenticationException;

import net.fajarachmad.common.constant.RecordStatus;
import net.fajarachmad.security.constant.UserSourceType;
import net.fajarachmad.security.dao.RoleDAO;
import net.fajarachmad.security.dao.UserDAO;
import net.fajarachmad.security.model.Registration;
import net.fajarachmad.security.model.Role;
import net.fajarachmad.security.model.User;
import net.fajarachmad.security.service.UserSevice;

import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserSevice{
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Override
	@Transactional
	public User createUserRegistration(Registration registration) {
		logger.debug("Creating user registration, registrationGUID {}", new Object[]{registration.getRegistrationGUID()});
		User user = new User();
		BeanUtils.copyProperties(registration, user);
		user.setSourceGUID(registration.getRegistrationGUID());
		user.setSourceTypeId(UserSourceType.REGISTRATION.getTypeId());
		
		//populate default role
		user.setRoles(getDefaultRole());
		
		userDAO.insert(user);
		
		return user;
	}
	
	@Transactional(readOnly=true)
	private List<Role> getDefaultRole() {
		List<Role> defaultRoles = roleDAO.findByCriteria(Restrictions.eq("initialRole", true),
				Restrictions.eq("recordStatus", RecordStatus.ACTIVE.getValue()));
		return defaultRoles;
	}
	
	@Override
	@Transactional(readOnly=true)
	public User authenticate(String username, String password) throws AuthenticationException {
		
		List<User> users = userDAO.findByCriteria(Restrictions.eq("username", username));
		
		if (!users.isEmpty()) {
			User user = users.get(0);
			if (user.getPassword().equals(password)) {
				return user;
			} else {
				throw new AuthenticationException("username and password are not correct");
			}
		} else {
			throw new AuthenticationException("User is not registered for user "+username);
		}
	}
	

}
