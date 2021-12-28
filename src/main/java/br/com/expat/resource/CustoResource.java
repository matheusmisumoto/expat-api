package br.com.expat.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.expat.dto.MediaDTO;
import br.com.expat.model.Custo;
import br.com.expat.service.CustoService;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/custo")
public class CustoResource implements ResourceInterface<Custo> {

	@Autowired
	private CustoService service = new CustoService();
	
	@Override
	@GetMapping(produces = "application/json")
	@ApiOperation(value = "Retorna a lista de registros de custo de vida")
	public ResponseEntity<List<Custo>> get() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping(value = "/{id}", produces = "application/json")
	@ApiOperation(value = "Retorna um registro de custo de vida")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Custo _custo = service.findById(id);
		if (_custo != null)
			return ResponseEntity.ok(_custo);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	
	@GetMapping(value = "/cidade/{cidade}", produces = "application/json")
	@ApiOperation(value = "Retorna a média de custo de vida")
	public ResponseEntity<?> get(@PathVariable("cidade") int id) {
		MediaDTO _custo = service.mediaCidade(id);
		if (_custo != null) {
			return ResponseEntity.ok(_custo);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	

	@Override
	@PostMapping(produces = "application/json")
	@ApiOperation(value = "Adiciona um registro de custo de vida")
	public ResponseEntity<Custo> post(@RequestBody Custo custo) {
		service.create(custo);
		return ResponseEntity.ok(custo);
	}

	@Override
	@PutMapping(produces = "application/json")
	@ApiOperation(value = "Edita um registro de custo de vida")
	public ResponseEntity<?> put(@RequestBody Custo custo) {
		if (service.update(custo)) {
			return ResponseEntity.ok(custo);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping(value = "/{id}", produces = "application/json")
	@ApiOperation(value = "Remove um registro de custo de vida")
		public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
