<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 02/16/2022
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- import JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Friend List</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>


<!-- Background image -->
<div
        class="view" style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/Others/img%20%2848%29.webp'); background-repeat: no-repeat; background-size: cover; background-position: center center ;"
>
    <nav class="navbar navbar-light bg-dark justify-content-center">
        <span class="navbar-brand mb-0 h1 text-white">Friend List</span>
    </nav>

    <div class="container col-md-8">
        <%--        <h2 class="p-3 mb-2 bg-dark text-white text-center" >Friend List</h2>--%>

        <ul class="nav justify-content-center mx-auto mt-3">
            <a type="button" class="btn btn-dark me-2 " href="new">Add New Friend</a>

            <a type="button" class="btn btn-dark" href="/Tut02_war_exploded/">List All Friends</a>
        </ul>

        <table class="table table-dark table-hover table-responsive table-striped text-center mt-3">
            <thead>
            <tr>
                <th>Friend ID</th>
                <th>Friend Name</th>
                <th>Friend Age</th>
                <th>Friend Sex</th>
                <th>Friend City</th>
                <th>Action</th>
            </tr>
            </thead>
            <tboby>
                <c:forEach  var="friend" items="${friends}">
                    <tr>
                        <td class="text-white"><c:out value="${friend.id}"/></td>
                        <td><c:out value="${friend.name}"/></td>
                        <td><c:out value="${friend.age}"/></td>
                        <td><c:out value="${friend.sex}"/></td>
                        <td><c:out value="${friend.city}"/></td>
                        <td>
                            <a type="button" class="btn btn-outline-warning"
                               href="edit?id=<c:out value='${friend.id}' />">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a type="button" class="btn btn-outline-danger"
                               href="delete?id=<c:out value='${friend.id}' />">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tboby>
        </table>
    </div>
    <footer class="navbar bg-dark opacity-75 justify-content-center text-white mt-5 ">Bui Duc Anh - 1901040003</footer>

</div>
<!-- Background image -->

</body>
</html>
