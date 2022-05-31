package cl.christian.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.christian.catalogo.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
