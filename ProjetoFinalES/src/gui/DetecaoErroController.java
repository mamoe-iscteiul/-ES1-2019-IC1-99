package gui;

import java.util.List;

import aplicacao.Metodo;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;

public class DetecaoErroController {

	@FXML
	TableColumn<Metodo, Boolean> is_long_column;
	
	@FXML
	TableColumn<Metodo, Boolean> is_envy_column;
	
	private List<Metodo> metodos;
	
	public void initialize() {
		is_long_column.setCellValueFactory(c ->{
			Metodo metodo = c.getValue();
		      CheckBox checkBox = new CheckBox();
		      checkBox.selectedProperty().setValue(metodo.is_long_method());
		      return new SimpleObjectProperty(checkBox);
		});
	}
}
