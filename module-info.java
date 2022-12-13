module DnDMonster {
	requires javafx.controls;
	requires javafx.fxml;
	requires json.simple;
	requires java.json;
	requires com.google.gson;
	requires javafx.graphics;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml, com.google.gson;
}
