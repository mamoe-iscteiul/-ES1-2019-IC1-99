package gui;


	
import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Main extends Application {
	@FXML
	MenuItem importButton;
	
	Stage stage;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
			Scene scene = new Scene(root,900,500);
			primaryStage.setScene(scene);
			stage = primaryStage;
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

	public void initialize() {
		
	}
	public void buttonImport() {
	        FileChooser fc = new FileChooser();
	        fc.setInitialDirectory(new File(System.getProperty("user.dir"))));
	        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("exceldoc" ,"*.xlsx");
	        fc.getExtensionFilters().add(extensionFilter);
	        File selectedFile = fc.showOpenDialog(stage);
	       
		
	}
}
