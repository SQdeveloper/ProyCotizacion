/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author PC
 */
public class ConexionBD {
    private String bd;
    private Connection cn;
    private Statement st;
    private ResultSet rs;

    public ConexionBD(String bd){
        try{
            String DSN = "jdbc:ucanaccess://Base//" + bd + ".accdb";
            String user= "";
            String clave = "";
            cn = DriverManager.getConnection(DSN, user, clave);
            st= cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            JOptionPane.showMessageDialog(null, "Conexion establecida correctamente.");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al intentar conectarse con la base de datos." + e.getMessage());
        }
    }

    //METODOS GET Y SET
    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    
}