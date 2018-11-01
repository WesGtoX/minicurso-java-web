<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<jsp:useBean id="usuarioTeste" class="model.Usuario"></jsp:useBean>
	<jsp:useBean id="usuarioTesteDao" class="dao.UsuarioDao"></jsp:useBean>
</head>
<body>
	<%
		String nome = request.getParameter("nome");
		String eMail = request.getParameter("email");
		
		usuarioTeste.setNome(nome);
		usuarioTeste.setEmail(eMail);
		
		usuarioTesteDao.insert(usuarioTeste);
	%>
	
	<script>
		alert('Registro Inserido com Sucesso!')
		window.location.href = "forminsert.html"
	</script>
</body>
</html>