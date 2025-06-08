package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Produto;

public class ProdutoDAO {

	private Connection conn;

	public ProdutoDAO(Connection conn) {

		this.conn = conn;
	}

	public int cadastrar(Produto produto) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("insert into produto (nome, categoria, preco, quantidadeEstoque) values (?, ?, ?, ?)");

			st.setString(1, produto.getNome());
			st.setString(2, produto.getCategoria());
			st.setDouble(3, produto.getPreco());
			st.setInt(4, produto.getQuantidadeEstoque());

			return st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public List<Produto> buscarTodos() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from produto");

			rs = st.executeQuery();

			List<Produto> listaProdutos = new ArrayList<>();

			while (rs.next()) {

				Produto produto = new Produto();

				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setCategoria(rs.getString("categoria"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));

				listaProdutos.add(produto);
			}

			return listaProdutos;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

	public Produto buscarPorCodigo(int idProduto) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from produto where id = ?");

			st.setInt(1, idProduto);

			rs = st.executeQuery();

			if (rs.next()) {

				Produto produto = new Produto();

				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setCategoria(rs.getString("categoria"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));

				return produto;
			}

			return null;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public int atualizar(Produto produto) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("update produto set nome = ?, categoria = ?, preco = ?, quantidadeEstoque = ? where id = ?");

			st.setString(1, produto.getNome());
			st.setString(2, produto.getCategoria());
			st.setDouble(3, produto.getPreco());
			st.setInt(4, produto.getQuantidadeEstoque());
			st.setInt(5, produto.getId());

			return st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public int excluir(int idProduto) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("delete from produto where id = ?");

			st.setInt(1, idProduto);

			return st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}
