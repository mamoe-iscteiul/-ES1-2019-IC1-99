
module projetoFinalES {
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires poi;
	requires javafx.base;
//	requires org.junit.jupiter.api;
//	requires junit;
	exports gui;
	opens gui;
	exports classes_auxiliares;
	opens classes_auxiliares;
}