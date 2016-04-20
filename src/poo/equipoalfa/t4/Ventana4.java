/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.equipoalfa.t4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author jesus_ignacio_159
 */
public class Ventana4 extends JFrame implements ActionListener {

    JMenuItem cmdAbrir, cmdCerrar, cmdSalir, cmdCopiar, cmdPegar;
    JTextField cmdIdTarjeta;
    JButton cmdAceptar, cmdCancelar;
    JMenu menuArchivo, menuEdicion;
    JMenuBar braMenu;

    //Constructor
    public Ventana4() {
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
        
        cmdAceptar = new JButton("Aceptar");
        cmdCancelar = new JButton("Cancelar");

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
        
        add(cmdAceptar);
        add(cmdCancelar);

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
        } else if (e.getSource() == cmdCancelar) {
            salir();
        } else if (e.getSource() == cmdAceptar) {
            JOptionPane.showMessageDialog(null, "Introdujistre los Datos");
            String idTarjeta = cmdIdTarjeta.getText();
            if (! ("".equals(idTarjeta))) {
                readFile(idTarjeta);
                for (int i = 0; i < 100; i++) {
                    if (idTarjeta == null ? MonederoElectronico.clientes[3][i] == null : idTarjeta.equals(MonederoElectronico.clientes[3][i])) {
                        JOptionPane.showMessageDialog(null, "Nombre Del Cliente: " + MonederoElectronico.clientes[0][i]);
                        JOptionPane.showMessageDialog(null, "Saldo: " + MonederoElectronico.clientes[5][i]);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "El Id de la Tajeta del Cliente no se encuentra en nuestra base de datos. De favor introduzcala nuevamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Al menos uno de los cuadros de texto no estan completos. Por favor complete los datos y vuelva a introducir los datos.");
            }
        }
    }

    private String readFile(String nombreCliente) {
        File f = new File("E:\\AltaDeCliente-" + nombreCliente + ".txt");
        String nombreDeCliente = "";
        String saldo = "";
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                System.out.println(br.readLine());
                if (br.readLine().contains("Nombre De Cliente: ")) {
                    nombreDeCliente += br.readLine();
                } else if (br.readLine().contains("Saldo: ")) {
                    saldo += br.readLine();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return nombreDeCliente + saldo;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author jesus_ignacio_159
 */

/*public class Ventana4 extends JFrame implements ActionListener {

    JMenuItem cmdAbrir, cmdCerrar, cmdSalir, cmdCopiar, cmdPegar;
    JTextField cmdIdTarjeta;
    JButton cmdAceptar, cmdCancelar;
    JMenu menuArchivo, menuEdicion;
    JMenuBar braMenu;

    //Constructor
    public Ventana4() {
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

        cmdAceptar = new JButton("Aceptar");
        cmdCancelar = new JButton("Cancelar");

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

        add(cmdAceptar);
        add(cmdCancelar);

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
        } else if (e.getSource() == cmdCancelar) {
            salir();
        } else if (e.getSource() == cmdAceptar) {
            JOptionPane.showMessageDialog(null, "Introdujistre los Datos");
            String idTarjeta = cmdIdTarjeta.getText();
            if (! ("".equals(idTarjeta))) {
                readFile(idTarjeta);
                for (int i = 0; i < 100; i++) {
                    if (idTarjeta == null ? MonederoElectronico.clientes[3][i] == null : idTarjeta.equals(MonederoElectronico.clientes[3][i])) {
                        JOptionPane.showMessageDialog(null, "Nombre Del Cliente: " + MonederoElectronico.clientes[0][i]);
                        JOptionPane.showMessageDialog(null, "Saldo: " + MonederoElectronico.clientes[5][i]);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "El Id de la Tajeta del Cliente no se encuentra en nuestra base de datos. De favor introduzcala nuevamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Al menos uno de los cuadros de texto no estan completos. Por favor complete los datos y vuelva a introducir los datos.");
            }
        }
            /*JOptionPane.showMessageDialog(null, "Introdujistre los Datos");
            /*
            String idTarjeta = cmdIdTarjeta.getText();
            String nombreDeCliente = "";
            String saldo = "";
            if (!("".equals(idTarjeta))) {
                String[] lineas = null;
                try {
                    lineas = readFile(idTarjeta);
                } catch (IOException ex) {
                    Logger.getLogger(Ventana4.class.getName()).log(Level.SEVERE, null, ex);
                }
                imprimirArchivo(lineas, nombreDeCliente, saldo, idTarjeta);
                for (int i = 0; i < 100; i++) {
                    if (idTarjeta == null ? MonederoElectronico.clientes[3][i] == null : idTarjeta.equals(MonederoElectronico.clientes[3][i])) {
                        JOptionPane.showMessageDialog(null, "Nombre Del Cliente: " + MonederoElectronico.clientes[0][i]);
                        JOptionPane.showMessageDialog(null, "Saldo: " + MonederoElectronico.clientes[5][i]);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "El Id de la Tajeta del Cliente no se encuentra en nuestra base de datos. De favor introduzcala nuevamente.");
                JOptionPane.showMessageDialog(null, "Introdujistre los Datos");
                */
            /*String idTarjeta = cmdIdTarjeta.getText();
            if (! ("".equals(idTarjeta))) {
                for (int i = 0; i < 100; i++) {
                    if (idTarjeta == null ? MonederoElectronico.clientes[3][i] == null : idTarjeta.equals(MonederoElectronico.clientes[3][i])) {
                        JOptionPane.showMessageDialog(null, "Nombre Del Cliente: " + MonederoElectronico.clientes[0][i]);
                        JOptionPane.showMessageDialog(null, "Saldo: " + MonederoElectronico.clientes[5][i]);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "El Id de la Tajeta del Cliente no se encuentra en nuestra base de datos. De favor introduzcala nuevamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Al menos uno de los cuadros de texto no estan completos. Por favor complete los datos y vuelva a introducir los datos.");
            }/*
        }
            } else {
                JOptionPane.showMessageDialog(null, "Al menos uno de los cuadros de texto no estan completos. Por favor complete los datos y vuelva a introducir los datos.");
            }*/
    /*    }

    private String readFile(String nombreCliente) {
        File f = new File("E:\\AltaDeCliente-" + nombreCliente + ".txt");
        String nombreDeCliente = "";
        String saldo = "";
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                System.out.println(br.readLine());
                if (br.readLine().contains("Nombre De Cliente: ")) {
                    nombreDeCliente += br.readLine();
                } else if (br.readLine().contains("Saldo: ")) {
                    saldo += br.readLine();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return nombreDeCliente + saldo;
    }
    
    private void imprimirArchivo(String[] lineas, String nombreDeCliente, String saldo, String idTarjeta) {
        if (lineas != null) {
                    nombreDeCliente = lineas[0];
                    saldo = lineas[5];
                    if (lineas[3] == null ? idTarjeta == null : lineas[3].equals(idTarjeta)) {
                        JOptionPane.showMessageDialog(null, "Nombre Del Cliente: " + lineas[6]);
                        JOptionPane.showMessageDialog(null, "Saldo: " + lineas[1]);
                        return;
                    }
                }
    }
/*
    private String[] readFile(String idTarjeta) throws FileNotFoundException, IOException {
        String[] linesS = new String[7];
        for (int i = 0; i < 100; i++) {
            File archivo = MonederoElectronico.archivo[i];
            if (archivo != null) {
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                while (br.ready()) {
                    Stream<String> lines = br.lines();
                    Object[] linesO = lines.toArray();
                    for (int j = 0; j < 7; j++) {
                        linesS[j] = linesO[j].toString();
                    }
                    if (linesS[3] == null ? idTarjeta == null : linesS[3].equals(idTarjeta)) {
                        return linesS;
                    }
                }
            }
        }
        /*File f = new File("E:\\AltaDeCliente-" + idTarjeta + ".txt");
         String[] linesS = new String[6];
         /*String nombreDeCliente = "";
         String saldo = "";*/
        /*try {
         FileReader fr = new FileReader(f);
         BufferedReader br = new BufferedReader(fr);
         while (br.ready()) {
         Stream<String> lines = br.lines();
         Object[] linesO = lines.toArray();
         for (int i = 0; i < 6; i++) {
         linesS[i] = linesO[i].toString();
         }
         return linesS;
         /*
         System.out.println(br.readLine());
         if (br.readLine().contains("Nombre De Cliente: ")) {
         nombreDeCliente += br.readLine();
         }
         for (int i = 0; i < 4; i++) {
         br.readLine();
         }
         if (br.readLine().contains("Saldo: ")) {
         saldo += br.readLine();
         }*//*
         }
         } catch (Exception e) {
         System.out.println(e);
         }
         /*return nombreDeCliente + saldo;
         */
/*
        linesS = null;
        return linesS;
    }

private String readFile(String nombreCliente) {
        File f = new File("E:\\AltaDeCliente-" + nombreCliente + ".txt");
        String nombreDeCliente = "";
        String saldo = "";
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                System.out.println(br.readLine());
                if (br.readLine().contains("Nombre De Cliente: ")) {
                    nombreDeCliente += br.readLine();
                } else if (br.readLine().contains("Saldo: ")) {
                    saldo += br.readLine();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return nombreDeCliente + saldo;
    }*//*
}
*/