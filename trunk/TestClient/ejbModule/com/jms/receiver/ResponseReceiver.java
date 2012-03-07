package com.jms.receiver;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: ClientJMS
 *
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
				@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/ResponseQueue")})
public class ResponseReceiver implements MessageListener {

    /**
     * Default constructor. 
     */
    public ResponseReceiver() {
        // TODO Auto-generated constructor stub
    }
    MessageDrivenContext mdc;
	/**
     * @see MessageListener#onMessage(Message)
     */
  
    public void onMessage(Message message) {
        // TODO Auto-generated method stub

      	//Working - String
  		TextMessage msg = (TextMessage) message;
    	
    	try {
			System.out.println("Received on TestClient:"+msg.getText().toString());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
    	
    	
    	
        
    }

}
