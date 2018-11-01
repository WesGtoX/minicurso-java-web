package view;

import dao.UsuarioDao;
import model.Usuario;

public class FormInsert {
	
	public static void main(String[] args) {
		String nome = "Usuario Form Fake";
		String eMail = "fake@email.com";
		
		Usuario usuarioTeste = new Usuario();
		usuarioTeste.setNome(nome);
		usuarioTeste.setEmail(eMail);
		
		UsuarioDao usuarioTesteDao = new UsuarioDao();
		usuarioTesteDao.insert(usuarioTeste);
		
		System.out.println("Usuario inserido com sucesso!");
	}
}
