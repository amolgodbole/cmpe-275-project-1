package com.convert;


import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class ObjectToXml {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
	    JAXBContext contextObj = JAXBContext.newInstance(Student.class);

	    Marshaller marshallerObj = contextObj.createMarshaller();
	    
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	    Student myStudent = new Student();
	    Student myStudent1 = new Student();
	    myStudent.setGender("M");
	    myStudent.setName("Amar");
	    myStudent.setAge(20);
	    myStudent1.setGender("N");
	    myStudent1.setName("AmarN");
	    myStudent1.setAge(20);
	    marshallerObj.marshal(myStudent, new FileOutputStream("Student.xml"));  
	    

	  }

}
