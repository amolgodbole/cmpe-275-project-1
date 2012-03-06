package com.data.builder;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.data.entity.*;

public class CSVBuilder implements IBuilder{
	
	@Override
	public String encode(List<Stockdata> msg) {
		String csvdata = null;
		try {
			
			FileWriter writer = new FileWriter("C:\\Kavya\\stocks.csv");
	
			writer.append("StockDate");
			writer.append(',');
			writer.append("Ticker");
			writer.append(',');
			writer.append("Close");
			writer.append(',');
			writer.append("High");
			writer.append(',');
			writer.append("Low");
			writer.append(',');
			writer.append("Open");
			writer.append(',');
			writer.append("Volume");
			writer.append('\n');
			 
			Iterator<Stockdata> it = (Iterator) msg.iterator();
			
			while (it.hasNext()){
				Stockdata stockdata = it.next();
				writer.append(stockdata.getId().getStockDate());
				writer.append(',');
				writer.append(stockdata.getId().getTicker());
				writer.append(',');
				writer.append(stockdata.getClose().toString());
				writer.append(',');
				writer.append(stockdata.getHigh().toString());
				writer.append(',');
				writer.append(stockdata.getLow().toString());
				writer.append(',');
				writer.append(stockdata.getOpen().toString());
				writer.append(',');
				writer.append(stockdata.getVolume().toString());
				writer.append('\n');
			}
	 
		    //generate whatever data you want
	 
		    writer.flush();
		    writer.close();
		    csvdata = writer.toString();
		    
		} catch (Exception ex) {
			return null;
		}
		return csvdata;
	}

	@Override
	public byte[] encode(Stockdata msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] encode(Object msg) {
		// TODO Auto-generated method stub
		return null;
	}
}
