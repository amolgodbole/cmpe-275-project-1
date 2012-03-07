package com.data.load;

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
public class ReadInput {

	private List<File> list = new ArrayList<File>();	
	
	public void load(File f)
	{
		if (f == null)
			System.out.println("Not a File");
			//return null;

		if (f.isFile())
			list.add(f);
		else 
			discoverFiles(f);

		System.out.println("---> " + list);
		readfile();
		
	}
	
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
	}
	
	
	public void readfile()
	{
		FileInputStream fstream;
		DataInputStream in;
		BufferedReader br;
		LoadData data;
		data = new LoadData();
		data.beginTran();
		for (File f : list)
		  {
			try
			{			  
				  fstream = new FileInputStream(f);
				  in = new DataInputStream(fstream);
				  br = new BufferedReader(new InputStreamReader(in));
				  String strLine;
				  while ((strLine = br.readLine()) != null)   
				  { 	
					  System.out.println("in readfile module");
					  data.insert(strLine);
				  }
				  in.close();
				  
			  }		  
			catch (Exception e)
			{//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			}
		  }
		data.closecon();
		
	}
	
}
