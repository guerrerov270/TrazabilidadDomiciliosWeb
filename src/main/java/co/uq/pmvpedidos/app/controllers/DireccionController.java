package co.uq.pmvpedidos.app.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.uq.pmvpedidos.app.models.entity.Cliente;
import co.uq.pmvpedidos.app.models.entity.Direccion;
import co.uq.pmvpedidos.app.models.entity.Estado;
import co.uq.pmvpedidos.app.models.entity.Zona;
import co.uq.pmvpedidos.app.models.service.IDireccionService;

@Controller
@SessionAttributes("direccion")
public class DireccionController {

	@Autowired
	private IDireccionService direccionService;

	@RequestMapping(value = "/formd")
	public String crear(Map<String, Object> model) {

		Direccion direccion = new Direccion();
		model.put("direccion", direccion);
		model.put("titulo", "Crear Direccion");
		return "formd";
	}

	@RequestMapping(value = "/formd/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Direccion direccion = null;

		if (id > 0) {
			direccion = direccionService.findOne(id);

			if (direccion == null) {
				flash.addFlashAttribute("error", "El ID de la dirección no existe en la BBDD!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID de la dirección no puede ser cero!");
			return "redirect:/listar";
		}
		model.put("direccion", direccion);
		model.put("titulo_d", "Editar Dirección");
		return "formd";
	}

	@RequestMapping(value = "/formd", method = RequestMethod.POST)
	public String guardar(Direccion direccion, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Dirección");
			return "formd";
		}

		String mensajeFlash = (direccion.getId() != null) ? "Dirección editada con éxito!"
				: "Dirección creada con éxito!";

		direccionService.save(direccion);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}

	@ModelAttribute("zonas")
	public void getZonas(Model model) {
		List<Zona> zonas = direccionService.findAllZonas();
		model.addAttribute("zonas", zonas);
	}

}
