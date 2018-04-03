package co.uq.pmvpedidos.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.uq.pmvpedidos.app.models.entity.Cliente;
import co.uq.pmvpedidos.app.models.entity.Factura;

public interface IClienteService {

	public List<Cliente> findAll();

	public Page<Cliente> findAll(Pageable pageable);

	public void save(Cliente cliente);

	public Cliente findOne(Long id);

	public void delete(Long id);

	public void saveFactura(Factura factura);

	public Factura findFacturaById(Long id);

	public void deleteFactura(Long id);

}
