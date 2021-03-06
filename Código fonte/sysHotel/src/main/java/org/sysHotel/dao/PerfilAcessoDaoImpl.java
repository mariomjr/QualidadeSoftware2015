package org.sysHotel.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import org.hibernate.Hibernate;
import org.sysHotel.dao.generic.GenericHibernateDao;
import org.sysHotel.entity.PerfilAcesso;
import org.sysHotel.enums.EnumAtivoInativo;
import org.sysHotel.interfaces.IPerfilAcessoDao;

@SuppressWarnings("serial")
@Named("perfilAcessoDao")
public class PerfilAcessoDaoImpl  extends GenericHibernateDao<PerfilAcesso, Long> implements IPerfilAcessoDao{
	
	
	public List<PerfilAcesso> getRegistros() {
		List<PerfilAcesso> listPerfil = super.findAllAtivos();
		for(PerfilAcesso perfil : listPerfil){
			Hibernate.initialize(perfil.getRoles());
		}
		return listPerfil;
	}

	public PerfilAcesso getRegistroID(Long value) {
		return super.getById(value);
	}

	
	public void salvar(PerfilAcesso entity) {
		entity.setAtivoInativo(EnumAtivoInativo.ATIVO);
		super.save(entity);
	}

	
	public void update(PerfilAcesso entity) {
		super.update(entity);
	}

	public void delete(PerfilAcesso entity) {
		super.delete(entity);
		
	}

	public int getQuantRegistros() {
		return super.findAll().size();
	}
}
