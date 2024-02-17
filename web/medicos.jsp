<%-- 
    Document   : medicos
    Created on : 8 feb. 2024, 9:44:01
    Author     : manana
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" charset="UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>

        <div class="flex-column w-full">
            <h1 class="text-center text-6xl text-center font-bold">Gestión de Medicos</h1>

            <div class="flex justify-around">
                <section class="max-w-xl">
                    <form action="./Medico?accion=insertar" method="POST" accept-charset="UTF-8" class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
                        <input type="hidden" name="id" value="${a.getIdMedicos()}">

                        <div class="mb-4">
                            <label for="nombre" class="block text-gray-700 text-sm font-bold mb-2">Nombre</label>
                            <input type="text" name="nombre" value="" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                        </div>

                        <div class="mb-4">
                            <label for="sala" class="block text-gray-700 text-sm font-bold mb-2">Sala</label>
                            <input type="text" name="sala" value="" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                        </div>

                        <div class="mb-4">
                            <label for="especialidad" class="block text-gray-700 text-sm font-bold mb-2">Especialidad</label>
                            <input type="text" name="especialidad" value="" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                        </div>

                        <div class="mb-6">
                            <label for="tarifa" class="block text-gray-700 text-sm font-bold mb-2">Tarifa</label>
                            <input type="text" name="tarifa" value="" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                        </div>

                        <div class="flex items-center justify-between">
                            <input type="submit" value="Insertar" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">
                        </div>
                    </form>
                       
                </section>



                </section>
                <section class="w-2/4">
                    <table class="table-auto p-2 w-full">
                        <thead class="bg-gray-900 text-gray-100">
                            <tr>
                                <th class="px-4 py-2">id</th>
                                <th class="px-4 py-2">Nombre</th>
                                <th class="px-4 py-2">Sala</th>
                                <th class="px-4 py-2">Especialidad</th>
                                <th class="px-4 py-2">Tarifa</th>
                                <th class="px-4 py-2">Acciones</th>
                            </tr>
                        </thead>
                        <tbody class="text-gray-800">
                            <c:forEach items="${medicos}" var="lista">
                                <tr>
                                    <td class="border px-4 py-2">${lista.getIdMedicos()}</td>
                                    <td class="border px-4 py-2">${lista.getNombre()}</td>
                                    <td class="border px-4 py-2">${lista.getSala()}</td>
                                    <td class="border px-4 py-2">${lista.getEspecialidad()}</td>
                                    <td class="border px-4 py-2">${lista.getTarifa()}</td>
                                    <td class="border px-4 py-2 flex items-center">
                                        <a class="btn btn-outline-warning bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mr-2 ml-20" href="./Medico?accion=editar&id=${lista.getIdMedicos()}">
                                            <i class="fas fa-pencil-alt"></i> Editar
                                        </a>

                                        <a class="btn btn-outline-danger bg-red-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" href="./Medico?accion=eliminar&id=${lista.getIdMedicos()}">
                                            <i class="fas fa-trash-alt"></i> Eliminar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </section>
                <section class="max-w-xl px-4 py-8">
                    <h1 class="text-2xl font-bold mb-4 bg-red-500 text-white py-2 px-4 inline-block rounded-full">Tarifa Total: ${tarifaTotal}</h1>
                    <br>
                    <h1 class="text-2xl font-bold mb-4 bg-green-500 text-white py-2 px-4 inline-block rounded-full">Total Médicos: ${totalMedicos}</h1>
                </section>
            </div>

        </div>
    </body>
</html>
