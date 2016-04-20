/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.equipoalfa.t4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesus_ignacio_159
 */
public class Ventana1 extends JFrame implements ActionListener {

    JMenuItem cmdAbrir, cmdCerrar, cmdSalir, cmdCopiar, cmdPegar;
    JTextField cmdNombreDeCliente, cmdEmail, cmdTelefono, cmdIdTarjeta;
    JButton cmdAceptar, cmdCancelar, cmdVolverAlMenu;
    JMenu menuArchivo, menuEdicion;
    JMenuBar braMenu;

    //Constructor
    public Ventana1() {
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
        
        cmdNombreDeCliente = new JTextField("Nombre Cliente");
        cmdEmail = new JTextField("Email");
        cmdTelefono = new JTextField("Telefono");
        cmdIdTarjeta = new JTextField("IdTarjeta");
        
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

        add(cmdNombreDeCliente);
        add(cmdEmail);
        add(cmdTelefono);
        add(cmdIdTarjeta);
        
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
            JOptionPane.showMessageDialog(null, "Introdujiste los datos y se escribiran en un archivo.");
            String nombreDeCliente = cmdNombreDeCliente.getText();
            String email = cmdEmail.getText();
            String telefono = cmdTelefono.getText();
            String idTarjeta = cmdIdTarjeta.getText();

            if (!((nombreDeCliente == "" || email == "" || telefono == "" || idTarjeta == ""))) {
                try {
                    writeToFile(nombreDeCliente);
                } catch (IOException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }

                for (int i = 0; i < 100; i++) {
                    if (MonederoElectronico.clientes[0][i] == "") {
                        MonederoElectronico.clientes[0][i] = nombreDeCliente;
                        MonederoElectronico.clientes[1][i] = email;
                        MonederoElectronico.clientes[2][i] = telefono;
                        MonederoElectronico.clientes[3][i] = idTarjeta;
                        return;
                    }
                }
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

    private void readFile() {
        File f = new File("E:\\AltaDeCliente-" + cmdNombreDeCliente.getText() + ".txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                System.out.println(br.readLine());
            }
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
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesus_ignacio_159
 */
/*public class Ventana1 extends JFrame implements ActionListener {

    JMenuItem cmdAbrir, cmdCerrar, cmdSalir, cmdCopiar, cmdPegar;
    JTextField cmdNombreDeCliente, cmdEmail, cmdTelefono, cmdIdTarjeta;
    JButton cmdAceptar, cmdCancelar, cmdVolverAlMenu;
    JMenu menuArchivo, menuEdicion;
    JMenuBar braMenu;

    //Constructor
    public Ventana1() {
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

        cmdNombreDeCliente = new JTextField("Nombre Cliente");
        cmdEmail = new JTextField("Email");
        cmdTelefono = new JTextField("Telefono");
        cmdIdTarjeta = new JTextField("IdTarjeta");

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

        add(cmdNombreDeCliente);
        add(cmdEmail);
        add(cmdTelefono);
        add(cmdIdTarjeta);

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
            JOptionPane.showMessageDialog(null, "Introdujiste los datos y se escribiran en un archivo.");
            String nombreDeCliente = cmdNombreDeCliente.getText();
            String email = cmdEmail.getText();
            String telefono = cmdTelefono.getText();
            String idTarjeta = cmdIdTarjeta.getText();

            if (!(("".equals(nombreDeCliente) || "".equals(email) || "".equals(telefono) || "".equals(idTarjeta)))) {
                for (int i = 0; i < 100; i++) {
                    if ("".equals(MonederoElectronico.clientes[0][i])) {
                        MonederoElectronico.clientes[0][i] = nombreDeCliente;
                        MonederoElectronico.clientes[1][i] = email;
                        MonederoElectronico.clientes[2][i] = telefono;
                        MonederoElectronico.clientes[3][i] = idTarjeta;
                    }
                }
                /*
                 try {
                 writeToFile(nombreDeCliente, email, telefono, idTarjeta);
                 } catch (IOException ex) {
                 Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                 }

                 for (int i = 0; i < 100; i++) {
                 if (MonederoElectronico.clientes[0][i] == "") {
                 MonederoElectronico.clientes[0][i] = nombreDeCliente;
                 MonederoElectronico.clientes[1][i] = email;
                 MonederoElectronico.clientes[2][i] = telefono;
                 MonederoElectronico.clientes[3][i] = idTarjeta;
                 return;
                 }
                 }*/
                /*guardarArchivo(nombreDeCliente, email, telefono, idTarjeta);*/
            /*} else {
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

    private void readFile() {
        File f = new File("E:\\AltaDeCliente-" + cmdNombreDeCliente.getText() + ".txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
/*
    private void guardarArchivo(String nombreDeCliente, String email, String telefono, String idTarjeta) {
        for (int i = 0; i < 100; i++) {
            if (MonederoElectronico.archivo[i] == null) {
                try {
                    MonederoElectronico.archivo[i] = writeToFile(nombreDeCliente, email, telefono, idTarjeta);
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private File writeToFile(String nombreDeCliente, String email, String telefono, String idTarjeta) throws IOException {
        File f = new File("E:\\AltaDeCliente-" + cmdIdTarjeta.getText() + ".txt");
        System.out.println(f);
        FileWriter fw = new FileWriter(f, true);
        System.out.println(fw);
        try {
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                System.out.println(bw);
                bw.write(nombreDeCliente);
                bw.newLine();
                bw.write(email);
                bw.newLine();
                bw.write(telefono);
                bw.newLine();
                bw.write(idTarjeta);
                bw.newLine();
                bw.write("");
                bw.newLine();
                bw.write("0");
                bw.newLine();
                bw.write("E:\\AltaDeCliente-" + cmdIdTarjeta.getText() + ".txt");
                bw.flush();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    }
    /*
     private void readFile() {
     File f = new File("E:\\AltaDeCliente-" + cmdIdTarjeta.getText() + ".txt");
     try {
     FileReader fr = new FileReader(f);
     BufferedReader br = new BufferedReader(fr);
     while (br.ready()) {
     System.out.println(br.readLine());
     }
     } catch (Exception e) {
     System.out.println(e);
     }
     }
     */
/*}*/
