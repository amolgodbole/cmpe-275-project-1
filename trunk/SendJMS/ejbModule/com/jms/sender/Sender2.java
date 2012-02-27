package com.jms.sender;

import java.io.File;


import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.Session;
import javax.naming.InitialContext;

public class Sender2 {

	
/*InitialContext ic = new InitialContext();
    
    QueueConnectionFactory qconFactory = (QueueConnectionFactory)ic.lookup("QueueConnectionFactory");
    QueueConnection qcon = qconFactory.createQueueConnection();

    // JEUS-specific Session
    JeusQueueSession qsession = (JeusQueueSession) qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
    
    Queue queue = (Queue)ic.lookup("ExamplesQueue");
    QueueSender qsender = qsession.createSender(queue);

    // Create a FileMessage using JeusQueueSession
    FileMessage msg = qsession.createFileMessage();
    
    // set file URL and send the message
    File file1 = new File("/home/wonskim/temp/file1.jar");
    msg.setURL(file1.toURL());
    qsender.send(msg);
    
    qsender.close();
    qsession.close();
    qcon.close();*/
}
