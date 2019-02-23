package com.fila.util;

import java.io.FileOutputStream;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.fila.model.Categoria;
import com.fila.model.Fornecedor;
import com.fila.model.Produto;

/**
 * POC - ESPECIALIZACAO PUC MINAS
 * 
 * @author James Rugno
 *
 */
public class Marshal {
	
	public static void main(String[] args) throws Exception {
		
		Produto produto = new Produto();
		produto.setCodigo(102L);
		produto.setNome("MongoDB");
		produto.setDescricao("Construa novas aplicações com novas tecnologias");
		produto.setValor(new BigDecimal("29.90"));
		produto.setQtd(89);
		produto.setStatus("");
		produto.setImg1("assets/img/livro-node.jpg");
		produto.setImg2("");
		produto.setImg3("");
		produto.setImg4("");
		produto.setImg5("");
		produto.setAtivo(true);
		
		Categoria categoria = new Categoria();
		categoria.setCodigo(1L);
		produto.setCategoria(categoria);
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCodigo(1L);
		produto.setFornecedor(fornecedor);
		
		JAXBContext ctx = JAXBContext.newInstance(Produto.class);
		Marshaller marshaller = ctx.createMarshaller();
		marshaller.marshal(produto, new FileOutputStream("Produto.xml"));
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
	
	}

}
