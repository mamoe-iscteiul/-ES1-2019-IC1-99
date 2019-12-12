package gui;

import java.io.File;
import java.io.IOException;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import aplicacao.Metodo;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	Stage stage;
	
	
	@FXML
	MenuItem importButton;

	@FXML
	TableView<Metodo> table;

	@FXML
	TableColumn<Metodo, Integer> method_id;

	@FXML
	TableColumn<Metodo, String> package_name;
	@FXML
	TableColumn<Metodo, String> class_name;
	@FXML
	TableColumn<Metodo, String> method_name;
	@FXML
	TableColumn<Metodo, Integer> loc;
	@FXML
	TableColumn<Metodo, Integer> cyclo;
	@FXML
	TableColumn<Metodo, Integer> atfd;
	@FXML
	TableColumn<Metodo, Double> laa;
	@FXML
	TableColumn<Metodo, Boolean> is_long_method;
	@FXML
	TableColumn<Metodo, Boolean> iplasma;
	@FXML
	TableColumn<Metodo, Boolean> pmd;
	@FXML
	TableColumn<Metodo, Boolean> is_feature_envy;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
			Scene scene = new Scene(root, 900, 500);
			primaryStage.setScene(scene);
			stage = primaryStage;
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}


}
