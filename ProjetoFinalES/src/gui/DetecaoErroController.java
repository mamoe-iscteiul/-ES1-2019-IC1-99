package gui;

import java.util.ArrayList;
import java.util.List;

import aplicacao.Metodo;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DetecaoErroController {

	@FXML
	TableView<Metodo> tabela_long;
	@FXML
	TableColumn<Metodo,Integer> method_id_column;
	@FXML
	TableColumn<Metodo, Boolean> is_long_column;
	
	@FXML
	TableColumn<Metodo, Boolean> is_envy_column;
	
	private List<Metodo> isFeature = new ArrayList<Metodo>();
	private List<Metodo> noFeature = new ArrayList<Metodo>();
	private List<Metodo> metodos_long = new ArrayList<Metodo>();
	private List<Metodo> metodos_non_long = new ArrayList<Metodo>();
	private List<Metodo> metodos_DCI = new ArrayList<Metodo>();
	private List<Metodo> metodos_DII = new ArrayList<Metodo>();
	private List<Metodo> metodos_ADCI = new ArrayList<Metodo>();
	private List<Metodo> metodos_ADII = new ArrayList<Metodo>();
	private List<Metodo> metodos_todos = new ArrayList<Metodo>();
	
	private int loc_regra_atual;
	

	private int cyclo_regra_atual;
	private int atfd_regra_atual;
	private double laa_regra_atual;
	
	public void initialize() {
		for(Metodo m : metodos_todos)
			System.out.println("nome: " +m.getName());
		System.out.println("Regra loc: " + loc_regra_atual + " e regra cyclo: " + cyclo_regra_atual);
		isLongMethod(loc_regra_atual, cyclo_regra_atual);
		is_long_column.setCellValueFactory(c ->{
			Metodo metodo = c.getValue();
		      CheckBox checkBox = new CheckBox();
		      checkBox.selectedProperty().setValue(metodo.isIs_long_method());
		      return new SimpleObjectProperty(checkBox);
		});
		ObservableList<Metodo> metodosLong = FXCollections.observableArrayList(metodos_long);
		ObservableList<Metodo> metodosEnvy = FXCollections.observableArrayList(isFeature);
		method_id_column.setCellValueFactory(new PropertyValueFactory<>("method_id"));
		is_long_column.setCellValueFactory(new PropertyValueFactory<>("is_long_method"));
		tabela_long.setItems(metodosLong);
		
	}
	
	public void is_feature_envy() {
		for (int i = 0; i < metodos_todos.size(); i++) {
			if (metodos_todos.get(i).getAtfd() > atfd_regra_atual && metodos_todos.get(i).getLaa() < laa_regra_atual) {
				isFeature.add(metodos_todos.get(i));
			}
			noFeature.add(metodos_todos.get(i));
		}
	}

	public void isLongMethod(int LOC, int CYCLO) {
		for (int i = 0; i < metodos_todos.size(); i++) {
			if (metodos_todos.get(i).getLoc() > LOC && metodos_todos.get(i).getCyclo() > CYCLO) {
				metodos_long.add(metodos_todos.get(i));
			}else {
				metodos_non_long.add(metodos_todos.get(i));
			}
		}
	}

	public void compararIplasma() {
		for (int i = 0; i < metodos_long.size(); i++) {
			if (metodos_long.get(i).isPlasma() == true) {
				metodos_DCI.add(metodos_long.get(i));
			} else
				metodos_ADII.add(metodos_long.get(i));
		}
		for (int i = 0; i < metodos_non_long.size(); i++) {
			if (metodos_non_long.get(i).isPlasma() == true) {
				metodos_DII.add(metodos_non_long.get(i));
			} else
				metodos_ADCI.add(metodos_non_long.get(i));
		}
	}
	
	public void guardarListasDeMetodos(List<Metodo> lista) {
		metodos_todos = lista;
		
	}
	public int getLoc_regra_atual() {
		return loc_regra_atual;
	}

	public void setLoc_regra_atual(int loc_regra_atual) {
		this.loc_regra_atual = loc_regra_atual;
	}

	public double getLaa_regra_atual() {
		return laa_regra_atual;
	}

	public void setLaa_regra_atual(double laa_regra_atual) {
		this.laa_regra_atual = laa_regra_atual;
	}
	public void guardarRegras(int r1, int r2, int r3, double r4) {
		setLoc_regra_atual(r1);
		setLaa_regra_atual(r2);
		this.atfd_regra_atual = r3;
		this.laa_regra_atual = r4;
	}
}
