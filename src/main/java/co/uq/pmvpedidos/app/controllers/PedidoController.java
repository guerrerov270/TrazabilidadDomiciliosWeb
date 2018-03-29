package co.uq.pmvpedidos.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PedidoController {

	@RequestMapping(value = "/listarPedidos", method = RequestMethod.GET)
	public String listarPedidos() {
		return "listarPedidos";
	}

}
