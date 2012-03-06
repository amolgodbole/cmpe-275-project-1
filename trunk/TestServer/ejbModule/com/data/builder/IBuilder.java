package com.data.builder;

import java.util.List;

import com.data.entity.*;

/**
 * @author Nandish
 *
 */
public interface IBuilder		//all the builders will implement this interface. all of them have encode method
{
	public byte[] encode(Stockdata msg);
	public byte[] encode(Object msg);
	public String encode(List<Stockdata> msg);

}
