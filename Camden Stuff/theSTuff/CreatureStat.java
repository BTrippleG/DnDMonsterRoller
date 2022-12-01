package theSTuff;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CreatureStat extends MonsterParser
{
	
	public int getCreatureStat(String stat)
	{
		return 1;
		
		
		
		
		
	}
	
	
	
	
	public static void apiFetch() throws IOException
	{
		URL url = new URL("https://api.open5e.com/?format=json&monsters");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responsecode = conn.getResponseCode();

		
		String rawData = "";
	    Scanner scanner = new Scanner(url.openStream());
		while (scanner.hasNext()) {
		       rawData += scanner.nextLine();
		    }
		
		if (responsecode != 200) {
		    throw new RuntimeException("HttpResponseCode: " + responsecode);
		} else {
			
			JSONParser parser = new JSONParser();
			try {
				Object obj = parser.parse(rawData);
				JSONObject jsonObject = (JSONObject) obj;
				JSONArray results = (JSONArray) jsonObject.get(jsonObject);
				JSONObject thing = (JSONArray) jsonObject.get(strength);
				
				System.out.println(results);
				
				
			} catch (Exception e) {
				// System.out.println("name not found");
				e.printStackTrace();
			}
		    
		    
		
		}
		
	}
	
	public static void main(String[]args) throws IOException
	{
		apiFetch();
		
		
	}

}
