<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hans Laptop
  Date: 3/02/2018
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Barmans</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
</head>
<body>
    <nav class="navbar navbar-toggleable-md navbar-light bg-faded">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="#">Inicio</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Mis Pedidos <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Mensajes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Notificaciones</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Ingrese nombre de Barman">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
            </form>
        </div>
    </nav>
    <h1>Lista de Barmans</h1>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Especialidades</th>
            <th>Acción</th>
        </tr>
        <tr>
            <td>1</td>
            <td>Julio Guzman</td>
            <td>Pisco - Tequila - Vodka - Whiski</td>
            <td><a href="">Ver</a></td>
        </tr>
        <tr>
            <td>1</td>
            <td>Julio Guzman</td>
            <td>Pisco - Tequila - Vodka - Whiski</td>
            <td><a href="">Ver</a></td>
        </tr>
        <tr>
            <td>1</td>
            <td>Julio Guzman</td>
            <td>Pisco - Tequila - Vodka - Whiski</td>
            <td><a href="">Ver</a></td>
        </tr>
        <tr>
            <td>1</td>
            <td>Julio Guzman</td>
            <td>Pisco - Tequila - Vodka - Whiski</td>
            <td><a href="">Ver</a></td>
        </tr>


        <c:forEach var="barman" items="${barmans}">
            <tr>
                <td>
                    <a href="barmans?action=show&id=${barman.id}">
                        <c:out value="${barman.id}"/> //c es biblioteca de jsp ,
                    </a>
                </td>
                <td> <c:out value="${barman.name}"/> </td>
                <td>
                    <a href="barmans?action=edit&id=${barman.id}">Edit</a>
                    <a href="barmans?action=delete&id=${barman.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="barmans?action=new">New Region</a></p>
    <script src="http://code.jquery.com/jquery-3.3.1.min.jss"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>
