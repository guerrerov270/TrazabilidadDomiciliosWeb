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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	private static final String FACTURA_FORM = "factura/form";
	private static final String CREAR_FACTURA = "Crear Factura";
	private static final String TITULO = "titulo";
	private static final String REDIRECT_LISTAR = "redirect:/listar";
	private static final String ERROR = "error";

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IFacturaService facturaService;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@GetMapping("/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

		Factura factura = clienteService.findFacturaById(id);

		if (factura == null) {
			flash.addFlashAttribute(ERROR, "La factura no existe en la base de datos!");
			return REDIRECT_LISTAR;
		}

		model.addAttribute("factura", factura);
		model.addAttribute(TITULO, "Factura: ".concat(factura.getObservacion()));
		return "factura/ver";
	}

	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> model,
			RedirectAttributes flash) {

		Cliente cliente = clienteService.findOne(clienteId);

		if (cliente == null) {
			flash.addFlashAttribute(ERROR, "El cliente no existe en la base de datos");
			return REDIRECT_LISTAR;
		}

		Factura factura = new Factura();
		factura.setCliente(cliente);

		model.put("factura", factura);
		model.put(TITULO, CREAR_FACTURA);

		return FACTURA_FORM;
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
			model.addAttribute(TITULO, CREAR_FACTURA);
			return FACTURA_FORM;
		}

		if (itemId == null || itemId.length == 0) {
			model.addAttribute(TITULO, CREAR_FACTURA);
			model.addAttribute(ERROR, "Error: La factura NO puede no tener líneas!");
			return FACTURA_FORM;
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
		flash.addFlashAttribute(ERROR, "La factura no existe en la base de datos, no se pudo eliminar!");

		return REDIRECT_LISTAR;
	}

	@RequestMapping(value = "/listarpedidos", method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = new PageRequest(page, 50);

		Page<Factura> facturas = facturaService.findAll(pageRequest);

		PageRender<Factura> pageRender = new PageRender<>("/listarpedidos", facturas);
		model.addAttribute(TITULO, "Listado de pedidos");
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

	// Un estado vacío
	@ModelAttribute("estado")
	public void estadoModel(Model model) {
		Estado estado = new Estado();
		model.addAttribute("estado", estado);
	}

	// Un usuario vacío
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
			flash.addFlashAttribute(ERROR, "El cliente no existe en la base de datos");
			return "redirect:/form";
		}

		model.put("cliente", cliente);
		return "ver";
	}

	@RequestMapping(value = "/setestado")
	public String cambioEstado(Map<String, Object> model, RedirectAttributes flash) {

		System.out.println(
				"*****************************************************************************Estado seleccionado");
		return "setestado";
	}

}
