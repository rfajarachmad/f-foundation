package net.fajarachmad.security.service;

import net.fajarachmad.security.model.User;

public interface UserSevice {
	
	public String save(User user);
	
	public void update(User user);
	
	public User findById(String userGUID);
	
}
