package com.fila.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.fila.model.Produto;

/**
 * POC - ESPECIALIZACAO PUC MINAS
 * 
 * @author James Rugno
 *
 */
public class Unmarshal {

	public static void main(String[] args) throws JAXBException {
		
		JAXBContext ctx = JAXBContext.newInstance(Produto.class);
		Unmarshaller unmarshaller = ctx.createUnmarshaller();
		
		Produto produto = (Produto) unmarshaller.unmarshal(new File("Produto.xml"));
		System.out.println("Nome: " + produto.getNome());
		System.out.println("Descrição: " + produto.getDescricao());
		System.out.println("Qtd: " + produto.getQtd());
		System.out.println("Valor: " + produto.getValor());
		System.out.println("Descrição: " + produto.getDescricao());
		System.out.println("Categoria - codigo: "+ produto.getCategoria().getCodigo());
		System.out.println("Fornecedor - codigo: "+ produto.getCategoria().getCodigo());
		
	}
}
