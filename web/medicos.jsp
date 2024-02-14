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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>

        <div class="container">
            <h1 class="text-center">Gestión de Medicos</h1>

            <div class="row">
                <section class="col-md-3">
                    <form action="./Medico?accion=insertar" method="POST" accept-charset="UTF-8">

                        <div><input type="hidden" name="id" value="${a.getIdMedicos()}"></div>
                        <div class="form-group"><label for="nombre">Nombre</label><input class="form-control" type="text" name="nombre" value="" > </div>

                        <div class="form-group"><label for="sala">Sala</label><input class="form-control" type="text" name="sala" value=""> </div>
                        <div class="form-group"><label for="especialidad">Especialidad</label><input class="form-control" type="text" name="especialidad" value=""> </div>
                        <div class="form-group"><label for="tarifa">Tarifa</label><input class="form-control" type="text" name="tarifa" value=""> </div>


                        <input type="submit" value="insertar" class="btn btn-outline-primary">
                    </form>
                </section>



                </section>
                <section class="col-md-9">
                    <table class="table table-sm table-hover">
                        <thead class="thead-dark">
                        <th>id</th>
                        <th>Nombre</th>
                        <th>Sala</th>
                        <th>Especialidad</th>
                        <th>Tarifa</th>
                        <th>acciones</th>
                        </thead>
                        <tbody>
                           
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
                <section class="col-md-2">
                    <h1 items="${totalMedicos}" var="total">Tarifa Total ${total} </h1>
                    <h1>Total Médicos</h1>
                </section>
            </div>
             
        </div>
    </body>
</html>
