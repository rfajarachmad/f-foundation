package net.fajarachmad.security.dao.impl;

import net.fajarachmad.common.dao.AbstractDAO;
import net.fajarachmad.security.dao.TenantDAO;
import net.fajarachmad.security.model.Tenant;

import org.springframework.stereotype.Repository;

@Repository
public class TenantDAOImpl extends AbstractDAO<Tenant, String> implements TenantDAO{

}
