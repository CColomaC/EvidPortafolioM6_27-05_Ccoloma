package cl.christian.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.christian.catalogo.model.Producto;
import cl.christian.catalogo.repository.ProductoRepository;

@RestController
@CrossOrigin(origins = "*")
public class AppController {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping("/instalar")
	public String instalar() {
			//instanciamos productos
			long count = productoRepository.count();
			if(count == 0) {
			Producto producto1 = Producto.builder()
									.nombre("Correa paseo")
									.precio(9990)
									.build()
			;
			Producto producto2 = new Producto(null, "Plato Grande Metálico", 4990);
			Producto producto3 = new Producto(null, "Pelota Juguete", 3990);
			
			//persistimos en la BD
			productoRepository.saveAndFlush(producto1);
			productoRepository.saveAndFlush(producto2);
			productoRepository.saveAndFlush(producto3);
			return "ok";
		} else {
			return "ya se había realizado la instalación";
		}
	}
	@GetMapping("/producto/destacados")
	public List<Producto> productosDestacados(){
		List<Producto> productos = productoRepository.findAll();
		return productos;
	}
}
