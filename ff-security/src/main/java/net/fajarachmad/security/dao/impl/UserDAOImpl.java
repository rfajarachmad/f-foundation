package net.fajarachmad.security.dao.impl;

import net.fajarachmad.common.dao.AbstractDAO;
import net.fajarachmad.security.dao.UserDAO;
import net.fajarachmad.security.model.User;

import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl extends AbstractDAO<User, String> implements UserDAO{
	

}
