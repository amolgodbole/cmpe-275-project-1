import javax.naming.InitialContext;
                    
import java.util.Properties;
import javax.jms.*;
import javax.naming.*;
//import javax.jms.Queue;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//import javax.jms.QueueSession;
//import javax.jms.QueueReceiver;
//import javax.jms.QueueConnection;
//import javax.jms.QueueConnectionFactory;
                                                                           
public class Receiver
{
    public static void main(String[] args) throws Exception
    {
       // get the initial context
    	Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		properties.put(Context.URL_PKG_PREFIXES, "org.jnp.interfaces");
		properties.put(Context.PROVIDER_URL, "localhost");
   
		InitialContext ctx = new InitialContext(properties);
                                
       // lookup the queue object
       Queue queue = (Queue) ctx.lookup("queue/MyQueue");
                                                                          
       // lookup the queue connection factory
       QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.
           lookup("queue/connectionFactory");
                                                                          
       // create a queue connection
       QueueConnection queueConn = connFactory.createQueueConnection();
                                                                          
       // create a queue session
       QueueSession queueSession = queueConn.createQueueSession(false,
           Session.AUTO_ACKNOWLEDGE);
                                                                          
       // create a queue receiver
       QueueReceiver queueReceiver = queueSession.createReceiver(queue);
                                                                          
       // start the connection
       queueConn.start();
                                                                          
       // receive a message
       TextMessage message = (TextMessage) queueReceiver.receive();
                                                                          
       // print the message
       System.out.println("received: " + message.getText());
                                                                          
       // close the queue connection
       queueConn.close();
    }
}