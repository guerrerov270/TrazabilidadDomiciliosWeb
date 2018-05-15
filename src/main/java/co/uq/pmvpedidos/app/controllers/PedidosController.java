package co.uq.pmvpedidos.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.uq.pmvpedidos.app.models.dao.IPedidoDao;
import co.uq.pmvpedidos.app.models.entity.Factura;

@RestController
// @RequestMapping("/api")
public class PedidosController {

	@Autowired
	private IPedidoDao pedidoRepository;

	// Rutas móvil Get All
	@GetMapping(path = "/asignados")
	// @ResponseBody
	public List<Factura> getAllPedidos() {
		return pedidoRepository.findAll();
	}

	// TODO: Query para filtrar por empleado y estados
}
