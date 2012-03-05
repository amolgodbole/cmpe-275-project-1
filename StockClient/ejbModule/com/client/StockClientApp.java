package com.client;

public class StockClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StockDataClient data = new StockDataClient();
		System.out.println("Client Output: "+ data.getAllData("XML"));
		
		
	}

}
