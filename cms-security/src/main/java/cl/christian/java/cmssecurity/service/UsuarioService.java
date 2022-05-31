package cl.christian.java.cmssecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.christian.java.cmssecurity.model.Usuario;
import cl.christian.java.cmssecurity.repository.UsuarioRepository;

@Service
public class UsuarioService {
		
		@Autowired
		private PasswordEncoder codificadorContrasena;
		
		@Autowired
		private UsuarioRepository usuarioRepository;
		
		public long cantidadUsuarios() {
			return usuarioRepository.count();
		}
		
		public Optional<Usuario> buscarPorEmail(String email){
			return usuarioRepository.findByEmail(email);
		}
		
		public Usuario crearUsuario(Usuario usuario) {
			String contrasenaCodificada =
					codificadorContrasena.encode(usuario.getPassword());
		usuario.setPassword(contrasenaCodificada);
		return usuarioRepository.saveAndFlush(usuario);
	}
}