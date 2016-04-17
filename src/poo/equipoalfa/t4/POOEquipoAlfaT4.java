/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.equipoalfa.t4;
/**
 *
 * @author jesus_ignacio_159
 */
public class POOEquipoAlfaT4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Monedero Electronico
        MonederoElectronico monederoElectronico = new MonederoElectronico(1);
        Cliente cliente = new Cliente();
        Bitacora bitacora = new Bitacora();
        Transferencia transferencia = new Transferencia();
        
        //Swing
        Menu menu = new Menu();
    }
}
