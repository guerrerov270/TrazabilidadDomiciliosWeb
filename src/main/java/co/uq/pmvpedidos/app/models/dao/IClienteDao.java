package co.uq.pmvpedidos.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.uq.pmvpedidos.app.models.entity.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long> {

}
