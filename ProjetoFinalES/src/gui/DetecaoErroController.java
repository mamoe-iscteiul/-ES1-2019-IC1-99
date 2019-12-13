package gui;

import java.util.ArrayList;
import java.util.List;

import aplicacao.Metodo;
import aplicacao.MetodoAnalisado;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DetecaoErroController {

	@FXML
	TableView<MetodoAnalisado> tabela_metodos_sem_defeito;
	@FXML
	TableView<MetodoAnalisado> tabela_metodos_analisados;
	
	@FXML
	TableColumn<MetodoAnalisado, Integer> column_method_id;
	
	@FXML
	TableColumn<MetodoAnalisado, String> column_name;
	
	@FXML
	TableColumn<MetodoAnalisado, Integer> method_id_column;
	@FXML
	TableColumn<MetodoAnalisado, Boolean> is_long_column;

	@FXML
	TableColumn<MetodoAnalisado, Boolean> is_envy_column;

	private List<MetodoAnalisado> metodos_analisados_com_defeito = new ArrayList<MetodoAnalisado>();
	private List<MetodoAnalisado> metodos_analisados_sem_defeito = new ArrayList<MetodoAnalisado>();
	
	private List<Metodo> metodos_todos = new ArrayList<Metodo>();

	private int loc_regra_atual;

	private int cyclo_regra_atual;
	private int atfd_regra_atual;
	private double laa_regra_atual;

	public void initialize(List<Metodo> lista, int regra_loc, int regra_cyclo, int regra_atfd, double regra_laa) {
		this.metodos_todos = lista;
		this.loc_regra_atual = regra_loc;
		this.cyclo_regra_atual = regra_cyclo;
		this.atfd_regra_atual = regra_atfd;
		this.laa_regra_atual = regra_laa;
		analisarMetodos(metodos_todos);
		ObservableList<MetodoAnalisado> metodosAnalisadosComDefeito = FXCollections.observableArrayList(metodos_analisados_com_defeito);
		ObservableList<MetodoAnalisado> metodosAnalisadosSemDefeito = FXCollections.observableArrayList(metodos_analisados_sem_defeito);
		method_id_column.setCellValueFactory(new PropertyValueFactory<>("method_id"));
		is_long_column.setCellValueFactory(new PropertyValueFactory<>("is_long_method"));
		is_envy_column.setCellValueFactory(new PropertyValueFactory<>("is_feature_envy"));
		is_long_column.setCellValueFactory(c -> {
			MetodoAnalisado metodo = c.getValue();
			CheckBox checkBox = new CheckBox();
			checkBox.selectedProperty().setValue(metodo.isIs_long_method());
			checkBox.setDisable(true);

			return new SimpleObjectProperty(checkBox);
		});
		is_envy_column.setCellValueFactory(c -> {
			MetodoAnalisado metodo = c.getValue();
			CheckBox checkBox = new CheckBox();
			checkBox.selectedProperty().setValue(metodo.isIs_feature_envy());
			checkBox.setDisable(true);

			return new SimpleObjectProperty(checkBox);
		});
		is_long_column.setStyle("-fx-alignment: CENTER;");
		is_envy_column.setStyle("-fx-alignment: CENTER;");
		tabela_metodos_analisados.setItems(metodosAnalisadosComDefeito);
		column_method_id.setCellValueFactory(new PropertyValueFactory<>("method_id"));
		column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		tabela_metodos_sem_defeito.setItems(metodosAnalisadosSemDefeito);
		

	}

	private void analisarMetodos(List<Metodo> metodos) {
		List<MetodoAnalisado> metodos_analisados = new ArrayList<MetodoAnalisado>();
		for (Metodo m : metodos) {
			MetodoAnalisado metodo_analisado = new MetodoAnalisado();
			metodo_analisado.setName(m.getName());
			metodo_analisado.setMethod_id(m.getMethod_id());
			if (m.getLoc() > loc_regra_atual && m.getCyclo() > cyclo_regra_atual) {
				metodo_analisado.setIs_long_method(true);
			} else
				metodo_analisado.setIs_long_method(false);
			if (m.getAtfd() > atfd_regra_atual && m.getLaa() < laa_regra_atual) {
				metodo_analisado.setIs_feature_envy(true);
			} else
				metodo_analisado.setIs_feature_envy(false);
			metodos_analisados.add(metodo_analisado);
		}
		separarMetodosAnalisados(metodos_analisados);

	}
	private void separarMetodosAnalisados(List<MetodoAnalisado> lista) {
		for(MetodoAnalisado m : lista) {
			if(m.isIs_long_method()==true || m.isIs_feature_envy()==true) {
				metodos_analisados_com_defeito.add(m);
			}else
				metodos_analisados_sem_defeito.add(m);
		}
	}

	

	

//	public void compararIplasma() {
//		for (int i = 0; i < metodos_long.size(); i++) {
//			if (metodos_long.get(i).isPlasma() == true) {
//				metodos_DCI.add(metodos_long.get(i));
//			} else
//				metodos_ADII.add(metodos_long.get(i));
//		}
//		for (int i = 0; i < metodos_non_long.size(); i++) {
//			if (metodos_non_long.get(i).isPlasma() == true) {
//				metodos_DII.add(metodos_non_long.get(i));
//			} else
//				metodos_ADCI.add(metodos_non_long.get(i));
//		}
//	}

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
