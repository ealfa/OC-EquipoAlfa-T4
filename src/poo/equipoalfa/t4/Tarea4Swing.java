/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.equipoalfa.t4;

import javax.swing.JOptionPane;

/**
 *
 * @author jesus_ignacio_159
 */
public class Tarea4Swing {
    /*
     int numeroDeClientes;
     int numeroDeRegistroDeCompras;
     int numeroDePagos;
     */

    //Nombre, email, telefono, idtarjeta, ticket, cantidad/saldo

    public static void mostrar() {
        boolean run = true;

        while (run) {
            String[] menu = new String[2];
            String[] movimientos = new String[3];
            String[][] altaDeClientes = new String[6][100];
            /*
             String[][] altaDeClientes = new String[4][100];
             String[][] registroDeCompras = new String[3][100];
             String[][] pagos = new String[2][100];
             String[][] consultaDeSaldo = new String[1][100];
             */

            menu[0] = "Clientes";
            menu[1] = "Movimientos";

            movimientos[0] = "Registro De Compras";
            movimientos[1] = "Pagos";
            movimientos[2] = "Consulta De Saldo";

            //JOptionPane.showInputDialog(null, null, null, JOptionPane.PLAIN_MESSAGE, null, selectionValues, null);
            String seleccion = (String) JOptionPane.showInputDialog(null, null, null, JOptionPane.PLAIN_MESSAGE, null, menu, null);
            if ("Clientes".equals(seleccion)) {
                int respuesta = JOptionPane.showConfirmDialog(null, "Alta De Cliente", "Alta De Cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

                /*if (respuesta == 1) {*/
                String nombreDeCliente = JOptionPane.showInputDialog(null, null, "Nombre Cliente", JOptionPane.PLAIN_MESSAGE);
                String email = JOptionPane.showInputDialog(null, null, "Email", JOptionPane.PLAIN_MESSAGE);
                String telefono = JOptionPane.showInputDialog(null, null, "Teléfono", JOptionPane.PLAIN_MESSAGE);
                String idTarjeta = JOptionPane.showInputDialog(null, null, "idTarjeta", JOptionPane.PLAIN_MESSAGE);

                for (int i = 0; i < 100; i++) {
                    if (altaDeClientes[0][i] == null) {
                        altaDeClientes[0][i] = nombreDeCliente;
                        altaDeClientes[1][i] = email;
                        altaDeClientes[2][i] = telefono;
                        altaDeClientes[3][i] = idTarjeta;
                    }
                }
                /*} else {
                 run = false;
                 }*/
            } else if ("Movimientos".equals(seleccion)) {
                String seleccion1 = (String) JOptionPane.showInputDialog(null, null, null, JOptionPane.PLAIN_MESSAGE, null, movimientos, null);
                if ("Registro De Compras".equals(seleccion1)) {
                    String idTarjeta = JOptionPane.showInputDialog(null, null, "IdTarjeta", JOptionPane.PLAIN_MESSAGE);
                    boolean idTarjetaB = false;
                    for (int i = 0; i < 100; i++) {
                        if (altaDeClientes[3][i] == idTarjeta) {
                            altaDeClientes[4][i] = JOptionPane.showInputDialog(null, null, "Ticket", JOptionPane.PLAIN_MESSAGE);
                            altaDeClientes[5][i] = JOptionPane.showInputDialog(null, null, "Cantidad", JOptionPane.PLAIN_MESSAGE);
                            idTarjetaB = true;
                        }
                    }
                    if (!idTarjetaB) {
                        JOptionPane.showConfirmDialog(null, "La Id de Tarjeta no se encuentra en la base de datos.", "IdTarjeta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                    }
                    
                } else if ("Pagos".equals(seleccion1)) {
                    for (int i = 0; i < 100; i++) {
                        if (altaDeClientes[3][i] == JOptionPane.showInputDialog(null, null, "IdTarjeta", JOptionPane.PLAIN_MESSAGE)) {
                            altaDeClientes[5][i] += JOptionPane.showInputDialog(null, null, "Cantidad", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            JOptionPane.showConfirmDialog(null, "La Id de Tarjeta no se encuentra en la base de datos.", "IdTarjeta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                        }
                    }
                } else if ("Consulta De Saldo".equals(seleccion1)) {
                    for (int i = 0; i < 100; i++) {
                        if (altaDeClientes[3][i] == JOptionPane.showInputDialog(null, null, "idTarjeta", JOptionPane.PLAIN_MESSAGE)) {
                            JOptionPane.showConfirmDialog(null, "Nombre Cliente: " + altaDeClientes[0][i], "Nombre Cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                            JOptionPane.showConfirmDialog(null, "Saldo:" + altaDeClientes[5][i], "Saldo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                        } else {
                            JOptionPane.showConfirmDialog(null, "La Id de Tarjeta no se encuentra en la base de datos.", "IdTarjeta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                        }
                    }
                } else if (seleccion1 == null) {
                    run = false;
                }
            } else if (seleccion == null) {
                run = false;
            }
        }
    }
}
