package br.com.expat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.expat.dto.MediaDTO;
import br.com.expat.model.Cidade;
import br.com.expat.repository.CidadeRepository;

@Service
public class CidadeService implements ServiceInterface<Cidade> {

	@Autowired
	private CidadeRepository repository;
	
	public CidadeService() {
	}
	
	@Override
	public Cidade create(Cidade obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public Cidade findById(Long id) {
		Optional<Cidade> _cidade = repository.findById(id);
		return _cidade.orElse(null);
	}

	@Override
	public List<Cidade> findAll() {		
		return repository.findAll();
	}

	@Override
	public boolean update(Cidade obj) {
		if (repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		Optional<Cidade> _cidade = repository.findById(id);
		if (_cidade.isPresent()) {
			repository.delete(_cidade.get());
			return true;
		}
		return false;
	}

	public Cidade buscaCidade(String estado, String municipio) {
		return repository.buscaCidade(estado, municipio);
	}

	
	
}
