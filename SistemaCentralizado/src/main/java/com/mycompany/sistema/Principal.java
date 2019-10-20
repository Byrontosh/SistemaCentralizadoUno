package com.mycompany.sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) 
    {
        Principal p  = new Principal();
        p.insertar();
        //p.actualizar(1, "PERA", 33.15);
        //p.eliminar(1);

    }

    public Connection getConexion() {

        Connection conexion = null;
        String servidor = "localhost";
        String puerto = "5432";
        String baseDatos = "supermercado";
        String url = "jdbc:postgresql://" + servidor + ":" + puerto + "/" + baseDatos;
        String usuario = "postgres";
        String clave = "admin";
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conexion;

    }

    public void insertar() {

        Connection conexion = getConexion();
        String sql = "INSERT INTO producto (codigo,nombre,precio) VALUES (1,'ACEITE',12.56)";
        //String sql = "insert into producto values (" + codigo + ",'" + nombre + "','" + precio + "')";
        try (Statement st = conexion.createStatement()) {
            //EL executeUpdate ES LA EJECUCIÓN DE LA SENTENCIA
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
     public void actualizar(int codigo, String nombre, double precio) {
        Connection conexion = getConexion();
        String sql = 
		"UPDATE producto SET " + "nombre='" + nombre + "'" + ",precio=" + precio + "WHERE codigo=" + codigo;
        try (Statement st = conexion.createStatement()) {
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void eliminar(int codigo) {
        Connection conexion = getConexion();
        String sql = "DELETE FROM producto WHERE codigo = " + codigo;
        try (Statement st = conexion.createStatement()) {
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    

}
