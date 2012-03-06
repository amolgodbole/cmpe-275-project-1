package com.dataload;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nandish
 * Read the Input File/Directory. If the input is file then read through the file and call LoadData to persist.
 * If the input is a directory, the get all the files present in the directory and read thru each file to persist. 
 */
public class ReadTicker {

	//private List<File> list = new ArrayList<File>();	
	
	
	/*
	private void discoverFiles(File dir)
	{
		if (dir == null || dir.isFile())
		{
			//do nothing
		}
		
		File[] dirs = dir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File f) {
				if (f.isFile())
					list.add(f);
				else if (f.isDirectory()) {
					discoverFiles(f);
				}

				return false;
			}
		});
	}*/
	
	
	public void readfile(File f)
	{
		FileInputStream fstream;
		DataInputStream in;
		BufferedReader br;
		LoadTicker data;
		data = new LoadTicker();
		data.beginTran();
		
			try
			{			  
				  fstream = new FileInputStream(f);
				  in = new DataInputStream(fstream);
				  br = new BufferedReader(new InputStreamReader(in));
				  String strLine;
				  while ((strLine = br.readLine()) != null)   
				  { 				  
					  data.insert(strLine);
				  }
				  in.close();
				  
			  }		  
			catch (Exception e)
			{//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			}
		  
		data.closecon();
		
	}
	
/*	public void readfile()
	{
		try
		  {
		
			  FileInputStream fstream = new FileInputStream("inputfiles\\sp080304.txt");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  LoadData data = new LoadData();
			  data.beginTran();
			  
			  while ((strLine = br.readLine()) != null)   
			  { 				  
				  data.insert(strLine);
			  }
			  in.close();
			  data.closecon();
		
		  }
		  catch (Exception e)
		  {//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		  }
	}*/
	
	/*public static void main(String args[])
	{
		ReadInput r = new ReadInput();
		r.readfile();
	}
	*/
}
