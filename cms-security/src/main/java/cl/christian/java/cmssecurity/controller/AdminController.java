package cl.christian.java.cmssecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.christian.java.cmssecurity.model.Usuario;
import cl.christian.java.cmssecurity.service.UsuarioService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/instalar")
	public String instalar() {
		long cantidadUsuarios = usuarioService.cantidadUsuarios();
		if(cantidadUsuarios == 0) {
			Usuario usuario = new Usuario(null, "chris@123.cl", "1234", "ADMIN");
			usuarioService.crearUsuario(usuario);
		}
		return "redirect:/";
	}
	
	@GetMapping("/administracion")
	public String administracion() {
		return "admin/administracion";
	}
	
	@GetMapping("/reporte")
	public String reporte() {
		return "admin/reporte";
	}

}
