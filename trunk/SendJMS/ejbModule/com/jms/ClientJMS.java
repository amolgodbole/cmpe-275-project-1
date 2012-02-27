package com.jms;

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
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: ClientJMS
 *
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
				@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/MyQueue")})
public class ClientJMS implements MessageListener {

    /**
     * Default constructor. 
     */
    public ClientJMS() {
        // TODO Auto-generated constructor stub
    }
    MessageDrivenContext mdc;
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
    	TextMessage msg = (TextMessage) message;
    	System.out.println("Received:"+msg.toString());
    	
    	
		/*try {
			BytesMessage messageReceived = (BytesMessage)message;
	    	File outputFile = new File("huge_message_received.dat");
	    	FileOutputStream fileOutputStream;
			fileOutputStream = new FileOutputStream(outputFile);
			BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutputStream);
			messageReceived.setObjectProperty("JMS_JBM_SaveStream", bufferedOutput);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	
    	
        
    }

}
