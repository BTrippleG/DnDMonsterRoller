package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class DnDMainController {

	@FXML
	private Button button;

	@FXML
	private Label charisma;

	@FXML
	private Label constitution;

	@FXML
	private Label dexterity;

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
		// typeImage.setImage(new Image("Beast.png"));
		name.setText(info.monsSlug());
		sizeTypeAli.setText(info.combineSizeTypeAli());

		// set "scroll pane"

	}

}
