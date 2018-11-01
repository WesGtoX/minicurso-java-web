package view;

import java.util.List;

import dao.UsuarioDao;
import model.Usuario;

public class FormSelect {
	
	public static void main(String[] args) {
		UsuarioDao ud = new UsuarioDao();
		
		List<Usuario> listaUsuarios = null;
		listaUsuarios = ud.select();
		
		int id;
		String nome, email;
		
		String info = "Lista de registros";
		
		for(Usuario userTMP : listaUsuarios) {		//cria um objeto da classe usuario, que é um item da lista
			id = userTMP.getId();
			nome = userTMP.getNome();
			email = userTMP.getEmail();
			
			info += "\n\nCódigo: " + id;
			info += "\nNome: " + nome;
			info += "\nE-mail: " + email;
		}
		
		System.out.println(info);
	}

}
