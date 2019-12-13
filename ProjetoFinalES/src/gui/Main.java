package gui;



import classes_auxiliares.Metodo;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class Main extends Application {
	
	GUI controller;
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("gui.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root, 1200, 500);
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
