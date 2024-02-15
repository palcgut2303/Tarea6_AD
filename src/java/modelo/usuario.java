/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author manana
 */
public class usuario {
    
    private int idUsuario;
    private String nombre;
    private String username;
    private String constraseña;

    public usuario() {
    }

    

    public usuario(int idUsuario, String nombre, String username, String constraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.username = username;
        this.constraseña = constraseña;
    }

    public usuario(String nombre, String username, String constraseña) {
        this.nombre = nombre;
        this.username = username;
        this.constraseña = constraseña;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getConstraseña() {
        return constraseña;
    }

    public void setConstraseña(String constraseña) {
        this.constraseña = constraseña;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
