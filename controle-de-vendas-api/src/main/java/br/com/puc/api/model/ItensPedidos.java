package br.com.puc.api.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * POC - ESPECIALIZACAO PUC MINAS
 * 
 * @author James Rugno
 *
 */
public class ItensPedidos {
	
	@NotNull
	@Column(name = "valor")
	private BigDecimal precoUnitario;
	
	@NotNull
	@Column(name = "quantidade")
	private Integer qtd;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_pedido")
	private Pedido pedido;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_produto")
	private Produto produto;
	
	public ItensPedidos() {
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
