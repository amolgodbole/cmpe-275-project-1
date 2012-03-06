package com.data.builder;


import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;

import com.data.entity.StockCollection;
import com.data.entity.Stockdata;
import com.thoughtworks.xstream.XStream;

/**
 * @author Nandish
 *
 */
public class XmlBuilder implements IBuilder{

	@Override
	public byte[] encode(Stockdata msg) {
		try 
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(Stockdata.class);
			StringWriter writer = new StringWriter();
			jaxbContext.createMarshaller().marshal(msg, writer);
			System.out.println("XMLOutput: " + writer.toString());
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public byte[] encode(Object msg) {
		// TODO Auto-generated method stub
		try 
		{
			System.out.println("XML object......");
		/*	List<Stockdata> l = (List<Stockdata>) msg;
			JAXBContext jaxbContext = JAXBContext.newInstance(Stockdata.class);
			StringWriter writer = new StringWriter();
			//jaxbContext.createMarshaller().marshal(msg, writer);
			jaxbContext.createMarshaller().marshal(l.get(0), writer);
			System.out.println("XMLOutput: " + writer.toString());
			jaxbContext.createMarshaller().marshal(l.get(1), writer);
			System.out.println("XMLOutput: " + writer.toString());
			*/
			/*System.out.println("Xstream......");
			XStream xstream = new XStream();
			xstream.alias("stockdata", Stockdata.class);
			xstream.alias("stocks", StockCollection.class);
			xstream.addImplicitCollection(StockCollection.class, "list");
			
			StockCollection lst = new StockCollection();
			//lst.setList((List<Stockdata>) msg);
			List<Stockdata> l = (List<Stockdata>) msg;
			lst.add(l.get(0));
			String xml = xstream.toXML(lst);
			System.out.println("XML Out:" + xml);*/
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public String encode(List<Stockdata> msg) {
		// TODO Auto-generated method stub
		String xml;
	/*	try 
		{*/
			System.out.println("Xstream......");
			XStream xstream = new XStream();
			xstream.alias("stockdata", Stockdata.class);
			xstream.alias("stocks", StockCollection.class);
			xstream.addImplicitCollection(StockCollection.class, "list");
			StockCollection lst = new StockCollection();
			lst.setList(msg);
			xml = xstream.toXML(lst);
			System.out.println("XML Out:" + xml);
			//write to file
		    try {
		        BufferedWriter out = new BufferedWriter(new FileWriter("Stock.xml"));
		        out.write(xml);
		        out.close();
		      } catch (IOException e) {
		        e.printStackTrace();
		      }
	/*	}
		catch (Exception ex) {
			ex.printStackTrace();
		}*/
		return xml;
	}
}
