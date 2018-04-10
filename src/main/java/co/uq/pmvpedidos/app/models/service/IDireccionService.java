package co.uq.pmvpedidos.app.models.service;

import java.util.List;

import co.uq.pmvpedidos.app.models.entity.Direccion;

public interface IDireccionService {

	public List<Direccion> findAll();

	public void save(Direccion direccion);

	public Direccion findOne(Long id);

	public void delete(Long id);

}
