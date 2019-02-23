package com.fila.jms;

import java.math.BigDecimal;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fila.model.Categoria;
import com.fila.model.Fornecedor;
import com.fila.model.Produto;
import com.fila.service.ProdutoService;

/**
 * POC - ESPECIALIZACAO PUC MINAS
 * 
 * @author James Rugno
 *
 */
@Component
public class LerMensagem {
	
	@Autowired
	private EnviarMensagem enviarMensagem;
	
	@Autowired
	private ProdutoService produtoService;
	
	private static Logger log = LoggerFactory.getLogger(LerMensagem.class);

    @JmsListener(destination = "cadastrarprodutos.read")
    public void receiveMessage(final Message message) throws JMSException {
    	String messageData = null;
    	
    	if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			messageData = textMessage.getText();
			System.out.println(messageData);
			log.info(messageData);
    	}
    	
    	//Exemplo: Node.js;Aplicações web real-time com Node.js xxxxxxxxxxxxxxxxxxxxxxx;29.90;999;assets/img/livro-node.jpg;;;;;1;1
    	String[] strMsg = messageData.split(";");
    	
    	Produto produto = new Produto();
    	produto.setNome(strMsg[0]);
    	produto.setDescricao(strMsg[1]);
    	produto.setValor(new BigDecimal(strMsg[2]));
    	produto.setQtd(Integer.valueOf(strMsg[3]));
    	produto.setStatus("ATIVO");
    	produto.setImg1(strMsg[4]);
    	produto.setImg2(strMsg[5]);
    	produto.setImg3(strMsg[6]);
    	produto.setImg4(strMsg[7]);
    	produto.setImg5(strMsg[8]);
    	
    	Categoria categoria = new Categoria();
    	categoria.setCodigo(Long.valueOf(strMsg[9]));
    	produto.setCategoria(categoria);
    	
    	Fornecedor fornecedor = new Fornecedor();
    	fornecedor.setCodigo(Long.valueOf(strMsg[10]));
    	produto.setFornecedor(fornecedor);
    	
    	produto.setAtivo(true);
    	produto = produtoService.salvar(produto);
    	
		enviarMensagem.send("Produto: " + produto.getNome()  + " cadastrado com sucesso.");
    }
	
}
