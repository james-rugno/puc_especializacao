package br.com.puc.api.dto;

import java.math.BigDecimal;

import br.com.puc.api.model.Categoria;

/**
 * POC - ESPECIALIZACAO PUC MINAS
 * 
 * @author James Rugno
 *
 */
public class ProdutoEstatisticaCategoria {
	
	private Categoria categoria;
	
	private BigDecimal total;

	public ProdutoEstatisticaCategoria(Categoria categoria, BigDecimal total) {
		this.categoria = categoria;
		this.total = total;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
