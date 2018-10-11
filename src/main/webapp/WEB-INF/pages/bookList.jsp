<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 04.09.2018
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table cellspacing="1" cellpadding="1" border="1">
    <tr>
        <td>Id</td>
        <td>userId</td>
        <td>author</td>
        <td>title</td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td><c:out value="${book.id}"/></td>
            <td><c:out value="${book.student.id}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><a href="/book/editBook/${book.id}">Edit</a></td>
            <td><a href="/book/removeBook/${book.id}">Delete</a></td>
        </tr>
    </c:forEach>


</table>
<a href="/book/addBook/{studentId}">Add book</a>
<a href="/student/">Students</a>
</body>
</html>
