package br.com.expat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.expat.model.Usuario;
import br.com.expat.repository.UsuarioRepository;
import  br.com.expat.security.UserDetailsImpl;

@Service
public class UsuarioService implements ServiceInterface<Usuario> {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioService() {
	}
	
	@Override
	public Usuario create(Usuario obj) {
		obj.setPassword(passwordEncoder.encode(obj.getPassword()));
		repository.save(obj);
		return obj;
	}

	@Override
	public Usuario findById(Long id) {
		Optional<Usuario> _usuario = repository.findById(id);
		return _usuario.orElse(null);
	}

	@Override
	public List<Usuario> findAll() {		
		return repository.findAll();
	}

	@Override
	public boolean update(Usuario obj) {
		if (repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		Optional<Usuario> _usuario = repository.findById(id);
		if (_usuario.isPresent()) {
			repository.delete(_usuario.get());
			return true;
		}
		return false;
	}

	public static UserDetailsImpl authenticated() {
		Authentication auth = SecurityContextHolder
				.getContext()
				.getAuthentication();
		if (auth != null) {
			return (UserDetailsImpl) auth.getPrincipal();
		}
		return null;
	}
}
