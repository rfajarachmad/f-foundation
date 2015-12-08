package net.fajarachmad.common.dao.imp;

import net.fajarachmad.common.dao.AbstractDAO;
import net.fajarachmad.common.dao.LookupDAO;
import net.fajarachmad.common.model.Lookup;

import org.springframework.stereotype.Repository;

@Repository
public class LookupDAOImpl extends AbstractDAO<Lookup, String> implements LookupDAO{

}
