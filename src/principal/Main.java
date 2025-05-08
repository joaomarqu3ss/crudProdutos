package principal;

import java.util.Scanner;

import controllers.ProdutoController;

public class Main {

	public static void main(String[] args) {
		
		var produtocontroller = new ProdutoController();
		Scanner scanner = new Scanner(System.in);
		var executando = true;
		while (executando) {
			System.out.println("Digite 1 para cadastrar produto");
			System.out.println("Digite 2 para atualizar produto");
			System.out.println("Digite 3 para excluir produto");
			System.out.println("Digite 4 para consultar produtos");
			System.out.println("Digite 5 para sair");
			var opcao = scanner.nextInt();
			switch (opcao) {
				case 1:
					produtocontroller.cadastrarProduto();
					break;
				case 2:
					produtocontroller.atualizarProduto();
					break;
				case 3:
					produtocontroller.exlcuirProduto();
					break;
				case 4:
					produtocontroller.consultarProdutos();
					break;
				case 5:
					executando = false;
					break;
				default:
					System.out.println("Opção inválida!");
			}
		}
		scanner.close();

	}

}
