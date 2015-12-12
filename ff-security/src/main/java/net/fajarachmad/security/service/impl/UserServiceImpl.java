package net.fajarachmad.security.service.impl;

import java.util.List;

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
	
	
	

}
