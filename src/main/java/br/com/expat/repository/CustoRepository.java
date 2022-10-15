package br.com.expat.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.expat.dto.MediaDTO;
import br.com.expat.model.Custo;

@Repository
public interface CustoRepository extends JpaRepository<Custo, Long> {

	@Query("SELECT new br.com.expat.dto.MediaDTO(c.codCidade, AVG(c.almoco), AVG(c.aluguel), AVG(c.cestabasica), AVG(c.onibus)) FROM Custo c INNER JOIN Cidade m ON c.codCidade.id=m.id WHERE c.codCidade.id=?1")
 	MediaDTO mediaCidade(Long codCidade);
}
