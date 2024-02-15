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
        <title>Pagina Login</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
    <body class="bg-gray-100 h-screen flex justify-center items-center">
        <div class="bg-white p-8 rounded-lg shadow-md">
            <h1 class="text-2xl font-bold mb-4 text-center">Gestión de Médicos</h1>
            <form action="./Usuario?accion=login" method="POST" class="space-y-4">
               
                <input type="email" name="email" placeholder="Email" required class="block w-full border-gray-300 rounded-md shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">
                <input type="password" name="contrasena" placeholder="Contraseña" required class="block w-full border-gray-300 rounded-md shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">
                <button type="submit" value="login" class="w-full bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" >Iniciar Sesión</button>
                <a href="./Usuario?accion=register" method="POST" class="inline-block bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded transition duration-300 ease-in-out">¿Aún no tienes cuenta? Registrate aquí</a>
            </form>
            <% String mensaje = (String) request.getAttribute("mensaje"); %>
            <% if (mensaje != null) {%>
            <p class="text-red-500 mt-2"><%= mensaje%></p>
            <% }%>
        </div>
    </body>
</body>
</html>
