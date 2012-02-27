package com.jms.sender;

import java.net.URL;

import javax.jms.MessageNotWriteableException;

public interface FileMessage extends javax.jms.Message {
    /**
     * Returns the URL of the file.
     * The URL object is readable by <code>URL.openStream()</code>.
     *  
     * @return the <code>URL</code> of the file.
     */
    URL getURL();

    /**
     * Set the URL of the file. 
     * The URL object should be readable by <code>URL.openStream()</code>.
     * 
     * @param url the <code>URL</code> of the file.
     * @exception MessageNotWriteableException if the message is in read-only mode.
     */
    void setURL(URL url) throws MessageNotWriteableException;
}