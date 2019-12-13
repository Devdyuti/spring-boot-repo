<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.SQLException" %>

<%! DataSource dataSource=null; %>
<%! Connection conn=null;%>

<%
try {
	InitialContext ctxt=new InitialContext();
	dataSource=(DataSource) ctxt.lookup("java:jboss/exported/jcr/RCDArchivedRepository");
} catch (NamingException e) {
	System.out.println("Datasource not Initialized: "+e);
}
try {
	conn=dataSource.getConnection();
}catch (SQLException e) {
	System.out.println("Connection not avlaible: "+e);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index page</title>
</head>
<body>
<h2>JCR index page!</h2>
</body>
</html>