<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${language.name}</title>
</head>
<body>
<a href="/languages">Dashboard</a><br>
   <p>${language.name}</p><br>
   <p>${language.creator}</p><br>
   <p>${language.version}</p><br>
   <a href="/languages/${language.id}/delete">Delete</a> <a href="/languages/${language.id}/edit">edit</a>

</body>
</html>