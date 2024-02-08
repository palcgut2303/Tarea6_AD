<%-- 
    Document   : editarmedicos
    Created on : 8 feb. 2024, 9:45:57
    Author     : manana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" charset="UTF-8">
        <title>EDITAR MEDICOS</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>

        <div class="container">
            <h1 class="text-center">Editar medicos</h1>

            <div class="row">
                <section class="col-md-3">
                    <form action="./medicos.jsp?accion=modificar&id=${amod.getIdMedicos()}" method="POST" accept-charset="UTF-8">

                        <div><input type="hidden" name="id" value="${amod.getIdMedicos()}"></div>
                        <div class="form-group"><label for="nombre">Nombre:</label><input class="form-control" type="text" name="nombre" value="${amod.getNombre()}"> </div>

                        <div class="form-group"><label for="sala">Sala:</label><input class="form-control" type="text" name="sala" value="${amod.getSala()}"> </div>
                        <div class="form-group"><label for="especialidad">Especialidad:</label><input class="form-control" type="text" name="especialidad" value="${amod.getEspecialidad()}"> </div>

                        <div class="form-group"><label for="tarifa">Tarifa</label><input class="form-control" type="text" name="tarifa" value="${amod.getTarifa()}"> </div>
                        <input type="submit" value="modificar" class="btn btn-outline-primary">
                    </form>
                </section>



                </section>

            </div>

        </div>

    </body>
</html>
