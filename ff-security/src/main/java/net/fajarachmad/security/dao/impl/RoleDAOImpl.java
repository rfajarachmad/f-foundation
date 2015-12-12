package net.fajarachmad.security.dao.impl;

import org.springframework.stereotype.Repository;

import net.fajarachmad.common.dao.AbstractDAO;
import net.fajarachmad.security.dao.RoleDAO;
import net.fajarachmad.security.model.Role;

@Repository
public class RoleDAOImpl extends AbstractDAO<Role, String> implements RoleDAO{

}
