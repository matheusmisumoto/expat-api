package br.com.expat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.expat.dto.MediaDTO;
import br.com.expat.model.Custo;
import br.com.expat.repository.CustoRepository;

@Service
public class CustoService implements ServiceInterface<Custo> {

	@Autowired
	private CustoRepository repository;
	
	public CustoService() {
	}
	
	@Override
	public Custo create(Custo obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public Custo findById(Long id) {
		Optional<Custo> _custo = repository.findById(id);
		return _custo.orElse(null);
	}

	@Override
	public List<Custo> findAll() {		
		return repository.findAll();
	}

	@Override
	public boolean update(Custo obj) {
		if (repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		Optional<Custo> _custo = repository.findById(id);
		if (_custo.isPresent()) {
			repository.delete(_custo.get());
			return true;
		}
		return false;
	}

	public MediaDTO mediaCidade(int idCidade) {
		return repository.mediaCidade(idCidade);
	}
}
