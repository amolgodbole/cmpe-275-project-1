package test.data.common;

import static org.junit.Assert.*;

import org.junit.Test;

import com.data.common.EncoderDecoder;

/**
 * @author Nandish
 *
 */
public class EncoderTest {

	
	public void testGetAllData() {
		
		EncoderDecoder en = new EncoderDecoder();
		en.getAllData();

		
	}
	
	//@Test
	public void testExtractTemporalData()
	{
		System.out.println("testExtractTemporalData");
		EncoderDecoder en = new EncoderDecoder();
		en.getTemporalData("JSON", "20080225", "20080229");
	}

	@Test
	public void testGetSpatialData()
	{
		EncoderDecoder en = new EncoderDecoder();
		en.getSpatialData("XML", "AAPL", true, "20080227", "20080228");
	}
}
