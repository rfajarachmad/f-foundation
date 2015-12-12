package net.fajarachmad.security.dao.impl;

import org.springframework.stereotype.Repository;

import net.fajarachmad.common.dao.AbstractDAO;
import net.fajarachmad.security.dao.RegistrationDAO;
import net.fajarachmad.security.model.Registration;

@Repository
public class RegistrationDAOImpl extends AbstractDAO<Registration, String> implements RegistrationDAO {

}
