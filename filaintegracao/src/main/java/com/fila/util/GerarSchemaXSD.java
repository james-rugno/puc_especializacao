package com.fila.util;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import com.fila.model.Produto;

/**
 * POC - ESPECIALIZACAO PUC MINAS
 * 
 * @author James Rugno
 *
 */
public class GerarSchemaXSD {
	public static void main(String[] args) throws Exception {
		
		JAXBContext ctx = JAXBContext.newInstance(Produto.class);
		ctx.generateSchema(new SchemaOutputResolver() {
			
			@Override
			public Result createOutput(String namespaceUri, String suggestedFileName)
					throws IOException {
				StreamResult result = new StreamResult (new File("Produto.xsd"));
				
				return result;
			}
		});
	}

}
