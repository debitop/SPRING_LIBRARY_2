<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 04.09.2018
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table cellpadding="1" cellspacing="1" border="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>admin</td>
        <td>date</td>
    </tr>
    <c:forEach items="${students}" var="st">
        <tr>
            <c:out value="${st.id}"/>
            <c:out value="${st.name}"/>
            <c:out value="${st.age}"/>
            <c:out value="${st.admin}"/>
            <c:out value="${st.created_date}"/>
        </tr>
        <tr><a href="/student/editStudent/${st.id}">EditStudent</a></tr>
        <tr><a href="/student/delStudent/${st.id}">Delete</a></tr>

    </c:forEach>
</table>
<tr><a href="/student/addStudent">AddStudent</a></tr>

</body>
</html>
