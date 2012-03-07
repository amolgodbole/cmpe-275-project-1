package test.data.common;

import static org.junit.Assert.*;

import org.junit.Test;

import com.data.business.StockProvider;


//import com.jms.response.ResponseProducer;

/**
 * @author Nandish
 *
 */
public class EncoderTest {

	@Test
	public void testGetAllData() throws Exception {
		
		StockProvider en = new StockProvider();
		String str = en.getAllData("CSV");
		System.out.println("Returned String:"+str);
//		ResponseProducer c = new ResponseProducer();
//		c.sendResponse(str);
	}
	
	//@Test
	public void testExtractTemporalData()
	{
		System.out.println("testExtractTemporalData");
		StockProvider en = new StockProvider();
		en.getTemporalData("XML", "20080225", "20080229");
	}

	//@Test
	public void testGetSpatialData()
	{
		StockProvider en = new StockProvider();
		en.getSpatialData("XML", "AAPL", true, "20080227", "20080228");
	}
	
	//@Test
	public void testSender() throws Exception
	{
//		ResponseProducer c = new ResponseProducer();
//		c.sendResponse("Hello Nandish");
	}
}

