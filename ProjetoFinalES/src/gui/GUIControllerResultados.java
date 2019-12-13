package gui;

import java.util.ArrayList;
import java.util.List;

import classes_auxiliares.Metodo;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class GUIControllerResultados {
	@FXML
	TableView<Metodo> tabela_metodos_longos;
	@FXML
	TableView<Metodo> tabela_metodos_curto;
	@FXML
	TableColumn<Metodo, Integer> method_id_long;
	@FXML
	TableColumn<Metodo, String> method_name_long;
	@FXML
	TableColumn<Metodo, Integer> method_id_short;
	@FXML
	TableColumn<Metodo, String> method_name_short;
	@FXML
	TableColumn<Metodo, String> pmd;
	@FXML
	TableColumn<Metodo, String> iplasma;
	@FXML
	TableColumn<Metodo, String> pmd_curto;
	@FXML
	TableColumn<Metodo, String> iplasma_curto;

	@FXML
	TextField pmd_dci_tf;
	@FXML
	TextField pmd_dii_tf;
	@FXML
	TextField pmd_adci_tf;
	@FXML
	TextField pmd_adii_tf;
	@FXML
	TextField plasma_dci_tf;
	@FXML
	TextField plasma_dii_tf;
	@FXML
	TextField plasma_adci_tf;
	@FXML
	TextField plasma_adii_tf;

	private List<Metodo> metodos_analisados_is_long = new ArrayList<Metodo>();
	private List<Metodo> metodos_analisados_is_short = new ArrayList<Metodo>();
	private int pmd_dci;
	private int pmd_dii;
	private int pmd_adci;
	private int pmd_adii;
	private int plasma_dci;
	private int plasma_dii;
	private int plasma_adci;
	private int plasma_adii;

	public void initialize(List<Metodo> lista) {

		analisarMetodos(lista);
		pmd_dci_tf.setText(String.valueOf((pmd_dci)));
		pmd_dii_tf.setText(String.valueOf((pmd_dii)));
		pmd_adci_tf.setText(String.valueOf((pmd_adci)));
		pmd_adii_tf.setText(String.valueOf((pmd_adii)));
		plasma_dci_tf.setText(String.valueOf((plasma_dci)));
		plasma_dii_tf.setText(String.valueOf((plasma_dii)));
		plasma_adci_tf.setText(String.valueOf((plasma_adci)));
		plasma_adii_tf.setText(String.valueOf((plasma_adii)));

	}

	private void setupTabelas() {
		ObservableList<Metodo> metodosAnalisadosLongos = FXCollections.observableArrayList(metodos_analisados_is_long);
		ObservableList<Metodo> metodosAnalisadosCurtos = FXCollections.observableArrayList(metodos_analisados_is_short);
		method_id_long.setCellValueFactory(new PropertyValueFactory<>("method_id"));
		method_name_long.setCellValueFactory(new PropertyValueFactory<>("name"));
		method_id_short.setCellValueFactory(new PropertyValueFactory<>("method_id"));
		method_name_short.setCellValueFactory(new PropertyValueFactory<>("name"));
		pmd.setCellValueFactory(c -> {
			Metodo metodo = c.getValue();
			CheckBox checkBox = new CheckBox();
			checkBox.selectedProperty().setValue(metodo.isPmd());
			checkBox.setDisable(true);

			return new SimpleObjectProperty(checkBox);
		});
		iplasma.setCellValueFactory(c -> {
			Metodo metodo = c.getValue();
			CheckBox checkBox = new CheckBox();
			checkBox.selectedProperty().setValue(metodo.isPlasma());
			checkBox.setDisable(true);

			return new SimpleObjectProperty(checkBox);
		});
		pmd_curto.setCellValueFactory(c -> {
			Metodo metodo = c.getValue();
			CheckBox checkBox = new CheckBox();
			checkBox.selectedProperty().setValue(metodo.isPmd());
			checkBox.setDisable(true);

			return new SimpleObjectProperty(checkBox);
		});
		iplasma_curto.setCellValueFactory(c -> {
			Metodo metodo = c.getValue();
			CheckBox checkBox = new CheckBox();
			checkBox.selectedProperty().setValue(metodo.isPlasma());
			checkBox.setDisable(true);

			return new SimpleObjectProperty(checkBox);
		});
		pmd.setStyle("-fx-alignment: CENTER;");
		iplasma.setStyle("-fx-alignment: CENTER;");
		pmd_curto.setStyle("-fx-alignment: CENTER;");
		iplasma_curto.setStyle("-fx-alignment: CENTER;");
		tabela_metodos_curto.setItems(metodosAnalisadosCurtos);
		tabela_metodos_longos.setItems(metodosAnalisadosLongos);
	}
	
	
	private void analisarMetodos(List<Metodo> metodos) {
		for (Metodo m : metodos) {
			if (m.isIs_long_method() == true) {
				metodos_analisados_is_long.add(m);
				if (m.isPlasma() == true) {
					plasma_dci -= -1;
				} else
					plasma_dii -= -1;
				if (m.isPmd() == true) {
					pmd_dci -= -1;
				} else
					pmd_dii -= -1;
			} else {
				metodos_analisados_is_short.add(m);
				if (!m.isPlasma() == false)
					plasma_adci -= -1;
				else
					plasma_adii -= -1;
				if (!m.isPmd() == false)
					pmd_adci -= -1;
				else
					pmd_adii -= -1;
			}
		}
	}

}
