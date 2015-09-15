<%-- 
    Document   : index
    Created on : Oct 21, 2014, 3:41:58 PM
    Author     : Kari
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>
        <h1>Data in my Connection Pooled Database</h1>
        <br>
        <%
            InitialContext ctx = new InitialContext();
            //The JDBC Data source that we just created
            DataSource ds = (DataSource) ctx.lookup("TutorialJDBCResource");
            Connection connection = ds.getConnection();

            if (connection == null)
            {
                throw new SQLException("Error establishing connection!");
            }
            String query = "SELECT * FROM asiakkaat";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                out.print(rs.getString("nimi") + "<br>");
            }
        %>
    </body>
</html>
