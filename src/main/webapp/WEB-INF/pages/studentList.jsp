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
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach items="${students}" var="st">
        <tr>
            <td><c:out value="${st.id}"/></td>
            <td><c:out value="${st.name}"/></td>
            <td><c:out value="${st.age}"/></td>
            <td><c:out value="${st.admin}"/></td>
            <td><c:out value="${st.created_date}"/></td>
            <td><a href="/student/editStudent/${st.id}">EditStudent</a></td>
            <td><a href="/student/delStudent/${st.id}">Delete</a></td>
            <td><a href="/book/bookList/${st.id}">Books</a></td>
        </tr>


    </c:forEach>
</table>
<tr><a href="/student/addStudent">AddStudent</a></tr>

</body>
</html>
