package co.uq.pmvpedidos.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.uq.pmvpedidos.app.models.entity.Estado;
import co.uq.pmvpedidos.app.models.entity.Factura;
import co.uq.pmvpedidos.app.models.entity.Producto;
import co.uq.pmvpedidos.app.models.entity.User;

public interface IFacturaService {

	public List<Factura> findAll();

	public List<Estado> findAllStates();

	public Page<Factura> findAll(Pageable pageable);

	public void save(Factura factura);

	public Factura findOne(Long id);

	public void delete(Long id);

	public List<Producto> findByNombre(String term);

	public Producto findProductoById(Long id);

	public List<User> findAllUsers();

}
