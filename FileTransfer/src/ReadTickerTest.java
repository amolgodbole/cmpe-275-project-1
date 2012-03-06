package test.data.common;


import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;


import com.dataload.ReadTicker;


public class ReadTickerTest {

		@Test
		public void testReadfile() {

			File dir = new File("tickerInfo1.csv");	
			ReadTicker data = new ReadTicker();
			data.readfile(dir);
			
		}

	
	}
