package br.com.puc.carrinho;

import java.math.BigDecimal;

/**
 * POC - ESPECIALIZACAO PUC MINAS
 * 
 * Classe que representa um item no carrinho de compras.
 * @author James Rugno
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;

	private int quantidade;

    /**
     * Construtor da classe Item.
     * 
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
    	this.produto = produto;
    	this.valorUnitario = valorUnitario;
    	this.quantidade = quantidade;
    }

    /**
     * Retorna o produto.
     *
     * @return Produto
     */
    public Produto getProduto() {
    	return produto;
    }

    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorUnitario() {
    	return valorUnitario;
    }

    /**
     * Adiciona o valor unitário do Item
     * @param valorUnitario
     */
    public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

    
    /**
     * Retorna a quantidade dos item.
     *
     * @return int
     */
    public int getQuantidade() {
    	return quantidade;
    }

    /**
     * Adiciona uma quantidade ao Item
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
    	
    	return valorUnitario.multiply(new BigDecimal(quantidade)) ;
    	
    }
}
