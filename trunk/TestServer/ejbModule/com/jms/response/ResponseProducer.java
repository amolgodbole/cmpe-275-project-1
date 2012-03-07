package com.jms.response;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
                                                                           
import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.QueueSender;
import javax.jms.DeliveryMode;
import javax.jms.QueueSession;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
                                                                           
public class ResponseProducer
{
	
	public void sendResponse(String response) throws Exception
	{
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		properties.put(Context.URL_PKG_PREFIXES, "org.jnp.interfaces");
		properties.put(Context.PROVIDER_URL, "localhost");
   
		InitialContext ctx = new InitialContext(properties);
    	
    	//InitialContext ctx = new InitialContext();
                                                                          
       // lookup the queue object
       Queue queue = (Queue) ctx.lookup("queue/ResponseQueue");
                                                                          
       // lookup the queue connection factory
       QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.lookup("XAConnectionFactory");
                                                                          
       // create a queue connection
       QueueConnection queueConn = connFactory.createQueueConnection();
                                                                          
       // create a queue session
       QueueSession queueSession = queueConn.createQueueSession(false, Session.DUPS_OK_ACKNOWLEDGE);
       
       QueueSender queueSender = queueSession.createSender(queue);
       queueSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
       
       TextMessage message = queueSession.createTextMessage(response);
       System.out.println("placing message on ResponseQueue");
       queueSender.send(message);
       
       queueConn.close();
		
	}
	
	
  /*  public static void main(String[] args) throws Exception
    {
       // get the initial context
    	Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		properties.put(Context.URL_PKG_PREFIXES, "org.jnp.interfaces");
		properties.put(Context.PROVIDER_URL, "localhost");
   
		InitialContext ctx = new InitialContext(properties);
    	
    	//InitialContext ctx = new InitialContext();
                                                                          
       // lookup the queue object
       Queue queue = (Queue) ctx.lookup("queue/MyQueue");
                                                                          
       // lookup the queue connection factory
       QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.lookup("XAConnectionFactory");
                                                                          
       // create a queue connection
       QueueConnection queueConn = connFactory.createQueueConnection();
                                                                          
       // create a queue session
       QueueSession queueSession = queueConn.createQueueSession(false,
           Session.DUPS_OK_ACKNOWLEDGE);
       
       MessageProducer producer = queueSession.createProducer(queue);
       Student s = new Student();
       s.setId(1);
       s.setName("Nandish");
       ObjectMessage message = queueSession.createObjectMessage();
       producer.send( message );
       queueConn.close();
    }*/
}