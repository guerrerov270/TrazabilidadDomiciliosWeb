package co.uq.pmvpedidos.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.uq.pmvpedidos.app.models.dao.IDireccionDao;
import co.uq.pmvpedidos.app.models.entity.Direccion;

@Service
public class DireccionServiceImpl implements IDireccionService {

	@Autowired
	private IDireccionDao direccionDao;

	@Override
	public List<Direccion> findAll() {
		// TODO Auto-generated method stub
		return (List<Direccion>) direccionDao.findAll();
	}

	@Override
	public void save(Direccion direccion) {
		// TODO Auto-generated method stub
		direccionDao.save(direccion);

	}

	@Override
	@Transactional(readOnly = true)
	public Direccion findOne(Long id) {
		// TODO Auto-generated method stub
		return direccionDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		direccionDao.delete(id);

	}

}
