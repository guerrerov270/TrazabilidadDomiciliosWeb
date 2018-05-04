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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.uq.pmvpedidos.app.models.entity.Cliente;
import co.uq.pmvpedidos.app.models.entity.Estado;
import co.uq.pmvpedidos.app.models.entity.Factura;
import co.uq.pmvpedidos.app.models.entity.ItemFactura;
import co.uq.pmvpedidos.app.models.entity.Producto;
import co.uq.pmvpedidos.app.models.entity.User;
import co.uq.pmvpedidos.app.models.service.IClienteService;
import co.uq.pmvpedidos.app.models.service.IFacturaService;
import co.uq.pmvpedidos.app.util.paginator.PageRender;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IFacturaService facturaService;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@GetMapping("/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

		Factura factura = clienteService.findFacturaById(id);

		if (factura == null) {
			flash.addFlashAttribute("error", "La factura no existe en la base de datos!");
			return "redirect:/listar";
		}

		model.addAttribute("factura", factura);
		model.addAttribute("titulo", "Factura: ".concat(factura.getObservacion()));
		return "factura/ver";
	}

	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> model,
			RedirectAttributes flash) {

		Cliente cliente = clienteService.findOne(clienteId);

		if (cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}

		Factura factura = new Factura();
		factura.setCliente(cliente);

		model.put("factura", factura);
		model.put("titulo", "Crear Factura");

		return "factura/form";
	}

	@GetMapping(value = "/cargar-productos/{term}", produces = { "application/json" })
	public @ResponseBody List<Producto> cargarProductos(@PathVariable String term) {
		return clienteService.findByNombre(term);
	}

	@PostMapping("/form")
	public String guardar(@Valid Factura factura, BindingResult result, Model model,
			@RequestParam(name = "item_id[]", required = false) Long[] itemId,
			@RequestParam(name = "cantidad[]", required = false) Integer[] cantidad, RedirectAttributes flash,
			SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Crear Factura");
			return "factura/form";
		}

		if (itemId == null || itemId.length == 0) {
			model.addAttribute("titulo", "Crear Factura");
			model.addAttribute("error", "Error: La factura NO puede no tener líneas!");
			return "factura/form";
		}

		for (int i = 0; i < itemId.length; i++) {
			Producto producto = clienteService.findProductoById(itemId[i]);

			ItemFactura linea = new ItemFactura();
			linea.setCantidad(cantidad[i]);
			linea.setProducto(producto);
			factura.addItemFactura(linea);

			log.info("ID: " + itemId[i].toString() + ", cantidad: " + cantidad[i].toString());
		}

		clienteService.saveFactura(factura);
		status.setComplete();

		flash.addFlashAttribute("success", "Factura creada con éxito!");

		return "redirect:/ver/" + factura.getCliente().getId();
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		Factura factura = clienteService.findFacturaById(id);

		if (factura != null) {
			clienteService.deleteFactura(id);
			flash.addFlashAttribute("success", "Factura eliminada con éxito!");
			return "redirect:/ver/" + factura.getCliente().getId();
		}
		flash.addFlashAttribute("error", "La factura no existe en la base de datos, no se pudo eliminar!");

		return "redirect:/listar";
	}

	@RequestMapping(value = "/listarpedidos", method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = new PageRequest(page, 50);

		Page<Factura> facturas = facturaService.findAll(pageRequest);

		PageRender<Factura> pageRender = new PageRender<Factura>("/listarpedidos", facturas);
		model.addAttribute("titulo", "Listado de pedidos");
		model.addAttribute("facturas", facturas);
		model.addAttribute("page", pageRender);
		return "listarpedidos";
	}

	// Lista de todos los estados disponibles en base de datos a objeto model para
	// ser accedidios desde la vista
	@ModelAttribute("estados")
	public void getEstados(Model model) {
		List<Estado> estados = facturaService.findAllStates();
		model.addAttribute("estados", estados);
	}

	// Lista de todos los usuarios disponibles en base de datos a objeto model para
	// ser accedidios desde la vista
	@ModelAttribute("users")
	public void getUsers(Model model) {
		List<User> users = facturaService.findAllUsers();
		model.addAttribute("users", users);
	}

	// Un estado vacío asignarle el teléfono introducido para crear el pedido,
	// y poderlo buscar en la base de datos
	@ModelAttribute("estado")
	public void estadoModel(Model model) {
		Estado estado = new Estado();
		model.addAttribute("estado", estado);
	}

	// Un usuario vacío asignarle el teléfono introducido para crear el pedido,
	// y poderlo buscar en la base de datos
	@ModelAttribute("user")
	public void userModel(Model model) {
		User user = new User();
		model.addAttribute("user", user);
	}

	// Un cliente vacío asignarle el teléfono introducido para crear el pedido,
	// y poderlo buscar en la base de datos
	@ModelAttribute("cliente")
	public void clienteModel(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
	}

	@RequestMapping(value = "/listarpedidos", method = RequestMethod.POST)
	public String guardar(@RequestParam("id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Cliente cliente = clienteService.findOne(id);
		if (!(clienteService.exists(id))) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/form";
		}

		model.put("cliente", cliente);
		return "ver";
	}

	

}
