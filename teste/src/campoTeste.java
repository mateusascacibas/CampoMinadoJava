package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Campo;

class campoTeste {
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3,3);
	}
	
	@Test
	void testeVizinhoReal() {
			Campo vizinho = new Campo(3,2);
			boolean resultado = campo.adicionarVizinho(vizinho);
			assertTrue(resultado);
	}

}
