package co.uq.pmvpedidos.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import co.uq.pmvpedidos.app.models.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long>{

}
