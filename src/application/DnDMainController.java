package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class MonController {
	@FXML
	private Label action;

	@FXML
	private HBox actionBox;

	@FXML
	private Label actionDescrip;

	@FXML
	private Label armor;

	@FXML
	private Button button;

	@FXML
	private Label challenge;

	@FXML
	private Label charisma;

	@FXML
	private Label constitution;

	@FXML
	private Label dexterity;

	@FXML
	private Label hitPoints;

	@FXML
	private Label intelligents;

	@FXML
	private Label languages;

	@FXML
	private Label legend;

	@FXML
	private HBox legendBox;

	@FXML
	private Label legendDescrip;

	@FXML
	private Label name;

	@FXML
	private Label senses;

	@FXML
	private Label sizeTypeAli;

	@FXML
	private Label skills;

	@FXML
	private Label special;

	@FXML
	private HBox specialBox;

	@FXML
	private Label specialDescrip;

	@FXML
	private Label speed;

	@FXML
	private Label strength;

	@FXML
	private ImageView typeImage;

	@FXML
	private Label wisdom;

	@FXML
	void buttonPressed(ActionEvent event) throws IOException {
		MonsterMethods info = new MonsterMethods();

		// Set stats
		strength.setText(info.getStrength());
		dexterity.setText(info.getDexterity());
		constitution.setText(info.getConstitution());
		intelligents.setText(info.getIntelligents());
		wisdom.setText(info.getWisdom());
		charisma.setText(info.getCharisma());

		// set name info
		//info.setImageString("fey");
		//typeImage.setImage(info.convertImage());
		//typeImage.setImage(new Image("file:Humanoid.png"));// change to new image
		name.setText(info.monsSlug()); // Change to name 
		sizeTypeAli.setText(info.combineSizeTypeAli());

		// set "scroll pane"
		armor.setText(info.getArmor());
		hitPoints.setText(info.getHitPoints());
		speed.setText(info.getSpeed());
		skills.setText(info.getSkills());

		senses.setText(info.getSenses());
		languages.setText(info.getLanguages());
		challenge.setText(info.getChallenge());
	}
	
	protected void createHBox(int count, HBox exsitingH){
		ArrayList<HBox> boxes = new ArrayList<HBox>();
		
		for(int i = 0; i < count; i++) {
			//HBox hB = new HBox();
			boxes.add(exsitingH);
		}
		
		
		
	}

}
