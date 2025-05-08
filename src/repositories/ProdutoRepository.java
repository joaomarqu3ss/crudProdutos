package repositories;

import java.util.UUID;

import entities.Produto;
import factories.ConnectionFactory;

public class ProdutoRepository {
	private ConnectionFactory connectionFactory = new ConnectionFactory();

	public void inserir(Produto produto) {
		try {
			var connection = connectionFactory.obterConexao();
			var statement = connection
					.prepareStatement("insert into produto(id, nome, preco, quantidade) values(?,?,?,?)");
			statement.setObject(1, produto.getId());
			statement.setString(2, produto.getNome());
			statement.setDouble(3, produto.getPreco());
			statement.setInt(4, produto.getQuantidade());
			statement.execute();
			connection.close();
			System.out.println("Produto inserido com sucesso!");

		} catch (Exception e) {
			System.out.println("Erro ao cadastrar produto no banco de dados: " + e.getMessage());
		}

	}

	public void atualizar(Produto produto) {
		try {
			var connection = connectionFactory.obterConexao();
			var statement = connection
					.prepareStatement("update produto set nome = ?, preco = ?, quantidade = ? where id = ?");
			statement.setString(1, produto.getNome());
			statement.setDouble(2, produto.getPreco());
			statement.setInt(3, produto.getQuantidade());
			statement.setObject(4, produto.getId());
			var result = statement.executeUpdate();
			if (result > 0) {
				System.out.println("Produto atualizado com sucesso!" + result);
			} else {
				System.out.println("Produto não encontrado.");
			}

			connection.close();

		} catch (Exception e) {
			System.out.println("Erro ao atualizar produto no banco de dados: " + e.getMessage());
		}

	}

	public void excluir(UUID id) {
		try {

			var connection = connectionFactory.obterConexao();
			var statement = connection.prepareStatement("delete from produto where id = ?");
			statement.setObject(1, id);
			var result = statement.executeUpdate();
			if (result > 0) {
				System.out.println("Produto excluído com sucesso!" + result);
			} else {
				System.out.println("Produto não encontrado.");
			}

			connection.close();

		} catch (Exception e) {
			System.out.println("Erro ao excluir produto no banco de dados: " + e.getMessage());
		}

	}

	public void listar() {
		try {
			
			var connection = connectionFactory.obterConexao();
			var statement = connection.prepareStatement("select * from produto order by nome");
			var result = statement.executeQuery();
			while(result.next()) {
				System.out.println("ID: " + result.getString("id"));
				System.out.println("Nome: " + result.getString("nome"));
				System.out.println("Preço: " + result.getDouble("preco"));
				System.out.println("Quantidade: " + result.getInt("quantidade"));
				System.out.println("=====================================");
			}
			

		} catch (Exception e) {
			System.out.println("Erro ao listar produtos no banco de dados: " + e.getMessage());
		}
	}

}
