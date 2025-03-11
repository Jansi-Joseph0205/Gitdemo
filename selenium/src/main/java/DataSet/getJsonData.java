package DataSet;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class getJsonData {
	
	public List<HashMap<String,String>> getJsontoMap() throws IOException{
	//	@SuppressWarnings("deprecation")
	String jsonContent = FileUtils.readFileToString(new  File(System.getProperty("user.dir")+"\\src\\main\\java\\DataSet\\PurchaseOrder.json"), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap <String,String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
			
		});
		return data;
		
}

}
