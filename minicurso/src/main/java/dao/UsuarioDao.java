package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco.ConexaoMysql;
import model.Usuario;

public class UsuarioDao {		//faz a conexao com o bando de dados
		private Connection con;
		private ConexaoMysql conexao;
		
	public UsuarioDao() {		//pega o usuario que esta instanciado
		this.conexao = ConexaoMysql.getInstancia();
		this.con = conexao.conecta();
	}
	
//	INSERIR
	public void insert(Usuario user) {		//insere no banco
		String sql = "insert into tb_usuarios " + "(nome, email) values (?, ?)";
		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);
			
			stmt.setString(1, user.getNome());	//recupera o nome que quero gravar no banco de dados
			stmt.setString(2, user.getEmail());	//recupera o email que quero gravar no banco de dados
			
			stmt.execute();		//executa o statement
			stmt.close();		//encerra o objeto
		}catch (SQLException e) {		//'SQLException' tipo do obejeto que vai reportar o erro
			throw new RuntimeException(e);		//excessao caso da erro
		}
	}
	
//	LISTAR
	public List<Usuario> select() {
		try {
			List<Usuario> users = new ArrayList<Usuario>();		//cria o metodo que a lista retorno
			String sql = "select * from tb_usuarios";		//comando sql que faz uma consulta no banco de dados
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();		//retorna o objeto do tipo 'resultSet'
			
			while(rs.next()) {		//enquanto houver registros
				Usuario u = new Usuario();
				u.setId(rs.getInt("id_usuarios"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				
				users.add(u);		//adiciona o objeto na lista de usuarios
			}
			rs.close();		//encerra o 'resultSet'
			stmt.close();		//encerra o statement
			
			return users;		//retorna os usuarios
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
//	DELETAR
	public void delete(int id) {
		String sql = "delete from tb_usuarios where id_usuarios = " + id;
		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
//	ATUALIZAR
	public void update(Usuario user) {
		String sql = "update tb_usuarios set " + "nome = ?, email = ?"	+ "where id_usuarios = ?";
		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);
			
			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getEmail());
			stmt.setInt(3, user.getId());
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
