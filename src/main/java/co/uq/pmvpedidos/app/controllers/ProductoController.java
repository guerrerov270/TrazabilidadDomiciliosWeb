package co.uq.pmvpedidos.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductoController {

	@RequestMapping(value = "/listarProductos", method = RequestMethod.GET)
	public String listarProduectos() {
		return "listarProductos";
	}

}
