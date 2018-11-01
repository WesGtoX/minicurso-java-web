package view;

import dao.UsuarioDao;

public class FormDelete {

	public static void main(String[] args) {
		UsuarioDao ud = new UsuarioDao();
		
		int codigo = 1;
		
		ud.delete(codigo);
		
		System.out.println("Registro excluído com sucesso.");
	}
}
