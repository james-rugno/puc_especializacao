package br.com.puc.carrinho;

/**
 * POC - ESPECIALIZACAO PUC MINAS
 * 
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 * 
 * @author James Rugno
 */
public class Produto {

    private Long codigo;
    private String descricao;

    /**
     * Construtor da classe Produto.
     *
     * @param codigo
     * @param descricao
     */
    public Produto(Long codigo, String descricao) {
    	this.codigo = codigo;
    	this.descricao = descricao;
    }

    /**
     * Retorna o código da produto.
     *
     * @return Long
     */
    public Long getCodigo() {
    	return codigo;
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return String
     */
    public String getDescricao() {
    	return descricao;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Produto produto = (Produto) obj;
		if(produto == null) {
			return false;
		}
		if (codigo == null) {
			if (produto.getCodigo() != null)
				return false;
		} else if (!codigo.equals(produto.getCodigo()))
			return false;
		return true;
	}
}