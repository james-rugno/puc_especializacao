package br.com.puc.carrinho;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 * 
 * @author James Rugno
 */
public class CarrinhoComprasFactory {

	private static List<CarrinhoCompras> carrinhos = new ArrayList<>();

	private static CarrinhoCompras instancia = new CarrinhoCompras();

	private CarrinhoComprasFactory() {

	}

	/**
     * Cria e retorna um novo carrinho de compras para o cliente passado como parâmetro.
     *
     * Caso já exista um carrinho de compras para o cliente passado como parâmetro, este carrinho deverá ser retornado.
     *
     * @param identificacaoCliente
     * @return CarrinhoCompras
     */
    public static CarrinhoCompras criar(String identificacaoCliente) {
    	
    	Optional<CarrinhoCompras> carrinho = carrinhos.stream()
    			.filter(c -> c.getIdentificacaoCliente().equals(identificacaoCliente)).findAny();
    	
    	if(carrinho.isPresent()) {
    		return carrinho.get();
    	}else {
    		carrinhos.add(instancia);
    		return instancia;
    	}

    }

	/**
	 * Retorna o valor do ticket médio no momento da chamada ao método. O valor do ticket médio é a
	 * soma do valor total de todos os carrinhos de compra dividido pela quantidade de carrinhos de
	 * compra. O valor retornado deverá ser arredondado com duas casas decimais, seguindo a regra:
	 * 0-4 deve ser arredondado para baixo e 5-9 deve ser arredondado para cima.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTicketMedio() {
		BigDecimal totalValor = carrinhos.stream().
				map(CarrinhoCompras::getValorTotal).
				reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return totalValor.divide(new BigDecimal(carrinhos.size()), RoundingMode.HALF_UP);
				
	}

	/**
	 * Invalida um carrinho de compras quando o cliente faz um checkout ou sua sessão expirar. Deve
	 * ser efetuada a remoção do carrinho do cliente passado como parâmetro da listagem de carrinhos
	 * de compras.
	 *
	 * @param identificacaoCliente
	 * @return Retorna um boolean, tendo o valor true caso o cliente passado como parämetro tenha um
	 *         carrinho de compras e e false caso o cliente não possua um carrinho.
	 */
	public boolean invalidar(String identificacaoCliente) {
		
		Optional<CarrinhoCompras> carrinho = 
				carrinhos.stream().
				filter(c -> c.getIdentificacaoCliente().equals(identificacaoCliente))
				.findAny();
		
		if(carrinho.isPresent()) {
			carrinhos.removeIf(c -> c.getIdentificacaoCliente().equals(identificacaoCliente));
			return true;
		}else {
			return false;
		}
		
		
		
	}
}
