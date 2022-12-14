package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.net.HttpURLConnection;
import java.util.Scanner;

import com.google.gson.Gson;

public class MonsterMethods {
	public String strength;
	public String dexterity;
	public String constitution;
	public String intelligents;
	public String wisdom;
	public String charisma;
	public String name, size, type, alignment;
	public String armorDesc, armor, hitPoints, hitDice, damRest, damImm;
	public String imageString;
	public String searchUrl = ("https://api.open5e.com/monsters/?format=json&search=");
	public Random random = new Random();
	public String slug;
	public String saved;

	public MonsterMethods() {
	}

	public URL toUrl() throws MalformedURLException {

		int r = random.nextInt(1470);

		try (BufferedReader br = new BufferedReader(new FileReader("MonsterList"))) {
			for (int i = 0; i < r; i++)
				br.readLine();
			slug = br.readLine();

		} catch (IOException e) {
			System.out.println(e);
		}

		String urlString = searchUrl + slug;
		URL url = new URL(urlString);

		return url;
	}

	public void setImageString() {
		// change to this.imageString
		this.type = this.type.toLowerCase();

		if (type.contains("humanoid")) {
			this.imageString = "https://cdn.glitch.global/26fc264b-db73-4a01-833f-fd533c30491d/Humanoid.png?v=1670972451657";

		} else if (type.contains("aberration")) {
			this.imageString = "https://cdn.glitch.global/26fc264b-db73-4a01-833f-fd533c30491d/Aberration.png?v=1670971573718";

		} else if (type.contains("beast")) {
			this.imageString = "https://cdn.glitch.global/26fc264b-db73-4a01-833f-fd533c30491d/Beast.png?v=1670971763940";

		} else if (type.contains("celestial")) {
			this.imageString = "https://cdn.glitch.global/26fc264b-db73-4a01-833f-fd533c30491d/Celeste.png?v=1670972423651";

		} else if (type.contains("construct")) {
			this.imageString = "https://cdn.glitch.global/26fc264b-db73-4a01-833f-fd533c30491d/Construct.png?v=1670972427382";

		} else if (type.contains("dragon")) {
			this.imageString = "https://cdn.glitch.global/26fc264b-db73-4a01-833f-fd533c30491d/Dragon.png?v=1670972431596";

		} else if (type.contains("elemental")) {
			this.imageString = "https://cdn.glitch.global/26fc264b-db73-4a01-833f-fd533c30491d/Elemental.png?v=1670972435100";

		} else if (type.contains("fey")) {
			this.imageString = "https://cdn.glitch.global/26fc264b-db73-4a01-833f-fd533c30491d/Fey.png?v=1670972440913";

		} else if (type.contains("fiend")) {
			this.imageString = "https://cdn.glitch.global/26fc264b-db73-4a01-833f-fd533c30491d/Fiend.png?v=1670972445221";

		} else if (type.contains("giant")) {
			this.imageString = "https://cdn.glitch.global/26fc264b-db73-4a01-833f-fd533c30491d/Giant.png?v=1670972448925";

		} else if (type.contains("monstrosit")) {
			this.imageString = "https://cdn.glitch.global/26fc264b-db73-4a01-833f-fd533c30491d/Monstrosity.png?v=1670972456569";

		} else if (type.contains("ooze")) {
			this.imageString = "https://cdn.glitch.global/26fc264b-db73-4a01-833f-fd533c30491d/Ooze.png?v=1670972459476";

		} else if (type.contains("plant")) {
			this.imageString = "https://cdn.glitch.global/26fc264b-db73-4a01-833f-fd533c30491d/Plant.png?v=1670972462194";

		} else if (type.contains("undead")) {
			this.imageString = "https://cdn.glitch.global/26fc264b-db73-4a01-833f-fd533c30491d/Undead.png?v=1670972466313";

		} else {
			this.imageString = ("https://cdn.glitch.global/26fc264b-db73-4a01-833f-fd533c30491d/Humanoid.png?v=1670972451657");
		}
	}

	/*
	 * public Image convertImage() throws IOException { // InputStream stream = new
	 * FileInputStream(imageString); URL url = new URL(this.imageString);
	 * BufferedImage c = ImageIO.read(url); ImageIcon image = new ImageIcon(c);
	 * 
	 * return c; }
	 */

	public String combineSizeType() {
		if (this.size == null) {
			return "Please try another Monster, as it seems this link does not work";
		} else {

			return (this.size + " " + this.type + ", " + this.alignment);
		}
	}

	public void setAlignment(URL c) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		Scanner scanner = new Scanner(c.openStream());

		try {

			Gson gson = new Gson();

			String rawData = scanner.nextLine();

			AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);

			this.alignment = (monster.results[0].alignment);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setCharisma(URL c) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		Scanner scanner = new Scanner(c.openStream());

		try {

			Gson gson = new Gson();

			String rawData = scanner.nextLine();

			AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);

			this.charisma = (monster.results[0].charisma);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCharisma() {
		if (this.charisma == null) {
			return "- -";
		} else {

			return this.charisma;
		}
	}

	public void setConstitution(URL c) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		Scanner scanner = new Scanner(c.openStream());

		try {

			Gson gson = new Gson();

			String rawData = scanner.nextLine();

			AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);

			this.constitution = (monster.results[0].constitution);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getConstitution() {
		if (this.constitution == null) {
			return "- -";
		} else {

			return this.constitution;
		}
	}

	public void setDexterity(URL c) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		Scanner scanner = new Scanner(c.openStream());

		try {

			Gson gson = new Gson();

			String rawData = scanner.nextLine();

			AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);

			this.dexterity = (monster.results[0].dexterity);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getDexterity() {
		if (this.dexterity == null) {
			return "- -";
		} else {

			return this.dexterity;
		}
	}

	public void setIntelligence(URL c) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		Scanner scanner = new Scanner(c.openStream());

		try {

			Gson gson = new Gson();

			String rawData = scanner.nextLine();

			AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);

			this.intelligents = (monster.results[0].intelligence);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getIntelligents() {
		if (this.intelligents == null) {
			return "- -";
		} else {

			return this.intelligents;
		}
	}

	public void setName(URL c) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		Scanner scanner = new Scanner(c.openStream());

		try {

			Gson gson = new Gson();

			String rawData = scanner.nextLine();
			System.out.println(rawData);

			AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);

			this.name = (monster.results[0].name);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		if (this.name == null) {
			return "Link Broken";
		} else {

			return this.name;
		}
	}

	public void setSize(URL c) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		Scanner scanner = new Scanner(c.openStream());

		try {

			Gson gson = new Gson();

			String rawData = scanner.nextLine();

			AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);

			this.size = (monster.results[0].size);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setStrength(URL c) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		Scanner scanner = new Scanner(c.openStream());

		try {

			Gson gson = new Gson();

			String rawData = scanner.nextLine();

			AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);

			this.strength = (monster.results[0].strength);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getStrength() {
		if (this.strength == null) {
			return "- -";
		} else {

			return this.strength;
		}
	}

	public void setType(URL c) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		Scanner scanner = new Scanner(c.openStream());

		try {

			Gson gson = new Gson();

			String rawData = scanner.nextLine();

			AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);

			this.type = (monster.results[0].type);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setWisdom(URL c) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		Scanner scanner = new Scanner(c.openStream());

		try {

			Gson gson = new Gson();

			String rawData = scanner.nextLine();

			AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);

			this.wisdom = (monster.results[0].wisdom);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getWisdom() {
		if (this.wisdom == null) {
			return "- -";
		} else {

			return this.wisdom;
		}
	}

	public void setArmorClass(URL c) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		Scanner scanner = new Scanner(c.openStream());

		try {

			Gson gson = new Gson();

			String rawData = scanner.nextLine();

			AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);

			this.armor = (monster.results[0].armor_class);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getArmor() {
		if (this.armor == null) {
			return "- -";
		} else {

			return this.armor;
		}

	}

	public void setHitPoints(URL c) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		Scanner scanner = new Scanner(c.openStream());

		try {

			Gson gson = new Gson();

			String rawData = scanner.nextLine();

			AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);

			this.hitPoints = (monster.results[0].hit_points);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getHitPoints() {
		if (this.hitPoints == null) {
			return "- -";
		} else {

			return this.hitPoints;
		}
	}

	// hitPoints, hitDice, damRest, damImm;
	public void setArmorDesc(URL c) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		Scanner scanner = new Scanner(c.openStream());

		try {

			Gson gson = new Gson();

			String rawData = scanner.nextLine();

			AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);

			this.armorDesc = (monster.results[0].armor_desc);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getArmorDesc() {
		if (this.armorDesc == null) {
			return "- -";
		} else {

			return this.armorDesc;
		}
	}

	public void setHitDice(URL c) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) c.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		Scanner scanner = new Scanner(c.openStream());

		try {

			Gson gson = new Gson();

			String rawData = scanner.nextLine();

			AllMonsters monster = gson.fromJson(rawData, AllMonsters.class);

			this.hitDice = (monster.results[0].hit_dice);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

public String getHitDice() {
		if (this.hitDice == null) {
			return "- -";
		} else {

			return this.hitDice;
		}
	}


	public void createReadFile() throws IOException{

		try {
			File myObj = new File("SavedMonster.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("Collecting data");
				Path filePath = Path.of("SavedMonster.txt");

				this.saved = Files.readString(filePath);
				System.out.println(saved);


					FileWriter myWriter = new FileWriter("SavedMonster.txt");
					myWriter.write(saved);
					myWriter.close();
					
					String[] arrOfSaved = saved.split("@");
					this.strength = arrOfSaved[0];
					this.dexterity = arrOfSaved[1];
					this.constitution = arrOfSaved[2];
					this.intelligents = arrOfSaved[3];
					this.wisdom = arrOfSaved[4];
					this.charisma = arrOfSaved[5];
					this.name = arrOfSaved[6];
					this.size = arrOfSaved[7];
					this.type = arrOfSaved[8];
					this.alignment = arrOfSaved[9];
					this.armor = arrOfSaved[10];
					this.armorDesc = arrOfSaved[11];
					this.hitPoints = arrOfSaved[12];
					this.hitDice = arrOfSaved[13];

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void getLastMonster() throws IOException {
		if (name != null) {
			this.saved = strength + "@" + dexterity + "@" + constitution + "@" + intelligents + "@" + wisdom + "@"
					+ charisma + "@" + name + "@" + size + "@" + type + "@" + alignment + "@" + armor + "@" + armorDesc
					+ "@" + hitPoints + "@" + hitDice;
			FileWriter myWriter = new FileWriter("SavedMonster.txt");
			myWriter.write(saved);
			myWriter.close();
			
			System.out.println(saved);
		} else {
			System.out.println("Error Occured during load: Data Not Saved");
		}
	}

}
