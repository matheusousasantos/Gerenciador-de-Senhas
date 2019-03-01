package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Usuario;
import connection.SingleConnection;

public class UsuarioDAO {

	private Connection connection;

	public UsuarioDAO() {

		connection = SingleConnection.getConnection();
	}

	public void salvar(Usuario obj) {
		String sql = "INSERT INTO Usuario(nome, login, senha, email) VALUES(?,?,?,?)";
		try {
			PreparedStatement pmt = connection.prepareStatement(sql);
			pmt.setString(1, obj.getNome());
			pmt.setString(2, obj.getLogin());
			pmt.setString(3, obj.getSenha());
			pmt.setString(4, obj.getEmail());

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

		try {

			String sql = "DELETE FROM usuario WHERE id =" + id;
			PreparedStatement pmt = connection.prepareStatement(sql);

			pmt.execute();
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public List<Usuario> listar() throws SQLException {

		List<Usuario> lista = new ArrayList<>();

		String sql = "SELECT * FROM usuario";

		PreparedStatement pmt = connection.prepareStatement(sql);
		ResultSet rs = pmt.executeQuery();

		while (rs.next()) {
			Usuario obj = new Usuario();
			obj.setId(rs.getLong("id"));
			obj.setNome(rs.getString("nome"));
			obj.setLogin(rs.getString("login"));
			obj.setSenha(rs.getString("senha"));
			obj.setEmail(rs.getString("email"));
			lista.add(obj);
		}

		return lista;
	}

	public Usuario consultar(String id) throws SQLException {

		String sql = "SELECT * FROM usuario WHERE id =" + id;

		PreparedStatement pmt = connection.prepareStatement(sql);
		ResultSet rs = pmt.executeQuery();

		if (rs.next()) {
			Usuario obj = new Usuario();
			obj.setId(rs.getLong("id"));
			obj.setNome(rs.getString("nome"));
			obj.setLogin(rs.getString("login"));
			obj.setSenha(rs.getString("senha"));
			obj.setEmail(rs.getString("email"));

			return obj;

		}

		return null;
	}

	public void atualizar(Usuario obj) {

		try {
			String sql = "UPDATE  usuario SET nome = ?, login = ?, senha = ?, email = ? WHERE id =" + obj.getId();

			PreparedStatement pmt = connection.prepareStatement(sql);

			pmt.setString(1, obj.getNome());
			pmt.setString(2, obj.getLogin());
			pmt.setString(3, obj.getSenha());
			pmt.setString(4, obj.getEmail());

			pmt.executeUpdate();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e.printStackTrace();
			}
		}

	}
	
	public Usuario logar(String login, String senha) {
		
		try {
			String sql = "SELECT * FROM usuario WHERE login = '"+login+"'AND senha='"+senha+"'";
		
		PreparedStatement pmt = connection.prepareStatement(sql);
		
		ResultSet rs = pmt.executeQuery();
		
		if(rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(rs.getLong("id"));
			usuario.setNome(rs.getString("nome"));
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setEmail(rs.getString("email"));
			
			return usuario;
		}
		
		return null;
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	public boolean validarLogin(String login) throws Exception {

		String sql = "SELECT COUNT(1) qtd FROM usuario WHERE login = '" + login + "'";
		try {
			PreparedStatement pmt = connection.prepareStatement(sql);
			ResultSet rs = pmt.executeQuery();

			if (rs.next()) {

				return rs.getInt("qtd") <= 0;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean validarSenha(String senha) throws Exception {

		String sql = "SELECT COUNT(1) qtd FROM usuario WHERE senha = '" + senha + "'";
		try {
			PreparedStatement pmt = connection.prepareStatement(sql);
			ResultSet rs = pmt.executeQuery();

			if (rs.next()) {

				return rs.getInt("qtd") <= 0;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}