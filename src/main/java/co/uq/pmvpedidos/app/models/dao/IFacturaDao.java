package co.uq.pmvpedidos.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.uq.pmvpedidos.app.models.entity.Factura;

public interface IFacturaDao extends PagingAndSortingRepository<Factura, Long> {

}
