/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.equipoalfa.t4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesus_ignacio_159
 */
public class Ventana2 extends JFrame implements ActionListener {

    JMenuItem cmdAbrir, cmdCerrar, cmdSalir, cmdCopiar, cmdPegar;
    JTextField cmdIdTarjeta, cmdTicket, cmdCantidad;
    JButton cmdAceptar, cmdCancelar, cmdVolverAlMenu;
    JMenu menuArchivo, menuEdicion;
    JMenuBar braMenu;

    //Constructor
    public Ventana2() {
        //Establecemos el título de la ventana.
        super("Ventana con menú");
        //Establecemos la ubicación en la pantalla y las dimenciones de la ventana
        setBounds(200, 200, 800, 500); //x,y,ancho,alto
        //Programamos la X para cerrar la ventana.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new FlowLayout());
        
        //Paso 1. Crear los JMenuItems
        cmdAbrir = new JMenuItem("Abrir");
        cmdCerrar = new JMenuItem("Cerrar");
        cmdSalir = new JMenuItem("Salir");
        cmdCopiar = new JMenuItem("Copiar");
        cmdPegar = new JMenuItem("Pegar");

        cmdIdTarjeta = new JTextField("Id de Tarjeta");
        cmdTicket = new JTextField("Ticket");
        cmdCantidad = new JTextField("Cantidad");
        
        cmdAceptar = new JButton("Aceptar");
        cmdCancelar = new JButton("Cancelar");
        cmdVolverAlMenu = new JButton("Volver al Menú");

        //Paso 2. Creamos los JMenus
        menuArchivo = new JMenu("Archivo");
        menuEdicion = new JMenu("Edicion");
        //Paso 3. Creamos la Barra JMenuBar
        braMenu = new JMenuBar();
        //Paso 4. Agregar los items a los menus
        menuArchivo.add(cmdAbrir);
        menuArchivo.add(cmdCerrar);
        menuArchivo.add(cmdSalir);
        menuEdicion.add(cmdCopiar);
        menuEdicion.add(cmdPegar);

        add(cmdIdTarjeta);
        add(cmdTicket);
        add(cmdCantidad);
        
        add(cmdAceptar);
        add(cmdCancelar);
        add(cmdVolverAlMenu);

        //Paso 5. Agregar los menus a la barra
        braMenu.add(menuArchivo);
        braMenu.add(menuEdicion);
        setJMenuBar(braMenu);
        setVisible(true);

        //Paso 6. Que los comandos ESCUCHEN
        cmdAbrir.addActionListener(this);
        cmdCerrar.addActionListener(this);
        cmdSalir.addActionListener(this);
        cmdCopiar.addActionListener(this);
        cmdPegar.addActionListener(this);
        
        cmdAceptar.addActionListener(this);
        cmdCancelar.addActionListener(this);
        cmdVolverAlMenu.addActionListener(this);
    }

    private void salir() {
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cmdAbrir) {
            JOptionPane.showMessageDialog(null, "Presionaste Abrir");
        } else if (e.getSource() == cmdCerrar) {
            JOptionPane.showMessageDialog(null, "Presionaste Cerrar");
        } else if (e.getSource() == cmdSalir) {
            salir();
        } else if (e.getSource() == cmdCopiar) {
            JOptionPane.showMessageDialog(null, "Presionaste Copiar");
        } else if (e.getSource() == cmdPegar) {
            JOptionPane.showMessageDialog(null, "Presionaste Pegar");
        } else if (e.getSource() == cmdVolverAlMenu) {
            JOptionPane.showMessageDialog(null, "Presionaste Volver al Menú");
            Menu menu = new Menu();
        } else if (e.getSource() == cmdCancelar) {
            salir();
        } else if (e.getSource() == cmdAceptar) {
            JOptionPane.showMessageDialog(null, "Introdujiste los Datos");
            String idTarjeta = cmdIdTarjeta.getText();
            String ticket = cmdTicket.getText();
            String cantidad = cmdCantidad.getText();
            if (!(idTarjeta == "" || ticket == "" || cantidad == "")) {

                try {
                    writeToFile(idTarjeta);
                } catch (IOException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }

                for (int i = 0; i < 100; i++) {
                    if (MonederoElectronico.clientes[3][i] == null ? idTarjeta == null : MonederoElectronico.clientes[3][i].equals(idTarjeta)) {

                        MonederoElectronico.clientes[4][i] = ticket;
                        
                        if (!(Integer.parseInt(cantidad) > Integer.parseInt(MonederoElectronico.clientes[5][i]))) {
                            int saldo = Integer.parseInt(MonederoElectronico.clientes[5][i]) - Integer.parseInt(cantidad);
                            MonederoElectronico.clientes[5][i] = Integer.toString(saldo);
                        } else {
                            JOptionPane.showConfirmDialog(null, "El cliente no tiene suficiente saldo para realizar la compra.");
                        }
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "El Id de la Tajeta del Cliente no se encuentra en nuestra base de datos. De favor introduzcala nuevamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Al menos uno de los cuadros de texto no estan completos. Por favor complete los datos y vuelva a introducir los datos.");
            }
        }
    }

    private void writeToFile(String list) throws IOException {
        File f = new File("E:\\AltaDeCliente-" + cmdIdTarjeta.getText() + ".txt");
        System.out.println(f);
        FileWriter fw = new FileWriter(f, true);
        System.out.println(fw);
        try {
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println(bw);
            bw.newLine();
            bw.write(list);
            bw.flush();
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package poo.equipoalfa.t4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author jesus_ignacio_159
 */
/*public class Ventana2 extends JFrame implements ActionListener {

    JMenuItem cmdAbrir, cmdCerrar, cmdSalir, cmdCopiar, cmdPegar;
    JTextField cmdIdTarjeta, cmdTicket, cmdCantidad;
    JButton cmdAceptar, cmdCancelar, cmdVolverAlMenu;
    JMenu menuArchivo, menuEdicion;
    JMenuBar braMenu;

    //Constructor
    public Ventana2() {
        //Establecemos el título de la ventana.
        super("Ventana con menú");
        //Establecemos la ubicación en la pantalla y las dimenciones de la ventana
        setBounds(200, 200, 800, 500); //x,y,ancho,alto
        //Programamos la X para cerrar la ventana.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        //Paso 1. Crear los JMenuItems
        cmdAbrir = new JMenuItem("Abrir");
        cmdCerrar = new JMenuItem("Cerrar");
        cmdSalir = new JMenuItem("Salir");
        cmdCopiar = new JMenuItem("Copiar");
        cmdPegar = new JMenuItem("Pegar");

        cmdIdTarjeta = new JTextField("Id de Tarjeta");
        cmdTicket = new JTextField("Ticket");
        cmdCantidad = new JTextField("Cantidad");

        cmdAceptar = new JButton("Aceptar");
        cmdCancelar = new JButton("Cancelar");
        cmdVolverAlMenu = new JButton("Volver al Menú");

        //Paso 2. Creamos los JMenus
        menuArchivo = new JMenu("Archivo");
        menuEdicion = new JMenu("Edicion");
        //Paso 3. Creamos la Barra JMenuBar
        braMenu = new JMenuBar();
        //Paso 4. Agregar los items a los menus
        menuArchivo.add(cmdAbrir);
        menuArchivo.add(cmdCerrar);
        menuArchivo.add(cmdSalir);
        menuEdicion.add(cmdCopiar);
        menuEdicion.add(cmdPegar);

        add(cmdIdTarjeta);
        add(cmdTicket);
        add(cmdCantidad);

        add(cmdAceptar);
        add(cmdCancelar);
        add(cmdVolverAlMenu);

        //Paso 5. Agregar los menus a la barra
        braMenu.add(menuArchivo);
        braMenu.add(menuEdicion);
        setJMenuBar(braMenu);
        setVisible(true);

        //Paso 6. Que los comandos ESCUCHEN
        cmdAbrir.addActionListener(this);
        cmdCerrar.addActionListener(this);
        cmdSalir.addActionListener(this);
        cmdCopiar.addActionListener(this);
        cmdPegar.addActionListener(this);

        cmdAceptar.addActionListener(this);
        cmdCancelar.addActionListener(this);
        cmdVolverAlMenu.addActionListener(this);
    }

    private void salir() {
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cmdAbrir) {
            JOptionPane.showMessageDialog(null, "Presionaste Abrir");
        } else if (e.getSource() == cmdCerrar) {
            JOptionPane.showMessageDialog(null, "Presionaste Cerrar");
        } else if (e.getSource() == cmdSalir) {
            salir();
        } else if (e.getSource() == cmdCopiar) {
            JOptionPane.showMessageDialog(null, "Presionaste Copiar");
        } else if (e.getSource() == cmdPegar) {
            JOptionPane.showMessageDialog(null, "Presionaste Pegar");
        } else if (e.getSource() == cmdVolverAlMenu) {
            JOptionPane.showMessageDialog(null, "Presionaste Volver al Menú");
            Menu menu = new Menu();
        } else if (e.getSource() == cmdCancelar) {
            salir();
        } else if (e.getSource() == cmdAceptar) {
            JOptionPane.showMessageDialog(null, "Introdujiste los Datos");
            String idTarjeta = cmdIdTarjeta.getText();
            String ticket = cmdTicket.getText();
            String cantidad = cmdCantidad.getText();
            if (!("".equals(idTarjeta) || "".equals(ticket) || "".equals(cantidad))) {
                try {
                    writeToFile(idTarjeta, ticket, cantidad);
                } catch (IOException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i < 100; i++) {
                    if (MonederoElectronico.clientes[3][i] == null ? idTarjeta == null : MonederoElectronico.clientes[3][i].equals(idTarjeta)) {
                        MonederoElectronico.clientes[4][i] = ticket;
                        if (!(Integer.parseInt(cantidad) > Integer.parseInt(MonederoElectronico.clientes[5][i]))) {
                            int saldo = Integer.parseInt(MonederoElectronico.clientes[5][i]) - Integer.parseInt(cantidad);
                            MonederoElectronico.clientes[5][i] = Integer.toString(saldo);
                        } else {
                            JOptionPane.showConfirmDialog(null, "El cliente no tiene suficiente saldo para realizar la compra.");
                        }
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "El Id de la Tajeta del Cliente no se encuentra en nuestra base de datos. De favor introduzcala nuevamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Al menos uno de los cuadros de texto no estan completos. Por favor complete los datos y vuelva a introducir los datos.");
            }
        }
    }

    private String[] readFile(String idTarjeta, String ticket, String cantidad) throws FileNotFoundException, IOException {
        File archivo;
        archivo = null;
        String[] linesS = new String[7];
        for (int i = 0; i < 100; i++) {
            archivo = MonederoElectronico.archivo[i];
            if (archivo != null) {
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                while (br.ready()) {
                    Stream<String> lines = br.lines();
                    Object[] linesO = lines.toArray();
                    for (int j = 0; j < 7; j++) {
                        linesS[j] = linesO[j].toString();
                    }
                }
                if (linesS[3] == null ? idTarjeta == null : linesS[3].equals(idTarjeta)) {
                    linesS[4] = ticket;
                    linesS[5] = cantidad;
                    return linesS;
                }
            }
        }
        return linesS;
    }

    private File writeToFile(String idTarjeta, String ticket, String cantidad) throws IOException {
        File archivo = null;
        String[] linesS;
        linesS = new String[7];

        linesS = readFile(idTarjeta, ticket, cantidad);

        for (int i = 0; i < 100; i++) {
            archivo = MonederoElectronico.archivo[i];
            if (archivo != null) {
                if (archivo.getAbsolutePath() == null ? linesS[6] == null : archivo.getAbsolutePath().equals(linesS[6])) {
                    System.out.println(archivo);
                    FileWriter fw = new FileWriter(archivo, true);
                    System.out.println(fw);
                    try {
                        try (BufferedWriter bw = new BufferedWriter(fw)) {
                            System.out.println(bw);
                            bw.newLine();
                            bw.newLine();
                            bw.newLine();
                            bw.newLine();
                            bw.write(ticket);
                            bw.newLine();
                            if (Integer.parseInt(cantidad) <= Integer.parseInt(linesS[5])) {
                                int saldo = Integer.parseInt(linesS[5]) - Integer.parseInt(cantidad);
                                String saldoS = Integer.toString(saldo);
                                bw.write(saldoS);
                            } else {
                                JOptionPane.showConfirmDialog(null, "El cliente no tiene suficiente saldo para realizar la compra.");
                            }
                            bw.newLine();
                            bw.flush();
                        }
                    } catch (IOException | NumberFormatException | HeadlessException e) {
                        System.out.println(e);
                    }
                }
            }
        }
        return archivo;
    }
}
*/