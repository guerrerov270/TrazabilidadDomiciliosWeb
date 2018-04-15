package co.uq.pmvpedidos.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.uq.pmvpedidos.app.models.entity.Zona;

public interface IZonaDao extends PagingAndSortingRepository<Zona, String> {

}
