package br.com.expat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.expat.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	@Query("SELECT c FROM Cidade c WHERE sg_uf=?1 AND nm_cidade=?2")
 	Cidade buscaCidade(String estado, String municipio);	

}
