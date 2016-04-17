/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.equipoalfa.t4;
import java.util.*;

/**
 *
 * @author 
 */
public class Cliente {
    //Atributos
    protected int id_cliente;
    protected String Nombre;
    protected String email;
    protected Bitacora bitacora;
    protected MonederoElectronico MonederoElectronico;
    protected String CincoMovimientos;
    protected String descripcion;
    
    public Cliente (){
        
    }
    
    //Constructor
    public Cliente (int id_cliente, String Nombre){
    this.id_cliente=id_cliente;
    this.Nombre=Nombre;
    }
    public Cliente (int id_cliente, String Nombre, String email){
    this.id_cliente=id_cliente;
    this.Nombre=Nombre;
    this.email=email;
    }
    public Cliente (int id_cliente, String Nombre, String email, MonederoElectronico MonederoElectronico){
    this.id_cliente=id_cliente;
    this.Nombre=Nombre;
    this.email=email; 
    this.MonederoElectronico= MonederoElectronico;
    }
    
    public void mostrarUlltimos5Movimientos (List listaDeTransferencias){
      for(int i=0;i<4;i++){
    System.out.println(listaDeTransferencias.get(i));
} 
        }
    
    public void mostrarTodosLosMovimientos (List listaDeTransferencias){
      for(int i=0;i<listaDeTransferencias.size();i++){
    System.out.println(listaDeTransferencias.get(i));
} 
        }
    public Bitacora getBitacora(){
        return this.bitacora;
    }
    public int getIDCliente(){
        return this.id_cliente;
    }
    public String getNombre(){
        return this.Nombre;
    }
    public String getEmail(){
        return this.email;
    }
    public String descripcionCliente(){
        descripcion = (" "+this.id_cliente+" "+this.Nombre+" "+this.email);
        return descripcion;
    }
}
