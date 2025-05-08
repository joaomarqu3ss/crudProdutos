package controllers;

import java.util.Scanner;
import java.util.UUID;

import entities.Produto;
import repositories.ProdutoRepository;

public class ProdutoController {
	private Scanner scanner = new Scanner(System.in);

	public void cadastrarProduto() {
		var produto = new Produto();
		produto.setId(UUID.randomUUID());
		System.out.println("Digite o nome do produto: ");
		produto.setNome(scanner.nextLine());
		System.out.println("Digite o preço do produto: ");
		produto.setPreco(scanner.nextDouble());
		System.out.println("Digite a quantidade em estoque: ");
		produto.setQuantidade(scanner.nextInt());

		var produtoRepository = new ProdutoRepository();
		produtoRepository.inserir(produto);

	}

	public void atualizarProduto() {
		var produto = new Produto();
		System.out.println("Digite o id do produto: ");
		produto.setId(UUID.fromString(scanner.nextLine()));
		System.out.println("Digite o nome do produto: ");
		produto.setNome(scanner.nextLine());
		System.out.println("Digite o preço do produto: ");
		produto.setPreco(scanner.nextDouble());
		System.out.println("Digite a quantidade em estoque: ");
		produto.setQuantidade(scanner.nextInt());

		var produtoRepository = new ProdutoRepository();
		produtoRepository.atualizar(produto);

	

	}
	public void exlcuirProduto() {
		System.out.println("Digite o id do produto: ");
		var id = UUID.fromString(scanner.nextLine());

		var produtoRepository = new ProdutoRepository();
		produtoRepository.excluir(id);

		System.out.println("Produto excluído com sucesso!");
	}
	public void consultarProdutos() {
		var produtoRepository = new ProdutoRepository();
		produtoRepository.listar();
		
		System.out.println("Produtos listados com sucesso!");
	}
}
