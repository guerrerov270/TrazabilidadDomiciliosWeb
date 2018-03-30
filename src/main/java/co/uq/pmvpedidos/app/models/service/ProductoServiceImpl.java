package co.uq.pmvpedidos.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.uq.pmvpedidos.app.models.dao.IProductoDao;
import co.uq.pmvpedidos.app.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return productoDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Producto producto) {
		// TODO Auto-generated method stub
		productoDao.save(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findOne(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productoDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {
		// TODO Auto-generated method stub
		return productoDao.findByNombreLikeIgnoreCase("%"+term+"%");
	}

}
