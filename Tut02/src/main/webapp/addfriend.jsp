<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 02/17/2022
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- import JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

<nav class="navbar navbar-light bg-dark justify-content-center">
    <span class="navbar-brand mb-0 h1 text-white">Friend List</span>
</nav>


<!-- Background image -->
<div
        class="bg-image d-flex justify-content-center align-items-center"
        style="
    background-image: url('https://mdbcdn.b-cdn.net/img/new/fluid/nature/015.webp');
    height: 100vh;
  "
>
    <div class="container col-md-8 ">
        <%--    <h2 class="p-3 mb-2 bg-dark text-white text-center" >Friend List</h2>--%>

        <ul class="nav justify-content-center">
            <a type="button" class="btn btn-dark me-5 " href="new">Add New Friend</a>

            <a type="button" class="btn btn-dark " href="/Tut02_war_exploded/">List All Friends</a>
        </ul>

        <div align="center">
            <c:if test="${friend != null}">
            <form action="update" method="GET">
                </c:if>

                <c:if test="${friend == null}">
                <form action="insert" method="GET">
                    </c:if>
                    <h2 class="m-4">
                        <c:if test="${friend != null}">
                            <div class="text-light">
                                Edit Friend
                            </div>
                        </c:if>

                        <c:if test="${friend == null}">
                            <div class="text-light">
                                Add New Friend
                            </div>
                        </c:if>
                    </h2>


                    <table class="table table-dark table-hover table-striped text-center mt-3">
                        <caption>

                        </caption>

                        <c:if test="${friend != null}">
                            <input type="hidden" name="id" value="<c:out value='${friend.id}' />"/>
                        </c:if>

                        <tr>
                            <th>Name:</th>
                            <td>
                                <input class="shadow bg-body rounded" type="text" name="name" size="45"
                                       value="<c:out value='${friend.name}' />"
                                />
                            </td>
                        </tr>

                        <tr>
                            <th>Age:</th>
                            <td>
                                <input class="shadow bg-body rounded" type="text" name="age" size="45"
                                       value="<c:out value='${friend.age}' />"/>
                            </td>
                        </tr>

                        <tr>
                            <th>Sex:</th>
                            <td>
                                <input class="shadow bg-body rounded" type="text" name="sex" size="45"
                                       value="<c:out value='${friend.sex}' />"
                                />
                            </td>
                        </tr>

                        <tr>
                            <th>City:</th>
                            <td>
                                <input class="shadow bg-body rounded" type="text" name="city" size="45"
                                       value="<c:out value='${friend.city}' />"
                                />
                            </td>
                        </tr>

                        <tr>
                            <td colspan="2" align="center">
                                <div>
                                    <input type="submit" value="Save" class="btn btn-dark"/>



                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
        </div>

<%--                <button type="button" class="btn btn-primary" id="toastbtn">Show Toast</button>--%>

                <div class="toast">
                    <div class="toast-header">
                        <strong class="me-auto">Toast Header</strong>
                        <button type="button" class="btn-close" data-bs-dismiss="toast"></button>
                    </div>
                    <div class="toast-body">
                        <p>Some text inside the toast body</p>
                    </div>
                </div>
            </div>

            <script>
                document.getElementById("toastbtn").onclick = function() {
                    var toastElList = [].slice.call(document.querySelectorAll('.toast'))
                    var toastList = toastElList.map(function(toastEl) {
                        return new bootstrap.Toast(toastEl)
                    })
                    toastList.forEach(toast => toast.show())
                }
            </script>
    </div>



</div>

</body>
</html>
