<%-- 
    Document   : register
    Created on : 15 feb. 2024, 18:11:34
    Author     : Pablo Alcudia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdn.tailwindcss.com"></script>
        <title>JSP Page</title>
    </head>
    <body class="bg-gray-200 h-screen flex justify-center items-center">
    <div class="max-w-md w-full p-6 bg-white rounded-md shadow-md">
        <h1 class="text-2xl font-bold mb-4 text-center">Registro de Usuario</h1>
        <form action="./Usuario?accion=insert" method="POST" class="space-y-4">
           
                <input type="text" name="nombre" placeholder="Nombre" required class="block w-full border-gray-300 rounded-md shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">
                <input type="email" name="username" placeholder="username" required class="block w-full border-gray-300 rounded-md shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">
                <input type="password" name="contrasena" placeholder="contrasena" required class="block w-full border-gray-300 rounded-md shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">
                <button type="submit" value="insert" class="w-full bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" >Registrarse</button>
         
           
        </form>
    </div>
</body>
</html>
