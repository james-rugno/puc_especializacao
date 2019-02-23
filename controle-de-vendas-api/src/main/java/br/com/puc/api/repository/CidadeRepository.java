package br.com.puc.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.puc.api.model.Cidade;

/**
 * POC - ESPECIALIZACAO PUC MINAS
 * 
 * @author James Rugno
 *
 */
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	List<Cidade> findByEstadoCodigo(Long estadoCodigo);

}
