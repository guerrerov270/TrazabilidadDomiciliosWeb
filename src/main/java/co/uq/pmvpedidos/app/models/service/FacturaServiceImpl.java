package co.uq.pmvpedidos.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.uq.pmvpedidos.app.models.dao.IEstadoDao;
import co.uq.pmvpedidos.app.models.dao.IFacturaDao;
import co.uq.pmvpedidos.app.models.dao.IProductoDao;
import co.uq.pmvpedidos.app.models.dao.IUserDao;
import co.uq.pmvpedidos.app.models.entity.Estado;
import co.uq.pmvpedidos.app.models.entity.Factura;
import co.uq.pmvpedidos.app.models.entity.Producto;
import co.uq.pmvpedidos.app.models.entity.User;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaDao facturaDao;

	@Autowired
	private IProductoDao productoDao;

	@Autowired
	private IEstadoDao estadoDao;

	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public List<Factura> findAll() {
		// TODO Auto-generated method stub
		return (List<Factura>) facturaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Factura> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return facturaDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Factura factura) {
		// TODO Auto-generated method stub
		facturaDao.save(factura);

	}

	@Override
	@Transactional(readOnly = true)
	public Factura findOne(Long id) {
		// TODO Auto-generated method stub
		return facturaDao.findOne(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		facturaDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {
		return productoDao.findByNombreLikeIgnoreCase("%" + term + "%");
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findProductoById(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findOne(id);
	}

	@Override
	public List<Estado> findAllStates() {
		// TODO Auto-generated method stub
		return (List<Estado>) estadoDao.findAll();
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userDao.findAll();
	}

}
