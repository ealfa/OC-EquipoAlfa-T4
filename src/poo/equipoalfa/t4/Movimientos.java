/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.equipoalfa.t4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author jesus_ignacio_159
 */
public class Movimientos extends JFrame implements ActionListener {
    JMenuItem cmdAbrir, cmdCerrar, cmdSalir, cmdCopiar, cmdPegar;
    JButton cmdRegistroDeComprasB, cmdPagosB, cmdConsultaDeSaldoB;
    JMenu menuArchivo, menuEdicion;
    JMenuBar braMenu;
    
    //Constructor
    public Movimientos(){
        //Establecemos el título de la ventana.
        super("Ventana con menú");
        //Establecemos la ubicación en la pantalla y las dimenciones de la ventana
        setBounds(200,200,800,500); //x,y,ancho,alto
        //Programamos la X para cerrar la ventana.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new FlowLayout());
        
        //Paso 1. Crear los JMenuItems
        cmdAbrir = new JMenuItem("Abrir");
        cmdCerrar = new JMenuItem("Cerrar");
        cmdSalir = new JMenuItem("Salir");
        cmdCopiar = new JMenuItem("Copiar");
        cmdPegar = new JMenuItem("Pegar");
        
        cmdRegistroDeComprasB = new JButton("Registro De Compras");
        cmdPagosB = new JButton("Pagos");
        cmdConsultaDeSaldoB = new JButton("Consulta De Saldo");
        
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
        
        add(cmdRegistroDeComprasB);
        add(cmdPagosB);
        add(cmdConsultaDeSaldoB);
        
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
        
        cmdRegistroDeComprasB.addActionListener(this);
        cmdPagosB.addActionListener(this);
        cmdConsultaDeSaldoB.addActionListener(this);
    }
    
    private void salir(){
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==cmdAbrir){
            JOptionPane.showMessageDialog(null, "Presionaste Abrir");
        }else if (e.getSource()==cmdCerrar){
            JOptionPane.showMessageDialog(null, "Presionaste Cerrar");
        }else if (e.getSource()==cmdSalir){
            salir();
        }else if (e.getSource()==cmdCopiar){
            JOptionPane.showMessageDialog(null, "Presionaste Copiar");
        } else if (e.getSource()==cmdPegar){
            JOptionPane.showMessageDialog(null, "Presionaste Pegar"); 
        } else if (e.getSource() == cmdRegistroDeComprasB){
            JOptionPane.showMessageDialog(null, "Presionaste RegistroDeCompras"); 
            Ventana2 ventana2 = new Ventana2();
        } else if (e.getSource() == cmdPagosB){
            JOptionPane.showMessageDialog(null, "Presionaste Pagos"); 
            Ventana3 ventana3 = new Ventana3();
        } else if (e.getSource() == cmdConsultaDeSaldoB){
            JOptionPane.showMessageDialog(null, "Presionaste Consulta De Saldo");
            Ventana4 ventana4 = new Ventana4();
        }
    }
}
