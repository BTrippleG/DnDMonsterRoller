package theSTuff;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CreatureStat
{
	
	public int getCreatureStat(String stat)
	{
		return 1;
		
		
		
		
		
	}
	
	
	
	
	public static void apiFetch() throws IOException
	{
		URL url = new URL("https://api.open5e.com/monsters/?format=json");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responsecode = conn.getResponseCode();
		
		Scanner scanner = new Scanner(url.openStream());

		/*
		String rawData = "";
	    Scanner scanner = new Scanner(url.openStream());
		while (scanner.hasNext()) {
		       rawData += scanner.nextLine();
		    }
		
		if (responsecode != 200) {
		    throw new RuntimeException("HttpResponseCode: " + responsecode);
		} else {
			
			Gson gson = new Gson();
			
			*/
			
			try {
				
				Gson gson = new Gson();
				
				String rawData = scanner.nextLine();
				
				Monster object = gson.fromJson(rawData, Monster.class);
				
				
				System.out.println(object.strength);
				
				
				
				
				
				
				
				
				
				
			} catch (Exception e) {
				// System.out.println("name not found");
				e.printStackTrace();
			}
		    
		    
		
		}
		
	
	public static void main(String[]args) throws IOException
	{
		apiFetch();
		
		
	}

}
