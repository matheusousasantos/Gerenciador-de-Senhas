package teste;

import org.junit.jupiter.api.Test;

import bean.Conta;
import connection.SingleConnection;
import dao.ContaDAO;

class Testes {
	
	Conta conta = new Conta();
	ContaDAO dao = new ContaDAO();

	@Test
	void testConnection() {
		SingleConnection.getConnection();
	}
	
	@Test
	void salvarConta() {
		
	}
	
	

}
