<%@ page import="com.theah64.xrob.api.database.tables.Clients" %>
<%--
  Created by IntelliJ IDEA.
  User: theapache64
  Date: 30/8/16
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    if (session.getAttribute(Clients.COLUMN_ID) == null) {
        response.sendRedirect("signup.jsp");
        return;
    }
%>
