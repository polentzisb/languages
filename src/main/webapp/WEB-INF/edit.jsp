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
<a href="/languages/${language.id}/delete">Delete</a> <a href="/languages">Dashboard</a>
	<div class="lang">
        	<form:form action="/languages/${language.id}/edit" method="post" modelAttribute="language">
        	        <input type="hidden" name="_method" value="put" />
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <form:label path="name">Name</form:label>    
                            <form:input path="name" placeholder="${language.name}"/>
                            <form:errors path="name"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                             <form:label path="creator">creator</form:label>
                             <form:input path="creator"/>
                             <form:errors path="creator"/>                        
                        </div>
                        <div class="col-md-6 mb-3">
                            <form:label path="version">version</form:label>
                            <form:input path="version" />
                            <form:errors path="version"/>
                        </div>
                        <input type="submit" value="Update"/>
                    </div>
         		</form:form>
        </div>

</body>
</html>