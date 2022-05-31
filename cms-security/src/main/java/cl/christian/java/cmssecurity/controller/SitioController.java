package cl.christian.java.cmssecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SitioController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/nosotros")
	public String nosotros() {
		return "nosotros";
	}

	@GetMapping("/contacto")
	public String reporte() {
		return "contacto";
	}
}
