package co.uq.pmvpedidos.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import co.uq.pmvpedidos.app.models.entity.Cuenta;


@Controller
@RequestMapping(value = "/cuenta")
@SessionAttributes("cuenta1")
public class CuentaController {

	private Map<Long, Cuenta> cuentas = new ConcurrentHashMap<Long, Cuenta>();
	
	// Metodo handler formulario, para crear la cuenta
	@RequestMapping(method=RequestMethod.GET)
	public String crearCuentaForm(Model model) {
		// La instancia de "Cuenta" es creada y guardada como atributo "cuenta"
		// en el objeto "model", el cual es accesible desde
		// la vista, "cuenta/crearForm.jsp".
		model.addAttribute("cuenta", new Cuenta());
		return "cuenta/crearForm";
	}
	
	// Metodo handler que procesa el envio de datos del form
	@RequestMapping(method=RequestMethod.POST)
	public String crearCuenta(Cuenta cuenta, BindingResult result) {
		// Si ocurre un error en la validacion aparecera el formulario
		// "cuenta/crearForm.jsp" con los mensajes.
		if (result.hasErrors()) {
			return "cuenta/crearForm";
		}
		
		// Si todo esta bien, crea la cuenta y la agrega a la lista
		// "cuentas", luego redirige hacia el detalle /cuenta/{id},
		// controlado por el metodo handler "verDetalle(..) de mas abajo.
		this.cuentas.put(cuenta.asignarId(), cuenta);
		return "redirect:/cuenta/" + cuenta.getId();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String verDetalle(@PathVariable Long id, 
			// Ejemplo de @ModelAttribute pasado como parametro
			@ModelAttribute("listaProductos") List<String> listaProductos2,
			Model model) {
		Cuenta cuenta = this.cuentas.get(id);
		if (cuenta == null) {
			throw new RecursoNoEncontradoException(id);
		}
		model.addAttribute("cuenta", cuenta);
		model.addAttribute("listaProductos2", listaProductos2);
		// return "cuenta/detalle"; // Muestra el detalle de la cuenta en formato formulario
		return "cuenta/detalle2";  // Muestra el detalle de la cuenta en formato tabla html
	}

	// Creamos un atributo del modelo "listaProductos" con la anotacion 
	// @ModelAttribute retornando los valores del metodo "poblarListaProductos()".  
	// El atributo "listaProductos" podra ser usado en la vista jsp como atributo.
	@ModelAttribute("listaProductos")
	public List<String> poblarListaProductos() {
		List<String> lista = new ArrayList<String>();
		lista.add("Cuenta Corriente");
		lista.add("Tarjeta de credito VISA");
		lista.add("Tarjeta de credito MASTERCARD");
		lista.add("Fondos Mutuos");
		lista.add("Credito Hipotecario");

		return lista;
	}

}
