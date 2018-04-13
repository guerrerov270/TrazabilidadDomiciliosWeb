package co.uq.pmvpedidos.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.uq.pmvpedidos.app.models.entity.Direccion;

public interface IDireccionDao extends PagingAndSortingRepository<Direccion, Long> {

}