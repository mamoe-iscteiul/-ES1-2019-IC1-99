package gui;

import java.io.File;
import java.io.IOException;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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
import metodo.Metodo;

public class Main extends Application {
	@FXML
	MenuItem importButton;

	Stage stage;
	List<Metodo> metodos = new ArrayList<Metodo>();
	DataFormatter df = new DataFormatter();

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

	public void initialize() {

	}

	public void buttonImport() throws IOException {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File(System.getProperty("user.dir")));
		FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("exceldoc", "*.xlsx");
		fc.getExtensionFilters().add(extensionFilter);
		File selectedFile = fc.showOpenDialog(stage);
		Workbook workbook = WorkbookFactory.create(selectedFile);
		Sheet sheet = workbook.getSheetAt(0);
		for(Row row : sheet) {
			Metodo metodo = new Metodo();
			List<Object> atributos = new ArrayList<>();
			if(row.equals(sheet.getRow(0)))
				continue;
			for(Cell cell : row) {
				String cellValue = df.formatCellValue(cell);
				atributos.add(cellValue);
			}
			metodo.setAtributos(atributos);
			metodos.add(metodo);
		}

		ObservableList<Metodo> list = FXCollections.observableArrayList(metodos);
		method_id.setCellValueFactory(new PropertyValueFactory<>("method_id"));
		package_name.setCellValueFactory(new PropertyValueFactory<>("package_name"));
		class_name.setCellValueFactory(new PropertyValueFactory<>("class_name"));
		method_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		loc.setCellValueFactory(new PropertyValueFactory<>("loc"));
		cyclo.setCellValueFactory(new PropertyValueFactory<>("cyclo"));
		atfd.setCellValueFactory(new PropertyValueFactory<>("atfd"));
		laa.setCellValueFactory(new PropertyValueFactory<>("laa"));
		is_long_method.setCellValueFactory(new PropertyValueFactory<>("is_long_method"));
		iplasma.setCellValueFactory(new PropertyValueFactory<>("plasma"));
		pmd.setCellValueFactory(new PropertyValueFactory<>("pmd"));
		is_feature_envy.setCellValueFactory(new PropertyValueFactory<>("is_feature_envy"));
		table.setItems(list);
		
		
	}
}
