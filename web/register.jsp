<%--
  Created by IntelliJ IDEA.
  User: Hans Laptop
  Date: 10/02/2018
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro de usuario</title>
</head>
<body>
    <table>
        <tr>
            <th colspan="2">Registro de usuario</th>
        </tr>
        <tr>
            <td>Nombres:</td>
            <td><input type="text" placeholder="Ingrese Nombres"/></td>
        </tr>
        <tr>
            <td>Apellidos:</td>
            <td><input type="text" placeholder="Ingrese Apellidos"/></td>
        </tr>
        <tr>
            <td>Correo:</td>
            <td><input type="text" placeholder="Ingrese Correo"/></td>
        </tr>
        <tr>
            <td>Genero:</td>
            <td><input type="radio" name="gender" value="Masculino"> Masculino
                <input type="radio" name="gender" value="Femenino"> Femenino
            </td>
        </tr>
        <tr>
            <td>Correo:</td>
            <td><input type="text" placeholder="Ingrese correo"/></td>
        </tr>
        <tr>
            <td>Fecha de nacimiento:</td>
            <td><input type="date"/></td>
        </tr>
        <tr>
            <td>Lugar: </td>
            <td>
                <select name="Departamento">
                    <option value="" selected>--Departamento--</option>
                    <option value="volvo">Lima</option>
                    <option value="saab">Arequipa</option>
                    <option value="fiat">Piura</option>
                    <option value="audi">Cusco</option>
                    <option value="audi">Puno</option>
                    <option value="audi">Ica</option>
                </select>
                <input type="text" placeholder="Ingrese dirección" required/>
            </td>
        </tr>
        <tr>
            <td>Fecha de nacimiento:</td>
            <td><input type="date"/></td>
        </tr>
        <tr>
            <td>Celular:</td>
            <td><input type="number" placeholder="Ingrese Celular"/></td>
        </tr>
        <tr>
            <td>DNI:</td>
            <td><input type="number" placeholder="Ingrese DNI"/></td>
        </tr>
        <tr>
            <td><button type="submit">Guardar</button></td>
            <td><button type="button" onclick="history.back()">Atrás</button></td>
        </tr>
    </table>

</body>
</html>
