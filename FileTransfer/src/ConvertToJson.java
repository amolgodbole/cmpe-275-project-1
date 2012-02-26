
import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

public class ConvertToJson {

	public void encode(Object data) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File("stock.json"), data);
			System.out.println("Converted to JSON:" + mapper.writeValueAsString(data));
		} catch (Exception ex) {
			
		}
	}

	
}
