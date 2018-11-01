package view;

import dao.UsuarioDao;
import model.Usuario;

public class FormUpdate {

	public static void main(String[] args) {
		Usuario u = new Usuario();
		
		u.setId(2);
		u.setNome("Usuario Alterado");
		u.setEmail("novo@email.com");
		
		UsuarioDao ud = new UsuarioDao();
		ud.update(u);
		
		System.out.println("Usuario alterado com sucesso.");
	}
}
