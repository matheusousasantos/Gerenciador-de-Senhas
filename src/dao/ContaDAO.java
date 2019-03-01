package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Conta;
import connection.SingleConnection;

public class ContaDAO {

	private Connection connection;

	public ContaDAO() {

		connection = SingleConnection.getConnection();
	}

	public void salvar(Conta obj) {
		String sql = "INSERT INTO Conta(descricao, link, login, senha, tipo, usuario, imagem) VALUES(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pmt = connection.prepareStatement(sql);
			pmt.setString(1, obj.getDescricao());
			pmt.setString(2, obj.getLink());
			pmt.setString(3, obj.getLogin());
			pmt.setString(4, obj.getSenha());
			pmt.setString(5, obj.getTipo());
			pmt.setLong(6, obj.getUsuario());
			pmt.setString(7, obj.getImagem());
			
			pmt.execute();
			connection.commit();

		} catch (SQLException e) {
			try {
				e.printStackTrace();
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public void delete(String id) {

		String sql = "DELETE FROM Conta WHERE id = '" + id + "'";
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.execute();
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public List<Conta> listar(Long id) throws SQLException {
		List<Conta> lista = new ArrayList<>();

		String sql = "SELECT * FROM Conta WHERE usuario="+ id +" ORDER BY descricao ASC";

		PreparedStatement list = connection.prepareStatement(sql);
		ResultSet rs = list.executeQuery();

		while (rs.next()) {

			Conta obj = new Conta();
			obj.setId(rs.getLong("id"));
			obj.setDescricao(rs.getString("descricao"));
			obj.setLink(rs.getString("link"));
			obj.setLogin(rs.getString("login"));
			obj.setSenha(rs.getString("senha"));
			obj.setTipo(rs.getString("tipo"));
			obj.setUsuario(rs.getLong("usuario"));
			obj.setImagem(rs.getString("imagem"));
			
			lista.add(obj);
		}

		return lista;
	}
	
	public List<Conta> listarPeloTipo(String tipo) throws SQLException {
		List<Conta> lista = new ArrayList<>();

		String sql = "SELECT * FROM Conta WHERE tipo="+ tipo +" ORDER BY descricao ASC";

		PreparedStatement list = connection.prepareStatement(sql);
		ResultSet rs = list.executeQuery();

		while (rs.next()) {

			Conta obj = new Conta();
			obj.setId(rs.getLong("id"));
			obj.setDescricao(rs.getString("descricao"));
			obj.setLink(rs.getString("link"));
			obj.setLogin(rs.getString("login"));
			obj.setSenha(rs.getString("senha"));
			obj.setTipo(rs.getString("tipo"));
			obj.setUsuario(rs.getLong("usuario"));
			obj.setImagem(rs.getString("imagem"));
			
			lista.add(obj);
		}

		return lista;
	}

	public Conta consultar(String id) {

		String sql = "SELECT * FROM Conta WHERE id = '" + id + "'";
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Conta obj = new Conta();
				obj.setId(rs.getLong("id"));
				obj.setDescricao(rs.getString("descricao"));
				obj.setLink(rs.getString("link"));
				obj.setLogin(rs.getString("login"));
				obj.setSenha(rs.getString("senha"));
				obj.setTipo(rs.getString("tipo"));
				obj.setUsuario(rs.getLong("usuario"));
				obj.setImagem(rs.getString("imagem"));

				return obj;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void atualizar(Conta obj) {

		String sql = "UPDATE Conta SET descricao = ?, link = ?, login = ?, senha = ?, tipo = ?, usuario = ?, imagem = ? WHERE id =" + obj.getId();
		try {
			PreparedStatement pmt = connection.prepareStatement(sql);
			pmt.setString(1, obj.getDescricao());
			pmt.setString(2, obj.getLink());
			pmt.setString(3, obj.getLogin());
			pmt.setString(4, obj.getSenha());
			pmt.setString(5, obj.getTipo());
			pmt.setLong(6, obj.getUsuario());
			pmt.setString(7, obj.getImagem());
			connection.commit();

			pmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				e.printStackTrace();
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}