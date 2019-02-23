package br.com.puc.carrinho;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * POC - ESPECIALIZACAO PUC MINAS
 * 
 * Classe que representa o carrinho de compras de um cliente.
 * 
 * @author James Rugno
 */
public class CarrinhoCompras {

	private List<Item> itens = new LinkedList<>();
	
	private String identificacaoCliente;

	/**
	 * Permite a adição de um novo item no carrinho de compras.
	 *
	 * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser
	 * seguidas: - A quantidade do item deverá ser a soma da quantidade atual com a quantidade
	 * passada como parâmetro. - Se o valor unitário informado for diferente do valor unitário atual
	 * do item, o novo valor unitário do item deverá ser o passado como parâmetro.
	 *
	 * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao
	 * carrinho de compras.
	 *
	 * @param produto
	 * @param valorUnitario
	 * @param quantidade
	 */
	public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {

		Optional<Item> item = itens.stream().filter(i -> i.getProduto().equals(produto)).findAny();

		if (item.isPresent()) {
			
			Item itemAtualizado = item.get();
			                                 
			itemAtualizado.setQuantidade(item.get().getQuantidade() + quantidade);
			
			if(itemAtualizado.getValorUnitario().compareTo(valorUnitario) != 0) {
				itemAtualizado.setValorUnitario(valorUnitario);
			}
			
			removerItem(itemAtualizado.getProduto());
			
			itens.add(itemAtualizado);
			
		} else {
			itens.add(new Item(produto, valorUnitario, quantidade));
		}

	}

	/**
	 * Permite a remoção do item que representa este produto do carrinho de compras.
	 *
	 * @param produto
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e
	 *         false caso o produto não exista no carrinho.
	 */
	public boolean removerItem(Produto produto) {
		return itens.removeIf(i -> i.getProduto().equals(produto));
	}

	/**
	 * Permite a remoção do item de acordo com a posição. Essa posição deve ser determinada pela
	 * ordem de inclusão do produto na coleção, em que zero representa o primeiro item.
	 *
	 * @param posicaoItem
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e
	 *         false caso o produto não exista no carrinho.
	 */
	public boolean removerItem(int posicaoItem) {

		Item item = itens.get(posicaoItem);

		return itens.removeIf(i -> i.getProduto().equals(item.getProduto()));
	}

	/**
	 * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais de todos
	 * os itens que compõem o carrinho.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTotal() {
		return itens.stream().map(Item::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	/**
	 * Retorna a lista de itens do carrinho de compras.
	 *
	 * @return itens
	 */
	public Collection<Item> getItens() {
		return itens;
	}
	
	public String getIdentificacaoCliente() {
		return identificacaoCliente;
	}
}