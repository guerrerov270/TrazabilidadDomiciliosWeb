package co.uq.pmvpedidos.app.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.uq.pmvpedidos.app.models.entity.Producto;
import co.uq.pmvpedidos.app.models.service.IProductoService;
import co.uq.pmvpedidos.app.models.service.IUploadFileService;
import co.uq.pmvpedidos.app.util.paginator.PageRender;

@Controller
@SessionAttributes("producto")
public class ProductoController {

	private static final String FORM_PRODUCTO = "formproducto";
	private static final String TITULO = "titulo";
	private static final String PRODUCTO = "producto";
	private static final String REDIRECT_LISTAR_PRODUCTOS = "redirect:/listarProductos";
	private static final String ERROR = "error";

	@Autowired
	private IProductoService productoService;

	@Autowired
	private IUploadFileService uploadFileService;

	@GetMapping(value = "/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource recurso = null;

		try {
			recurso = uploadFileService.load(filename);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}

	@GetMapping(value = "/verproducto/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Producto producto = productoService.findOne(id);
		if (producto == null) {
			flash.addFlashAttribute(ERROR, "El producto no existe en la base de datos");
			return REDIRECT_LISTAR_PRODUCTOS;
		}

		model.put(PRODUCTO, producto);
		model.put(TITULO, "Detalle producto: " + producto.getNombre());
		return "verproducto";
	}

	@RequestMapping(value = "/listarProductos", method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = new PageRequest(page, 100);

		Page<Producto> productos = productoService.findAll(pageRequest);

		PageRender<Producto> pageRender = new PageRender<>("/listarProductos", productos);
		model.addAttribute(TITULO, "Listado de productos");
		model.addAttribute("productos", productos);
		model.addAttribute("page", pageRender);
		return "listarProductos";
	}

	@RequestMapping(value = "/formproducto")
	public String crear(Map<String, Object> model) {

		Producto producto = new Producto();
		model.put(PRODUCTO, producto);
		model.put(TITULO, "Crear producto");
		return FORM_PRODUCTO;
	}

	@RequestMapping(value = "/formproducto/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Producto producto = null;

		if (id > 0) {
			producto = productoService.findOne(id);
			if (producto == null) {
				flash.addFlashAttribute(ERROR, "El ID del producto no existe en la BBDD!");
				return REDIRECT_LISTAR_PRODUCTOS;
			}
		} else {
			flash.addFlashAttribute(ERROR, "El ID del producto no puede ser cero!");
			return REDIRECT_LISTAR_PRODUCTOS;
		}
		model.put(PRODUCTO, producto);
		model.put(TITULO, "Editar producto");
		return FORM_PRODUCTO;
	}

	@RequestMapping(value = "/formproducto", method = RequestMethod.POST)
	public String guardar(@Valid Producto producto, BindingResult result, Model model,
			@RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute(TITULO, "Formulario de Producto");
			return FORM_PRODUCTO;
		}

		if (!foto.isEmpty()) {

			if (producto.getId() != null && producto.getId() > 0 && producto.getFoto() != null
					&& producto.getFoto().length() > 0) {

				uploadFileService.delete(producto.getFoto());
			}

			String uniqueFilename = null;
			try {
				uniqueFilename = uploadFileService.copy(foto);
			} catch (IOException e) {

				e.printStackTrace();
			}

			flash.addFlashAttribute("info", "Has subido correctamente '" + uniqueFilename + "'");

			producto.setFoto(uniqueFilename);

		}

		String mensajeFlash = (producto.getId() != null) ? "Producto editado con éxito!" : "Producto creado con éxito!";

		productoService.save(producto);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listarProductos";
	}

	@RequestMapping(value = "/eliminarproducto/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {
			Producto producto = productoService.findOne(id);

			productoService.delete(id);
			flash.addFlashAttribute("success", "Producto eliminado con éxito!");

			if (uploadFileService.delete(producto.getFoto())) {
				flash.addFlashAttribute("info", "Foto " + producto.getFoto() + " eliminada con exito!");
			}

		}
		return REDIRECT_LISTAR_PRODUCTOS;
	}

}
