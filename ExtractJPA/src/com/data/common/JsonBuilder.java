package com.data.common;

import java.io.File;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.extract.Stockdata;

/**
 * @author Nandish
 *
 */
public class JsonBuilder implements IBuilder{

	/* (non-Javadoc)
	 * @see com.data.common.IBuilder#encode(com.extract.Stockdata)
	 */
	@Override
	public byte[] encode(Stockdata msg) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File("stock.json"), msg);
			System.out.println("Converted to JSON:" + mapper.writeValueAsString(msg));
		} catch (Exception ex) {
			
		}
		
		return null;
	}
	
	@Override
	public byte[] encode(Object msg) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File("stock.json"), msg);
			System.out.println("Converted to JSON:" + mapper.writeValueAsString(msg));
		} catch (Exception ex) {
			
		}
		
		return null;
	}

	@Override
	public byte[] encode(List<Stockdata> msg) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File("stock.json"), msg);
			System.out.println("Converted to JSON:" + mapper.writeValueAsString(msg));
		} catch (Exception ex) {
			
		}
		return null;
	}
	
}
