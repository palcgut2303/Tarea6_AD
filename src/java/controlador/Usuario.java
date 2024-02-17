/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ConectorBD;
import modelo.Medicos;
import modelo.usuario;

/**
 *
 * @author manana
 */
@WebServlet(name = "Usuario", urlPatterns = {"/Usuario"})
public class Usuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private ConectorBD bd;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Usuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Usuario at " + request.getContextPath() + "</h1>");
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
        System.out.println("Accion enviada" + accion);
        if (accion != null) {
            switch (accion) {
                case "login":
                    this.login(request, response);
                    break;

                case "register":
                    this.irPaginaRegister(request, response);
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
        /*System.out.println("Conectando con la bd.....");
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
        }*/
        request.getRequestDispatcher("./index.jsp").forward(request, response);
        return;

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bd = new ConectorBD();
        if (bd.conectar()) {
            System.out.println("Conectado");
            String email = request.getParameter("username");
            String contrasena = request.getParameter("contrasena");
            System.out.println(email + " " + contrasena);
            if (bd.comprobarLogin(email, contrasena)) {
                System.out.println("Loggeando Correctamente");
                request.getRequestDispatcher("./menuPrincipal.jsp").forward(request, response);
                return;
            } else {
                System.out.println("Loggeando Incorrectamente");
                request.setAttribute("mensaje", "Credenciales incorrectas. Por favor, regístrese si es un nuevo usuario.");
                request.getRequestDispatcher("./index.jsp").forward(request, response);
                return;

            }
        }
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
        String accion = request.getParameter("accion");
        System.out.println("Accion enviada" + accion);
        if (accion != null) {
            switch (accion) {
                case "login":
                    this.login(request, response);
                    break;

                case "register":
                    this.irPaginaRegister(request, response);
                    break;

                case "insert":
                    this.register(request, response);
                    break;

                default:
                    System.out.println("Cargando pagina");
                    this.cargarPagina(request, response);
            }

        } else {
            this.cargarPagina(request, response);
        }
    }

    private void irPaginaRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./register.jsp").forward(request, response);
        return;
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        bd = new ConectorBD();
        boolean estaBD = false;
        if (bd.conectar()) {
            String nombre = request.getParameter("nombre");
            String email = request.getParameter("username");
            String contrasena = request.getParameter("contrasena");
            usuario usuario = new usuario();
            usuario.setUsername(email);
            List<usuario> usuarios = bd.listarUsuario();

            estaBD = usuarios.stream()
                    .anyMatch(us -> us.getUsername().equals(email));
            if (estaBD) {
                request.setAttribute("mensaje", "Email ya ingresado en la base de datos.");
                request.getRequestDispatcher("./register.jsp").forward(request, response);
                return;
            } else {
                if (bd.altaUsuario(nombre, email, contrasena)) {
                    request.getRequestDispatcher("./index.jsp").forward(request, response);
                    return;
                } else {
                    request.setAttribute("mensaje", "No se ha podido conectar con la base de datos.");
                    request.getRequestDispatcher("./register.jsp").forward(request, response);
                    return;
                }
            }

        }

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
