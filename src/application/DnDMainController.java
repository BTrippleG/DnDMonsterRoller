package application;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MonController {
	@FXML
	private Label armor;

	@FXML
	private Label armorDesc;

	@FXML
	private Button button;

	@FXML
	private Label charisma;

	@FXML
	private Label constitution;

	@FXML
	private Label dexterity;

	@FXML
	private Label hitDice;

	@FXML
	private Label hitPoints;

	@FXML
	private Label intelligents;

	@FXML
	private Label name;

	@FXML
	private Label sizeTypeAli;

	@FXML
	private Label strength;

	@FXML
	private ImageView typeImage;

	@FXML
	private Label wisdom;
	
		@FXML
	public void initialize() throws IOException{
		MonsterMethods info = new MonsterMethods();

		info.createReadFile();	
		
		strength.setText(info.getStrength());
		dexterity.setText(info.getDexterity());
		constitution.setText(info.getConstitution());
		intelligents.setText(info.getIntelligents());
		wisdom.setText(info.getWisdom());
		charisma.setText(info.getCharisma());
		name.setText(info.getName());
		
		armor.setText(info.getArmor());
		sizeTypeAli.setText(info.combineSizeType());
		armorDesc.setText(info.getArmorDesc());
		hitPoints.setText(info.getHitPoints());
		hitDice.setText(info.getHitDice());
	}

	@FXML
	void buttonPressed(ActionEvent event) throws IOException {
		MonsterMethods info = new MonsterMethods();
		URL monsterURL = info.toUrl();

		// setters for top
		info.setStrength(monsterURL);
		info.setName(monsterURL);
		info.setDexterity(monsterURL);
		info.setConstitution(monsterURL);
		info.setWisdom(monsterURL);
		info.setIntelligence(monsterURL);
		info.setCharisma(monsterURL);

		// Set stats
		strength.setText(info.getStrength());
		dexterity.setText(info.getDexterity());
		constitution.setText(info.getConstitution());
		intelligents.setText(info.getIntelligents());
		wisdom.setText(info.getWisdom());
		charisma.setText(info.getCharisma());
		name.setText(info.getName());

		// setters for bottom info
		info.setArmorClass(monsterURL);
		info.setSize(monsterURL);
		info.setType(monsterURL);
		info.setAlignment(monsterURL);
		info.setArmorDesc(monsterURL);
		info.setHitPoints(monsterURL);
		info.setHitDice(monsterURL);

		// set "scroll pane"
		armor.setText(info.getArmor());
		sizeTypeAli.setText(info.combineSizeType());
		armorDesc.setText(info.getArmorDesc());
		hitPoints.setText(info.getHitPoints());
		hitDice.setText(info.getHitDice());
		
		info.getLastMonster();


	}

}
