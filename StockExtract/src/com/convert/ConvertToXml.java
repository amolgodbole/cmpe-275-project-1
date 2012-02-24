package com.convert;


import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.extract.StockData;

public class ConvertToXml {

	/**
	 * @param args
	 */
	
	public void convert(StockData stk) throws Exception 
	{
		JAXBContext contextObj = JAXBContext.newInstance(StockData.class);

	    Marshaller marshallerObj = contextObj.createMarshaller();
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    
	    marshallerObj.marshal(stk, new FileOutputStream("Stock.xml"));
	}
	
	

	public void convertList(ArrayList<StockData> stk) throws Exception 
	{
		JAXBContext contextObj = JAXBContext.newInstance(StockData.class);

	    Marshaller marshallerObj = contextObj.createMarshaller();
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    
	    marshallerObj.marshal(stk, new FileOutputStream("Stock.xml"));
	}
	
	public static void main(String[] args) throws Exception {
	    JAXBContext contextObj = JAXBContext.newInstance(Student.class);

	    Marshaller marshallerObj = contextObj.createMarshaller();
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	    Student myStudent = new Student();
	    myStudent.setGender("M");
	    myStudent.setName("Amar");
	    myStudent.setAge(20);
	    marshallerObj.marshal(myStudent, new FileOutputStream("Student.xml"));  
	 

	  }

}
