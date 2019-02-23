package com.fila.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fila.model.Produto;
import com.fila.repository.ProdutoRepository;

/**
 * POC - ESPECIALIZACAO PUC MINAS
 * 
 * @author James Rugno
 *
 */
@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto atualizar(Long codigo, Produto produto) {
		Produto produtoSalvo = buscarProdutoPeloCodigo(codigo);
		
		BeanUtils.copyProperties(produto, produtoSalvo, "codigo");
		return produtoRepository.save(produtoSalvo);
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Produto produtoSalvo = buscarProdutoPeloCodigo(codigo);
		produtoSalvo.setAtivo(ativo);
		produtoRepository.save(produtoSalvo);
	}
	
	public Produto buscarProdutoPeloCodigo(Long codigo) {
		Optional<Produto> produtoSalva = produtoRepository.findById(codigo);
		if (!produtoSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return produtoSalva.get();
	}
	
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
}