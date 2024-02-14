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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>

        <div class="flex-column w-full">
            <h1 class="text-center text-6xl text-center font-bold">Gestión de Medicos</h1>

            <div class="flex justify-around">
                <section >
                    <form action="./Medico?accion=insertar" method="POST" accept-charset="UTF-8">

                        <div><input type="hidden" name="id" value="${a.getIdMedicos()}"></div>
                        <div ><label for="nombre">Nombre</label><input  type="text" name="nombre" value="" > </div>

                        <div ><label for="sala">Sala</label><input  type="text" name="sala" value=""> </div>
                        <div ><label for="especialidad">Especialidad</label><input  type="text" name="especialidad" value=""> </div>
                        <div ><label for="tarifa">Tarifa</label><input  type="text" name="tarifa" value=""> </div>


                        <input type="submit" value="insertar" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">
                    </form>
                </section>



                </section>
                <section>
                    <table class="table-auto p-2">
                        <thead class="bg-stone-900 text-slate-100">
                            <th>id</th>
                            <th>Nombre</th>
                            <th>Sala</th>
                            <th>Especialidad</th>
                            <th>Tarifa</th>
                            <th>acciones</th>
                        </thead>
                        <tbody class="text-black">
                            <c:forEach items="${medicos}" var="lista">
                                <tr>
                                    <td>${lista.getIdMedicos()}</td>
                                    <td>${lista.getNombre()}</td>
                                    <td>${lista.getSala()}</td>
                                    <td>${lista.getEspecialidad()}</td>
                                    <td>${lista.getTarifa()}</td>
                                    <td class="row"> 
                                        <a class="btn btn-outline-warning"  href="./Medico?accion=editar&id=${lista.getIdMedicos()}"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a> &nbsp;
                                        <a class="btn btn-outline-danger" href="./Medico?accion=eliminar&id=${lista.getIdMedicos()}"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </section>
                <section>
                    <h1 items="${totalMedicos}" var="total">Tarifa Total ${total} </h1>
                    <h1>Total Médicos</h1>
                </section>
            </div>

        </div>
    </body>
</html>
