/**
 * 
 */
/**
 * @author 257ma
 *
 */
module projetoFinalES {
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires poi;
	requires javafx.base;
	exports gui;
	opens gui;
	exports aplicacao;
	opens aplicacao;
}