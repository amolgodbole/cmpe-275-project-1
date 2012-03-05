package test.data.common;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.data.load.ReadInput;

/**
 * @author Nandish
 *
 */
public class ReadInputTest {

	@Test
	public void testReadfile() {

		File dir = new File("inputfiles");	
		ReadInput data = new ReadInput();
		data.load(dir);
		
	}

}
