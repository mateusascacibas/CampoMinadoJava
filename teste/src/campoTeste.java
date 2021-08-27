package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excecao.ExplosaoException;
import modelo.Campo;

class campoTeste {
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3,3);
	}
	
	@Test
	void testeVizinhoDiagonal() {
			Campo vizinho = new Campo(2,2);
			boolean resultado = campo.adicionarVizinho(vizinho);
			assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoEsquerda() {
		Campo vizinho = new Campo(2,3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDireita() {
		Campo vizinho = new Campo(3,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeValorPadraoAtribuidoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	
	@Test
	void testeAlternaMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternaMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}
	
	@Test
	void testeAbrirComVizinhos1() {
		Campo vizinho1 = new Campo(2,2);

		Campo vizinhoDoVizinho1 = new Campo(1,1);

		campo.adicionarVizinho(vizinho1);
		vizinho1.adicionarVizinho(vizinhoDoVizinho1);
		campo.abrir();
		assertTrue(vizinhoDoVizinho1.isAberto() && vizinho1.isAberto());
	}
	@Test
	void testeAbrirComVizinhos2() {
		Campo campo22 = new Campo(2,2);
		Campo campo12 = new Campo(1,2);
		campo12.minar();
		Campo campo11 = new Campo(1,1);

		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		campo.adicionarVizinho(campo22);
		campo.abrir();
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}


}
