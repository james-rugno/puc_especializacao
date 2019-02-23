package br.com.puc.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.puc.api.model.Categoria;

/**
 * POC - ESPECIALIZACAO PUC MINAS
 * 
 * @author James Rugno
 *
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
