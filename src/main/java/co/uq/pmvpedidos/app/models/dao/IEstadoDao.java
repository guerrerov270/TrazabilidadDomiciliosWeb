package co.uq.pmvpedidos.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.uq.pmvpedidos.app.models.entity.Estado;

public interface IEstadoDao extends PagingAndSortingRepository<Estado, Long>{

}
