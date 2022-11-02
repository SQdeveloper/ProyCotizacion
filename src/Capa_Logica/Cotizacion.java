/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author PC
 */
public class Cotizacion {
 
    String consulta;
    String Producto, cantidad, precioUnitario, interes, precioFinal;

    public Cotizacion() {
        
    }
    public void consulta(Statement sentencia){
        String nombre;
        consulta = JOptionPane.showInputDialog("Ingrese");
        nombre = consulta;
        try{
            ResultSet r = sentencia.executeQuery("Select nombre,apellido from personas where nombre='" + nombre + "'");
            if(r.next()){
                System.out.println(r.getString("nombre") + r.getString("apellido"));
            }
            //System.out.println(r.getString("nombre"));
        }    
        catch(SQLException e){
        JOptionPane.showMessageDialog(null, "error" + e.getMessage());
        }
    }

    public Cotizacion(String Producto, String cantidad, String precioUnitario, String interes, String precioFinal) {
        this.Producto = Producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.interes = interes;
        this.precioFinal = precioFinal;
    }

    //METODOS GETTER Y SETTER
    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecio(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }
    public String getPrecioFinal(){
        return precioFinal;
    }
    public void setPrecioFinal(String precioFinal){
        this.precioFinal = precioFinal;
    }
    //OTROS METODOS
    
    
    public void Escritura_BD(Cotizacion c1, Statement sentencia){
        try {
         int resu= sentencia.executeUpdate("insert into Compras(Productos, Cantidad, PrecioUnitario, PrecioFinal) "
                 + "values('"+c1.Producto+"','"+ (c1.cantidad) + "','"+ c1.precioUnitario +"','"+c1.precioFinal+"')");
            if (resu==1) {
                JOptionPane.showMessageDialog(null, "Compra realizada correctamente.");
            }else{
                System.out.println("error");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void Lectura_BD(ArrayList<Cotizacion> lista, Statement sentencia){
        String producto, cantidad, precioUnitario, precioFinal;
        
        try {
            ResultSet r= sentencia.executeQuery("select Productos , Cantidad, PrecioUnitario, PrecioFinal from Compras");
            while (r.next()) {
                Cotizacion t = new Cotizacion();
                t.setProducto(r.getString(1));
                t.setCantidad(r.getString(2));
                t.setPrecio(r.getString(3));
                t.setPrecioFinal(r.getString(4));
                lista.add(t);
            }  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}

