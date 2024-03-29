package com.data.common;

import java.util.ArrayList;
import java.util.List;

import com.extract.ExtractData;
import com.extract.Stockdata;

/**
 * @author Nandish
 * Gets the request and the parameters from client.
 * Calls ExtractData to get the requested data
 */
public class EncoderDecoder {

	public enum SerializationType{XML, JSON};
	
	public IBuilder get_builder(SerializationType type)
	{
		switch(type)
		{
			case XML:
				return new XmlBuilder();		//if type is XML, call XmlBuilder.
				
			case JSON:
				return new JsonBuilder();		//if type is JSON, call JsonBuilder
				
		}
		return null;
	}
	
/*	public byte[] encode(Stockdata msg, String trantype)
	{
		SerializationType type = SerializationType.JSON;
		if (trantype.equalsIgnoreCase("XML")){
			type = SerializationType.XML;
		}else if (trantype.equalsIgnoreCase("JSON")){
			type = SerializationType.JSON;
		}
		byte[] encoded = get_builder(type).encode(msg);
		return encoded;
	}*/
	
	
	//keep this one and remove the other Arraylist one
	public String encode(List<Stockdata> msg, String trantype)
	{
		SerializationType type = SerializationType.JSON;
		if (trantype.equalsIgnoreCase("XML")){
			type = SerializationType.XML;
		}else if (trantype.equalsIgnoreCase("JSON")){
			type = SerializationType.JSON;
		}
		return get_builder(type).encode(msg);
		
	}
	
/*	public void encode(Object msg, String trantype)
	{
		SerializationType type = SerializationType.JSON;
		if (trantype.equalsIgnoreCase("XML")){
			type = SerializationType.XML;
		}else if (trantype.equalsIgnoreCase("JSON")){
			type = SerializationType.JSON;
		}
		byte[] encoded = get_builder(type).encode(msg);
		
	}*/
	
	public String getSpatialData(String format, String ticker, boolean range, String StartDate, String EndDate)
	{
		ExtractData data = new ExtractData();
		if(range) //gets the spatial data for the specified region with date range
		{
			return encode(data.extractSpatialData(ticker, StartDate, EndDate), format);
		}
		else //gets the spatial entire dataset for the specified region
		{		
			return encode(data.extractAllSpatialData(ticker), format);
		}
		
	}
	public String getTemporalData(String format, String StartDate, String EndDate)
	{
		ExtractData data = new ExtractData();
		return encode(data.extractTemporalData(StartDate, EndDate), format);
	}
	public String getAllData(String format)
	{
		ExtractData data = new ExtractData();
		return encode(data.extract(), format);
	}
}
