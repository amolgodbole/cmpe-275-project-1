import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
                                                                           
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.QueueSender;
import javax.jms.DeliveryMode;
import javax.jms.QueueSession;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
                                                                           
public class Sender
{
    public static void main(String[] args) throws Exception
    {
       // get the initial context
    	Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		properties.put(Context.URL_PKG_PREFIXES, "org.jnp.interfaces");
		properties.put(Context.PROVIDER_URL, "localhost");
   
		InitialContext ctx = new InitialContext(properties);
    	
    	//InitialContext ctx = new InitialContext();
                                                                          
       // lookup the queue object
       Queue queue = (Queue) ctx.lookup("queue/My");
                                                                          
       // lookup the queue connection factory
       QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.
           lookup("queue/connectionFactory");
                                                                          
       // create a queue connection
       QueueConnection queueConn = connFactory.createQueueConnection();
                                                                          
       // create a queue session
       QueueSession queueSession = queueConn.createQueueSession(false,
           Session.DUPS_OK_ACKNOWLEDGE);
                                                                          
       // create a queue sender
       QueueSender queueSender = queueSession.createSender(queue);
       queueSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
                                                                          
       // create a simple message to say "Hello"
       TextMessage message = queueSession.createTextMessage("Hello");
                                                                          
       // send the message
       queueSender.send(message);
                                                                          
       // print what we did
       System.out.println("sent: " + message.getText());
                                                                          
       // close the queue connection
    	queueConn.close();
    }
}