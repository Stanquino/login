<%--
  Created by IntelliJ IDEA.
  User: ESTUDIANTE
  Date: 30/5/2024
  Time: 8:11
  To change this template use File | Settings | File Templates.--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Iniciar Sesión</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 10px;
            color: #333;
            font-weight: bold;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #ffffff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: rgba(255, 0, 28, 0.96);
        }
    </style>
</head>
<body>
<h1>Iniciar Sesión</h1>
<form action="Login" method="post">
    <label for="username">Nombre de Usuario:</label><br>
    <input type="text" id="username" name="username"><br><br>
    <label for="password">Contraseña:</label><br>
    <input type="password" id="password" name="password"><br><br>
    <input type="submit" value="Ingresar">
</form>
</body>
</html>
