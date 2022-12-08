package theSTuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

import javax.swing.ImageIcon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MonsterMethods {
	public String strength, dexterity, constitution, intelligents, wisdom, charisma;
	public String name, size, type, alignment;
	public String skill, armor, hitPoints, speed, senses, languages, challenge;
	public String imageString;
	public String searchUrl = ("https://api.open5e.com/monsters/?format=json&search=");
	public Random random = new Random();
	public String slug;

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

	public int randomNum(int numCount) {
		// can delete if dice are unneeded

		int randomNum = random.nextInt(numCount + 1);

		return randomNum;
	}

	public String monsSlug() throws IOException {

		int r = random.nextInt(1470);

		try (BufferedReader br = new BufferedReader(new FileReader("MonsterList"))) {
			for (int i = 0; i < r; i++)
				br.readLine();
			slug = br.readLine();

		} catch (IOException e) {
			System.out.println(e);
		}
		return slug;
	}

	public void jsonParse() throws FileNotFoundException, IOException, ParseException {
		Object obj = new JSONParser().parse(new FileReader("\\Camden Stuff\\theSTuff\\Monsters.json"));
		JSONObject jsonObject = (JSONObject) obj;

		JSONArray results = (JSONArray) jsonObject.get("results");
		System.out.println(results);

	}

	public void setImageString(String type) {
		// change to this.imageString
		type = type.toLowerCase();

		if (type.contains("humanoid")) {
			this.imageString = "Humanoid.png";

		} else if (type.contains("aberration")) {
			this.imageString = "Aberration.png";

		} else if (type.contains("beast")) {
			this.imageString = "Beast.png";

		} else if (type.contains("celestial")) {
			this.imageString = "Celestial.png";

		} else if (type.contains("construct")) {
			this.imageString = "Construct.png";

		} else if (type.contains("dragon")) {
			this.imageString = "Dragon.png";

		} else if (type.contains("elemental")) {
			this.imageString = "Elemental.png";

		} else if (type.contains("fey")) {
			this.imageString = "Fey.png";

		} else if (type.contains("fiend")) {
			this.imageString = "Fiend.png";

		} else if (type.contains("giant")) {
			this.imageString = "Giant.png";

		} else if (type.contains("monstrosit")) {
			this.imageString = "monstrosity.png";

		} else if (type.contains("ooze")) {
			this.imageString = "Ooze.png";

		} else if (type.contains("plant")) {
			this.imageString = "Plant.png";

		} else if (type.contains("undead")) {
			this.imageString = "Undead.png";

		} else {
			this.imageString = ("Humanoid.png");
		}
	}

	public Image convertImage() throws FileNotFoundException {		
		//InputStream stream = new FileInputStream(imageString);
		Image image = new Image("file:Humanoid.png");

		return image;
	}

	public String combineSizeTypeAli() {
		size = "this is size";
		type = "this is type";
		alignment = "this is alignment";// THESE ARE FOR TESTING DELETE!!!

		return (size + " " + type + ", " + alignment);
	}

	public String combineSkills() {
		// Not sure what we will choose to sort by yet

		skill = "testing skills: 9+ \n 2skill -1";
		return skill;
	}

	public String getAlignment() {
		return alignment;
	}

	public String getCharisma() {
		return charisma;
	}

	public String getConstitution() {
		return constitution;
	}

	public String getDexterity() {
		return dexterity;
	}

	public String getIntelligents() {
		return intelligents;
	}

	public String getName() {
		return name;
	}

	public String getSize() {
		return size;
	}

	public String getStrength() {
		return strength;
	}

	public String getType() {
		return type;
	}

	/*
	 * public String getTypeImage() { return null; }
	 */

	public String getWisdom() {
		return wisdom;
	}

	public String getArmor() {
		return armor;
	}

	public String getHitPoints() {
		return hitPoints;
	}

	public String getSpeed() {
		return speed;
	}

	public String getSkills() {
		return skill;
	}

	public String getSenses() {
		return senses;

	}

	public String getLanguages() {
		return languages;

	}

	public String getChallenge() {
		return challenge;

	}

}
