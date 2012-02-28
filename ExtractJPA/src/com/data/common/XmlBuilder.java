package com.data.common;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;

import com.extract.StockCollection;
import com.extract.Stockdata;
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
	public byte[] encode(List<Stockdata> msg) {
		// TODO Auto-generated method stub
		try 
		{
			System.out.println("Xstream......");
			XStream xstream = new XStream();
			xstream.alias("stockdata", Stockdata.class);
			xstream.alias("stocks", StockCollection.class);
			xstream.addImplicitCollection(StockCollection.class, "list");
			StockCollection lst = new StockCollection();
			lst.setList(msg);
			String xml = xstream.toXML(lst);
			System.out.println("XML Out:" + xml);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
