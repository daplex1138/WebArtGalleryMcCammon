<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action ="editArtworkServlet" method ="post">
Artwork: <input type="text" name="title" value="${itemToEdit.title}">
Artist: <input type="text" name="artist_name" value="${itemToEdit.artist_name}">
<input type="hidden" name="id" value="${itemToEdit.id}">
<input type="submit" value="Save Edited Item">
</form>

</body>
</html>