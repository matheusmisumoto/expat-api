package br.com.expat.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.expat.model.Usuario;
import br.com.expat.service.UsuarioService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioResource implements ResourceInterface<Usuario> {

	@Autowired
	private UsuarioService service = new UsuarioService();

	@Override
	@GetMapping(produces = "application/json")
	@ApiOperation(value = "Retorna uma lista de usuários")
	public ResponseEntity<List<Usuario>> get() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping(value = "/{id}", produces = "application/json")
	@ApiOperation(value = "Retorna dados de um usuário")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Usuario _usuario = service.findById(id);
		if (_usuario != null)
			return ResponseEntity.ok(_usuario);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@Override
	@PostMapping(produces = "application/json")
	@ApiOperation(value = "Adiciona um usuário")
	public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
		service.create(usuario);
		return ResponseEntity.ok(usuario);
	}

	@Override
	@PutMapping(produces = "application/json")
	@ApiOperation(value = "Edita um usuário")
	public ResponseEntity<?> put(@RequestBody Usuario usuario) {
		if (service.update(usuario)) {
			return ResponseEntity.ok(usuario);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping(value = "/{id}", produces = "application/json")
	@PreAuthorize("hasAnyRole('ADMIN')")
	@ApiOperation(value = "Remove um usuário")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
