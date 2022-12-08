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
	public String searchUrl = ("https://api.open5e.com/monsters/?format=json&search=");
	
	public static void getName(URL c) throws IOException
	{
		
		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		
		Scanner scanner = new Scanner(c.openStream());
		
			try {
				
				Gson gson = new Gson();
				
				String rawData = scanner.nextLine();
				
				AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);
				
				System.out.println(monster.results[0].name);
				
				} catch (Exception e) {
				e.printStackTrace();
			}
		 }
	
	public static void getStrength(URL c) throws IOException
	{
		
		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		
		Scanner scanner = new Scanner(c.openStream());
		
			try {
				
				Gson gson = new Gson();
				
				String rawData = scanner.nextLine();
				
				AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);
				
				System.out.println(monster.results[0].strength);
				
				} catch (Exception e) {
				e.printStackTrace();
			}
		 }
	
	public static void getDexterity(URL c) throws IOException
	{
		
		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		
		Scanner scanner = new Scanner(c.openStream());
		
			try {
				
				Gson gson = new Gson();
				
				String rawData = scanner.nextLine();
				
				AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);
				
				System.out.println(monster.results[0].dexterity);
				
				} catch (Exception e) {
				e.printStackTrace();
			}
		 }
	
	public static void getConstitution(URL c) throws IOException
	{
		
		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		
		Scanner scanner = new Scanner(c.openStream());
		
			try {
				
				Gson gson = new Gson();
				
				String rawData = scanner.nextLine();
				
				AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);
				
				System.out.println(monster.results[0].constitution);
				
				} catch (Exception e) {
				e.printStackTrace();
			}
		 }
	
	public static void getWisdom(URL c) throws IOException
	{
		
		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		
		Scanner scanner = new Scanner(c.openStream());
		
			try {
				
				Gson gson = new Gson();
				
				String rawData = scanner.nextLine();
				
				AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);
				
				System.out.println(monster.results[0].wisdom);
				
				} catch (Exception e) {
				e.printStackTrace();
			}
		 }
	
	public static void getIntelligence(URL c) throws IOException
	{
		
		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		
		Scanner scanner = new Scanner(c.openStream());
		
			try {
				
				Gson gson = new Gson();
				
				String rawData = scanner.nextLine();
				
				AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);
				
				System.out.println(monster.results[0].intelligence);
				
				} catch (Exception e) {
				e.printStackTrace();
			}
		 }
	
	public static void getCharisma(URL c) throws IOException
	{
		
		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		
		Scanner scanner = new Scanner(c.openStream());
		
			try {
				
				Gson gson = new Gson();
				
				String rawData = scanner.nextLine();
				
				AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);
				
				System.out.println(monster.results[0].charisma);
				
				} catch (Exception e) {
				e.printStackTrace();
			}
		 }
	
	public static void getPerception(URL c) throws IOException
	{
		
		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		
		Scanner scanner = new Scanner(c.openStream());
		
			try {
				
				Gson gson = new Gson();
				
				String rawData = scanner.nextLine();
				
				AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);
				
				System.out.println(monster.results[0].perception);
				
				} catch (Exception e) {
				e.printStackTrace();
			}
		 }
	
	public static void getHitPoints(URL c) throws IOException
	{
		
		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		
		Scanner scanner = new Scanner(c.openStream());
		
			try {
				
				Gson gson = new Gson();
				
				String rawData = scanner.nextLine();
				
				AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);
				
				System.out.println(monster.results[0].hit_points);
				
				} catch (Exception e) {
				e.printStackTrace();
			}
		 }
	
	public static void getSize(URL c) throws IOException
	{
		
		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		
		Scanner scanner = new Scanner(c.openStream());
		
			try {
				
				Gson gson = new Gson();
				
				String rawData = scanner.nextLine();
				
				AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);
				
				System.out.println(monster.results[0].size);
				
				} catch (Exception e) {
				e.printStackTrace();
			}
		 }
	
	public static void getArmorClass(URL c) throws IOException
	{
		
		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		
		Scanner scanner = new Scanner(c.openStream());
		
			try {
				
				Gson gson = new Gson();
				
				String rawData = scanner.nextLine();
				
				AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);
				
				System.out.println(monster.results[0].armor_class);
				
				} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		
	
	
	//testing method that will be deleted upon completion of project
	public static void main(String[]args) throws IOException
	{
		
		MonsterMethods b = new MonsterMethods();
		
		getName(b.toUrl());
		getStrength(b.toUrl());
		getDexterity(b.toUrl());
		getConstitution(b.toUrl());
		getIntelligence(b.toUrl());
		getWisdom(b.toUrl());
		getCharisma(b.toUrl());
		getPerception(b.toUrl());
		getHitPoints(b.toUrl());
		getArmorClass(b.toUrl());
		getSize(b.toUrl());
		getStrength(b.toUrl());
		
		
		
		
		
		
		
	}

}
