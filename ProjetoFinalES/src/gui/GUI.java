package gui;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;

public class GUI {

	@FXML
	MenuItem importButton;
	
	@FXML
	TableView table;

	public void initialize() {
		
	}
	public void buttonImport() throws IOException {
	        FileChooser fc = new FileChooser();
	        fc.setInitialDirectory(new File("Long-Method.xlsx"));
	        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("exceldoc" ,"*.xlsx");
	        fc.getExtensionFilters().add(extensionFilter);
	        File selectedFile = fc.showOpenDialog(importButton.getGraphic().getScene().getWindow()); 
	        table.setUserData(selectedFile);
	       
		
	}
}
