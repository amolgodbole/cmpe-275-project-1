package test.data.common;

import static org.junit.Assert.*;

import org.junit.Test;

import com.data.common.EncoderDecoder;
import com.jms.CopyOfSender;

/**
 * @author Nandish
 *
 */
public class EncoderTest {

	@Test
	public void testGetAllData() throws Exception {
		
		EncoderDecoder en = new EncoderDecoder();
		String str = en.getAllData("JSON");
		System.out.println("Returned String:"+str);
		CopyOfSender c = new CopyOfSender();
		c.sendResponse(str);
	}
	
	//@Test
	public void testExtractTemporalData()
	{
		System.out.println("testExtractTemporalData");
		EncoderDecoder en = new EncoderDecoder();
		en.getTemporalData("XML", "20080225", "20080229");
	}

	//@Test
	public void testGetSpatialData()
	{
		EncoderDecoder en = new EncoderDecoder();
		en.getSpatialData("XML", "AAPL", true, "20080227", "20080228");
	}
	
	//@Test
	public void testSender() throws Exception
	{
		CopyOfSender c = new CopyOfSender();
		c.sendResponse("Hello Nandish");
	}
}

