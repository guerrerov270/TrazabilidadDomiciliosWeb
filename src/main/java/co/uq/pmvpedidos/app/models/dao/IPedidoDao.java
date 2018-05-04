package co.uq.pmvpedidos.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.uq.pmvpedidos.app.models.entity.Factura;

@Repository
public interface IPedidoDao extends JpaRepository<Factura, Long> {

}
