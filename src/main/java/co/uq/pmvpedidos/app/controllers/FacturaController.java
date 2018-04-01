package co.uq.pmvpedidos.app.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.uq.pmvpedidos.app.models.entity.Factura;
import co.uq.pmvpedidos.app.models.entity.ItemFactura;
import co.uq.pmvpedidos.app.models.entity.Producto;
import co.uq.pmvpedidos.app.models.service.IFacturaService;
import co.uq.pmvpedidos.app.util.paginator.PageRender;

@Controller
@SessionAttributes("factura")
public class FacturaController {

	@Autowired
	private IFacturaService facturaService;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/listarpedidos", method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = new PageRequest(page, 10);

		Page<Factura> facturas = facturaService.findAll(pageRequest);

		PageRender<Factura> pageRender = new PageRender<Factura>("/listarpedidos", facturas);
		model.addAttribute("titulo", "Listado de pedidos");
		model.addAttribute("pedidos", facturas);
		model.addAttribute("page", pageRender);
		return "listarpedidos";
	}

	@GetMapping("/verpedido/{id}")
	public String ver(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

		Factura factura = facturaService.findOne(id);

		if (factura == null) {
			flash.addFlashAttribute("error", "La factura no existe en la base de datos!");
			return "redirect:/listarpedidos";
		}

		model.addAttribute("factura", factura);
		model.addAttribute("titulo", "Factura: ".concat(factura.getDescripcion()));
		return "factura/verpedido";
	}

	@RequestMapping(value = "/formpedido")
	public String crear(Map<String, Object> model, RedirectAttributes flash) {

		Factura factura = new Factura();

		model.put("factura", factura);
		model.put("titulo", "Crear Factura");

		return "factura/formpedido";
	}

	@GetMapping(value = "/cargar-productos/{term}", produces = { "application/json" })
	public @ResponseBody List<Producto> cargarProductos(@PathVariable String term) {
		return facturaService.findByNombre(term);
	}

	@RequestMapping(value = "/formpedido", method = RequestMethod.POST)
	public String guardar(@Valid Factura factura, BindingResult result, Model model,
			@RequestParam(name = "item_id[]", required = false) Long[] itemId,
			@RequestParam(name = "cantidad[]", required = false) Integer[] cantidad, RedirectAttributes flash,
			SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Crear Factura");
			return "factura/formpedido";
		}

		if (itemId == null || itemId.length == 0) {
			model.addAttribute("titulo", "Crear Factura");
			model.addAttribute("error", "Error: La factura NO puede no tener líneas!");
			return "factura/formpedido";
		}

		for (int i = 0; i < itemId.length; i++) {
			Producto producto = facturaService.findProductoById(itemId[i]);

			ItemFactura linea = new ItemFactura();
			linea.setCantidad(cantidad[i]);
			linea.setProducto(producto);
			factura.addItemFactura(linea);

			log.info("ID: " + itemId[i].toString() + ", cantidad: " + cantidad[i].toString());
		}

		facturaService.save(factura);
		status.setComplete();

		flash.addFlashAttribute("success", "Factura creada con éxito!");

		return "redirect:/verpedido/" + factura.getId();
	}

	@GetMapping("/eliminarpedido/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		Factura factura = facturaService.findOne(id);

		if (factura != null) {
			facturaService.delete(id);
			flash.addFlashAttribute("success", "Factura eliminada con éxito!");
			return "redirect:/verpedido/" + factura.getId();
		}
		flash.addFlashAttribute("error", "La factura no existe en la base de datos, no se pudo eliminar!");

		return "redirect:/listarpedidos";
	}

}
