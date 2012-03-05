package test.jms.request;

import org.junit.Test;

import com.jms.producer.RequestProducer;
import com.request.data.RequestData;

public class TestRequest {

	@Test
	public void testCreateRequest() throws Exception
	{
		RequestData r = new RequestData();
		r.setRequestType("temporal");
		r.setTicker("AAPL");
				
		StringBuilder str = new StringBuilder();
		str.append(r.getRequestType());
		str.append(",");
		str.append(r.getStartDate());
		str.append(",");
		str.append(r.getEndDate());
		str.append(",");
		str.append(r.getTicker());
		str.append(",");
		str.append(r.getLocation());
		str.append(",");
		str.append(r.getSector());
		str.append(",");
		str.append(r.getIndustry());
		
		System.out.println("Req:" + str);
		
		RequestProducer request = new RequestProducer();
		request.sendRequest(str.toString());
			
		
		
	}
	
}
