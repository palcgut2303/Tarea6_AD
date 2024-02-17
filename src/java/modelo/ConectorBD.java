/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author javier
 */
public class ConectorBD {

    private final String bd = "tarea6";
    private final String url = "jdbc:mysql://localhost/";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private Connection conn = null;
    private final String login = "root";
    private final String password = "";
    Statement stmt = null;

    public ConectorBD() {
    }

    public Connection getConexion() {
        return conn;
    }

    public boolean conectar() {
        boolean b = false;

        try {
            //Obtenemos el driver de mysql
            Class.forName(driver);
            //Establecemos conexión
            conn = DriverManager.getConnection(url + bd, login, password);

            if (conn != null) {
                System.out.println("Conexión a " + bd + " establecida correctamente.");
                b = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }

    public boolean close() {
        boolean b = false;
        if (this.conn != null) {
            try {
                conn.close();
                conn = null;
                b = true;

                System.out.println("La conexión a la base de datos " + bd + " se ha terminado.");
            } catch (SQLException ex) {
                Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return b;
    }

    public boolean altaMedico(String nombre, float sala,String especialidad,int tarifa) {
        boolean b = false;
        String query;

        query = "INSERT INTO `medico` ( `nombre`,`sala`,`especialidad`,`tarifa`) VALUES "
                + "( '" + nombre + "', '" + sala + "', '"+especialidad+"', '"+tarifa+"')";

        try {
            System.out.println("Conexion: " + conn.getCatalog());
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            b = true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return b;
    }
    
     public boolean altaUsuario(String nombre,String username, String contraseña) {
        boolean b = false;
        String query;

        String contrasenaEncriptada = DigestUtils.sha256Hex(contraseña).substring(0, 40);
        
        query = "INSERT INTO `usuario` ( `nombre`,`usuario`,`clave`) VALUES "
                + "( '" + nombre + "', '" + username + "', '"+contrasenaEncriptada+"')";

        try {
            System.out.println("Conexion: " + conn.getCatalog());
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            b = true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return b;
    }
     
     public boolean comprobarLogin(String email,String contrasena){
          ArrayList<usuario> lista = new ArrayList<>();
          boolean existeUsuarioConMismaContraseña = false;
          try {

            Statement orden = conn.createStatement();
            ResultSet query = orden.executeQuery("select * from usuario");
           
            while (query.next()) {
                usuario a = new usuario(query.getInt("IDUSUARIO"),query.getString("nombre"), query.getString("usuario"), query.getString("clave"));

                lista.add(a);
                
               
            }
            
            String contrasenaEncriptada = DigestUtils.sha256Hex(contrasena).substring(0, 40);;
           
            
            // Verifica si hay algún usuario con la misma contraseña
            existeUsuarioConMismaContraseña = lista.stream()
                .anyMatch(usuario -> usuario.getConstraseña().equals(contrasenaEncriptada));
            
        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
         return existeUsuarioConMismaContraseña;
     }

    public Medicos buscarMedico(String id) {
        Medicos a = null;

        try {
            
            Statement orden = conn.createStatement();
            ResultSet query = orden.executeQuery("select * from medico where id_medico = '" + id + "'");

            if (query.next()) {
                a = new Medicos();
                
                a.setIdMedicos(query.getInt("id_medico"));
                a.setNombre(query.getString("nombre"));
                a.setSala(query.getFloat("sala"));
                a.setEspecialidad(query.getString("especialidad"));
                a.setTarifa(query.getInt("tarifa"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return a;
    }

    public boolean updateMedico(Integer i, String nombre, float sala,String especialidad,int tarifa) {
        boolean b = false;
        String query;

        query = "UPDATE medico SET nombre ='" + nombre + "',sala='" + sala + "',especialidad='"+especialidad+"',tarifa='"+tarifa
                + "' WHERE id_medico ='" + i + "'";

        try {
            System.out.println("Conexion: " + conn.getCatalog());
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            b = true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return b;
    }

    public boolean eliminarMedico(int id) {

        boolean b = false;

        try {
            Statement orden = conn.createStatement();
            orden.executeUpdate("delete from medico where id_medico = '" + id + "'");
            orden.close();
            b = true;
        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }

    public ArrayList<Medicos> listarMedico() {
        ArrayList<Medicos> lista = new ArrayList<>();

        try {

            Statement orden = conn.createStatement();
            ResultSet query = orden.executeQuery("select * from medico");
           
            while (query.next()) {
                Medicos a = new Medicos(query.getInt("id_medico"),query.getString("nombre"), query.getFloat("sala"), query.getInt("tarifa"), query.getString("especialidad"));

                lista.add(a);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
    
    public ArrayList<usuario> listarUsuario() {
        ArrayList<usuario> lista = new ArrayList<>();

        try {

            Statement orden = conn.createStatement();
            ResultSet query = orden.executeQuery("select * from usuario");
           
            while (query.next()) {
                usuario a = new usuario(query.getInt("IDUSUARIO"),query.getString("nombre"), query.getString("usuario"), query.getString("clave"));

                lista.add(a);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

}
