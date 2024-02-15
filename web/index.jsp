<%-- 
    Document   : index
    Created on : 15 feb. 2024, 9:14:16
    Author     : manana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
        <body class="bg-gray-100 h-screen flex justify-center items-center">
    <div class="bg-white p-8 rounded-lg shadow-md">
        <h1 class="text-2xl font-bold mb-4 text-center">Registro</h1>
        <form action="./Usuario?accion=login" class="space-y-4">
            <!--<input type="text" name="nombre" placeholder="Nombre" required class="block w-full border-gray-300 rounded-md shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">-->
            <input type="email" name="username" placeholder="username" required class="block w-full border-gray-300 rounded-md shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">
            <input type="password" name="contrasena" placeholder="Contraseña" required class="block w-full border-gray-300 rounded-md shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">
            <button type="submit" href="./Usuario?accion=login class="w-full bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" >Registrarse</button>
        </form>
    </div>
</body>
    </body>
</html>
