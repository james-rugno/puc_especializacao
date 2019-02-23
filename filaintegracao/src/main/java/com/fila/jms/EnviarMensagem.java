package com.fila.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fila.model.Produto;

/**
 * POC - ESPECIALIZACAO PUC MINAS
 * 
 * @author James Rugno
 *
 */
@Service
public class EnviarMensagem {

	private static Logger log = LoggerFactory.getLogger(EnviarMensagem.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Produto myMessage) {
        log.info("sending with convertAndSend() to queue <" + myMessage + ">");
        jmsTemplate.convertAndSend("cadastrarprodutos.write", myMessage);
    }
    
    public void send(String myMessage) {
        log.info("sending with convertAndSend() to queue <" + myMessage + ">");
        jmsTemplate.convertAndSend("cadastrarprodutos.write", myMessage);
    }
	
}
