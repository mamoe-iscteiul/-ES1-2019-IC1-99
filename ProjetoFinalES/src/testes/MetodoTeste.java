package testes;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.JUnit4;

import classes_auxiliares.Metodo;

class MetodoTeste {

	Metodo metodo;
	@BeforeEach
	void setUp() throws Exception {
		metodo = new Metodo();
		metodo.setMethod_id(1);
		metodo.setClass_name("teste");
		metodo.setPackage_name("teste");
		metodo.setName("teste");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testToString() {
		assertTrue(metodo.toString().contains("Method id: 1 | Package: teste | Class: teste | Method: teste"));
	}

}
