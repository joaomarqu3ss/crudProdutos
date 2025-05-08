package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection obterConexao() {
		try {
			var host = "jdbc:postgresql://localhost:5434/projetoaula03";
			var user = "usuariocoti";
			var pass = "coti2025";
			return DriverManager.getConnection(host, user, pass);
			
			
		} catch (Exception e) {
			
			System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
			return null;
			
		}
		
		
		
	}

}
