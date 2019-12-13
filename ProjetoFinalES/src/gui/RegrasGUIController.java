package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegrasGUIController {

	private int loc_regra_atual;
	private int cyclo_regra_atual;
	private int atfd_regra_atual;
	private double laa_regra_atual;
	private GUI controller;


	@FXML
	TextField textfield_loc;
	@FXML
	TextField textfield_cyclo;
	@FXML
	TextField textfield_atfd;
	@FXML
	TextField textfield_laa;
	@FXML
	Button editar_button;
	@FXML
	Button gravar_button;

	public void initialize(int regra_loc, int regra_cyclo, int regra_atfd, double regra_laa, GUI g) {
		this.loc_regra_atual = regra_loc;
		this.cyclo_regra_atual = regra_cyclo;
		this.atfd_regra_atual = regra_atfd;
		this.laa_regra_atual = regra_laa;
		this.controller = g;
		carregarRegras();
		desativarTextfields();
		gravar_button.setDisable(true);
	}

	private void carregarRegras() {
		textfield_loc.setText(String.valueOf(loc_regra_atual));
		textfield_cyclo.setText(String.valueOf(cyclo_regra_atual));
		textfield_atfd.setText(String.valueOf(atfd_regra_atual));
		textfield_laa.setText(String.valueOf(laa_regra_atual));
	}

	private void desativarTextfields() {
		textfield_loc.setDisable(true);
		textfield_cyclo.setDisable(true);
		textfield_atfd.setDisable(true);
		textfield_laa.setDisable(true);
	}

	private void ativarTextfields() {
		textfield_loc.setDisable(false);
		textfield_cyclo.setDisable(false);
		textfield_atfd.setDisable(false);
		textfield_laa.setDisable(false);
	}

	public void editarRegras() {
		ativarTextfields();
		editar_button.setDisable(true);
		gravar_button.setDisable(false);
		
	}

	public void guardarRegras() {
		try {
			Integer.parseInt(textfield_loc.getText());
			Integer.parseInt(textfield_cyclo.getText());
			Integer.parseInt(textfield_atfd.getText());
			Double.parseDouble(textfield_laa.getText());
			desativarTextfields();
			setLoc_regra_atual(Integer.parseInt(textfield_loc.getText()));
			setCyclo_regra_atual(Integer.parseInt(textfield_cyclo.getText()));
			setAtfd_regra_atual(Integer.parseInt(textfield_atfd.getText()));
			setLaa_regra_atual(Double.parseDouble(textfield_laa.getText()));
			controller.setLoc_regra_atual(loc_regra_atual);
			controller.setCyclo_regra_atual(cyclo_regra_atual);
			controller.setAtfd_regra_atual(atfd_regra_atual);
			controller.setLaa_regra_atual(laa_regra_atual);
			editar_button.setDisable(false);
			gravar_button.setDisable(true);
		}catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setHeaderText("Valores Inválidos");
			alert.setContentText("Apenas aceites inteiros ou decimais.");
			alert.showAndWait();
		}
	}

	public int getLoc_regra_atual() {
		return loc_regra_atual;
	}

	public void setLoc_regra_atual(int loc_regra_atual) {
		this.loc_regra_atual = loc_regra_atual;
	}

	public int getCyclo_regra_atual() {
		return cyclo_regra_atual;
	}

	public void setCyclo_regra_atual(int cyclo_regra_atual) {
		this.cyclo_regra_atual = cyclo_regra_atual;
	}

	public int getAtfd_regra_atual() {
		return atfd_regra_atual;
	}

	public void setAtfd_regra_atual(int atfd_regra_atual) {
		this.atfd_regra_atual = atfd_regra_atual;
	}

	public double getLaa_regra_atual() {
		return laa_regra_atual;
	}

	public void setLaa_regra_atual(double laa_regra_atual) {
		this.laa_regra_atual = laa_regra_atual;
	}
}
