<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 04.09.2018
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/book/addBook/{studentId}">
    <table border="1" cellpadding="1" cellspacing="1">
        <tr>
            <td>Author</td>
            <td><input type="text" name="author"></td>
        </tr>
        <tr>
            <td>Title</td>
            <td><input type="text" name="title"></td>
        </tr>
    </table>
    <input type="submit" name="Save">

</form>


</body>
</html>
