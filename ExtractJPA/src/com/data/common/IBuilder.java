package com.data.common;

import java.util.List;

import com.extract.Stockdata;

/**
 * @author Nandish
 *
 */
public interface IBuilder		//all the builders will implement this interface. all of them have encode method
{
	public byte[] encode(Stockdata msg);
	public byte[] encode(Object msg);
	public byte[] encode(List<Stockdata> msg);

}
