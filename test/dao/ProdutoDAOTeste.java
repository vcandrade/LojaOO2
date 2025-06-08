package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.*;

import entities.Produto;

public class ProdutoDAOTeste {

	@Disabled
	void cadastrarProdutoTeste() throws SQLException, IOException {

		Produto produto = new Produto();

		produto.setNome("Café Torrado e Moído 500g – Melitta Tradicional");
		produto.setCategoria("Alimentos");
		produto.setPreco(35.50);
		produto.setQuantidadeEstoque(200);

		Connection conn = BancoDados.conectar();
		int resultado = new ProdutoDAO(conn).cadastrar(produto);

		assertEquals(1, resultado);
	}

	@Test
	void buscarTodosProdutosTeste() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		List<Produto> listaProdutos = new ProdutoDAO(conn).buscarTodos();

		assertNotNull(listaProdutos);

		for (Produto produto : listaProdutos) {
			System.out.println(produto);
		}
	}

	@Disabled
	void buscarPorCodigoProdutoTeste() throws SQLException, IOException {

		int idProduto = 2;

		Connection conn = BancoDados.conectar();
		Produto produto = new ProdutoDAO(conn).buscarPorCodigo(idProduto);

		assertNotNull(produto);
		assertEquals("Camiseta Básica Algodão Masculina", produto.getNome());
	}

	@Disabled
	void atualizarProdutoTeste() throws SQLException, IOException {

		Produto produto = new Produto();

		produto.setId(2);
		produto.setNome("Camiseta Básica Algodão Feminina");
		produto.setCategoria("Vestuário 2");
		produto.setPreco(169.90);
		produto.setQuantidadeEstoque(121);

		Connection conn = BancoDados.conectar();
		int resultado = new ProdutoDAO(conn).atualizar(produto);

		assertEquals(1, resultado);
	}
	
	@Disabled
	void excluirProdutoTeste() throws SQLException, IOException {

		int idProduto = 2;

		Connection conn = BancoDados.conectar();
		int resultado = new ProdutoDAO(conn).excluir(idProduto);

		assertEquals(1, resultado);
	}
}
