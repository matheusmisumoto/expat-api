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

import br.com.expat.model.Cidade;
import br.com.expat.service.CidadeService;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/cidade")
public class CidadeResource implements ResourceInterface<Cidade> {

	@Autowired
	private CidadeService service = new CidadeService();

	@Override
	@GetMapping(produces = "application/json")
	@ApiOperation(value = "Retorna a lista de cidades")
	public ResponseEntity<List<Cidade>> get() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping(value = "/{id}", produces = "application/json")
	@ApiOperation(value = "Retorna uma cidade")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Cidade _cidade = service.findById(id);
		if (_cidade != null)
			return ResponseEntity.ok(_cidade);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping(value = "/busca/{estado}/{municipio}", produces = "application/json")
	@ApiOperation(value = "Busca uma cidade por nome e estado")
	public ResponseEntity<?> get(@PathVariable("estado") String estado, @PathVariable("municipio") String municipio) {
		return ResponseEntity.ok(service.buscaCidade(estado, municipio));

	}

	@Override
	@PostMapping(produces = "application/json")
	@ApiOperation(value = "Insere uma cidade")
	public ResponseEntity<Cidade> post(@RequestBody Cidade cidade) {
		service.create(cidade);
		return ResponseEntity.ok(cidade);
	}

	@Override
	@PutMapping(produces = "application/json")
	@PreAuthorize("hasAnyRole('ADMIN')")
	@ApiOperation(value = "Edita uma cidade")
	public ResponseEntity<?> put(@RequestBody Cidade cidade) {
		if (service.update(cidade)) {
			return ResponseEntity.ok(cidade);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping(value = "/{id}", produces = "application/json")
	@PreAuthorize("hasAnyRole('ADMIN')")
	@ApiOperation(value = "Remove uma cidade")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
