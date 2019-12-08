package gui;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

public class GUI {

	@FXML
	MenuItem importButton;

	public void initialize() {
		
	}
	public void buttonImport() {
	        FileChooser fc = new FileChooser();
	        fc.setInitialDirectory(new File("C:\\Users\\257ma\\Documents"));
	        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("exceldoc" ,"*.xlsx");
	        fc.getExtensionFilters().add(extensionFilter);
	        File selectedFile = fc.showOpenDialog(importButton.getGraphic().getScene().getWindow());  //window dá null, arranjar maneira de usar a scene principal
	       
		
	}
}
