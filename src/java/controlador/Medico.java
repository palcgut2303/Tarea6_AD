/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ConectorBD;
import modelo.Medicos;

/**
 *
 * @author manana
 */
@WebServlet(name = "Medico", urlPatterns = {"/Medico"})
public class Medico extends HttpServlet {

    private ConectorBD bd;
    private boolean esVacio = false;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Medico</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Medico at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarMedicos(request, response);
                    break;

                case "eliminar":
                    this.eliminarMedicos(request, response);
                    break;

                default:
                    System.out.println("Cargando pagina");
                    this.cargarPagina(request, response);
            }

        } else {
            this.cargarPagina(request, response);
        }

    }

     private void cargarPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Conectando con la bd.....");
        bd = new ConectorBD();
        if (bd.conectar()) {
            System.out.println("Conectado");
            List<Medicos> medicos = bd.listarMedico();
            System.out.println("medico después de bd" + medicos);
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            request.setAttribute("medicos", medicos);
            request.setAttribute("totalMedicos", medicos.size());
            int tarifaTotal = 0;

            for (Medicos medico : medicos) {
                tarifaTotal += medico.getTarifa();
            }
            request.setAttribute("tarifaTotal", tarifaTotal);

            request.getRequestDispatcher("./medicos.jsp").forward(request, response);
            return;
        }
    }

    private void cargarPaginaError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Conectando con la bd.....");
        bd = new ConectorBD();
        if (bd.conectar()) {
            System.out.println("Conectado");
            List<Medicos> medicos = bd.listarMedico();
            System.out.println("medico después de bd" + medicos);
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            request.setAttribute("medicos", medicos);
            request.setAttribute("totalMedicos", medicos.size());
            int tarifaTotal = 0;

            for (Medicos medico : medicos) {
                tarifaTotal += medico.getTarifa();
            }
            request.setAttribute("tarifaTotal", tarifaTotal);

            request.setAttribute("mensajeError", "Introduce los campos correctamente.");

            request.getRequestDispatcher("./medicos.jsp").forward(request, response);
            return;
        }
    }

    protected void editarMedicos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        Medicos a = new Medicos();
        if (bd.conectar()) {
            a = bd.buscarMedico(id);
        }

        request.setAttribute("amod", a);
        String jspEditar = "./editarmedicos.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        return;

    }

    protected void eliminarMedicos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if (bd.conectar()) {
            if (bd.eliminarMedico(Integer.parseInt(id))) {
                this.cargarPagina(request, response);
            }
        }

        this.cargarPagina(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        bd = new ConectorBD();
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarMedicos(request, response);
                    break;
                case "modificar":

                    this.modificarMedicos(request, response);
                    break;

                case "editar":
                    this.editarMedicos(request, response);
                    break;

                case "eliminar":
                    this.eliminarMedicos(request, response);
                    break;

                default:
                    this.cargarPagina(request, response);
            }

        } else {
            this.cargarPagina(request, response);
        }

    }

    protected void insertarMedicos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String sala = request.getParameter("sala");
        String especialidad = request.getParameter("especialidad");
        String tarifa = request.getParameter("tarifa");
        if (nombre.equalsIgnoreCase("") || sala.equalsIgnoreCase("") || especialidad.equalsIgnoreCase("") || tarifa.equalsIgnoreCase("") || !esNumero(sala) || !esNumero(tarifa)) {
            cargarPaginaError(request, response);

        } else {
            int salaBD = Integer.parseInt(sala);
            int tarifaBD = Integer.parseInt(tarifa);
            if (bd.conectar()) {
                if (bd.altaMedico(nombre, salaBD, especialidad, tarifaBD)) {
                    this.cargarPagina(request, response);
                }
            }
        }

    }

    public static boolean esNumero(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    protected void modificarMedicos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String sala = request.getParameter("sala");
        String especialidad = request.getParameter("especialidad");
        String tarifa = request.getParameter("tarifa");

        if (nombre.equalsIgnoreCase("") || sala.equalsIgnoreCase("") || especialidad.equalsIgnoreCase("") || tarifa.equalsIgnoreCase("") || !esNumero(sala) || !esNumero(tarifa)) {
               cargarPaginaEditarError(request, response);
        } else {
            float salaBD = Float.parseFloat(sala);

            int tarifaBD = Integer.parseInt(tarifa);
            if (bd.conectar()) {
                if (bd.updateMedico(Integer.parseInt(id), nombre, salaBD, especialidad, tarifaBD)) {
                    System.out.println("modificado");
                }

            }
            this.cargarPagina(request, response);
        }

    }
    
    private void cargarPaginaEditarError(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        request.setAttribute("mensajeError", "Introduce los campos correctamente");
                request.getRequestDispatcher("./editarmedicos.jsp").forward(request, response);
                return;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
