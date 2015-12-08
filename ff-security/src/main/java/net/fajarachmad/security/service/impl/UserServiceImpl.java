package net.fajarachmad.security.service.impl;

import net.fajarachmad.security.dao.UserDAO;
import net.fajarachmad.security.model.User;
import net.fajarachmad.security.service.UserSevice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserSevice{
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	public String save(User user) {
		logger.debug("Saving user, {}", new Object[]{user});
		return userDAO.insert(user);
	}
	
	@Transactional
	public void update(User user) {
		logger.debug("Updating user, {}", new Object[]{user});
		userDAO.update(user);
	}
	
	@Transactional(readOnly=true)
	public User findById(String userGUID) {
		logger.debug("Find user by id, {}", new Object[]{userGUID});
		return userDAO.findById(userGUID);
	}
	
	

}
