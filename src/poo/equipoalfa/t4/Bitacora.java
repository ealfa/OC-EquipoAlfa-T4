/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.equipoalfa.t4;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que almacenará todas las transferencias o transacciones
 * @author 
 */
public class Bitacora {
    // Atributos
    /**
     * Se guardan en una lista las transferencias
     */
    private List<Transferencia> listaDeTransferencias;

    /**
     * Constructor que inicializa la bitácora
     */
    public Bitacora() {
        this.listaDeTransferencias = new ArrayList<Transferencia>();
    }

    /**
     * Cosntructor que inicializa la bitácora pasándole la lista de
     * transferencia de alguna otra bitácora
     *
     * @param listaTransferencia
     */
    public Bitacora(List<Transferencia> listaTransferencia) {
        this.listaDeTransferencias = listaTransferencia;
    }

    /**
     * Método que agregará una transferencia a la lista
     *
     * @param transferencia Es una transferencia que representa una transacción
     * o transferencia hecha
     * @return Si se agregó con éxito la transferencia
     */
    public boolean agregarALista(Transferencia transferencia) {
        return this.listaDeTransferencias.add(transferencia);
    }

    /**
     * Método que elimina una transferencia de la lista
     *
     * @param transferencia Es la transferencia que se desea eliminar de la
     * lista
     * @return si se eliminó con éxito la transferencia
     */
    public boolean eliminarDeLista(Transferencia transferencia) {
        return this.listaDeTransferencias.remove(transferencia);
    }

    /**
     * Método que regresa la lista de transferencias de la bitácora
     *
     * @return la lista de transferencias de la bitácora
     */
    public List<Transferencia> getListaDeTransferencia() {
        return this.listaDeTransferencias;
    }

    /**
     * Es un método que regresa una cadena de caracteres con una descripción de
     * las ultimas 5 transferencias
     *
     * @return un string con la descripción de las últimas 5 transacciones
     */
    public String descripcionUltimos5() {
        String descripcion = "";

        if (this.listaDeTransferencias.isEmpty()) {
            descripcion = "==NO HAY MOVIMIENTOS==";
        } else {
            int i = 5;
            if (this.listaDeTransferencias.size() < 5) {
                i = this.listaDeTransferencias.size();
            }
            int auxiliar = this.listaDeTransferencias.size() - 1;

            for (int e = 1; e <= i; e++) {
                descripcion = descripcion + this.listaDeTransferencias.get(auxiliar).descripcionTransferencia() + "\n";
                auxiliar = auxiliar - 1;
                i = i - 1;
            }
        }
        return descripcion;
    }

    /**
     * Método que regresa la descripción de la bitácora
     *
     * @return un string con la descripción de la bitácora
     */
    public String descripcionBitacora() {
        String descripcion = "";

        if (this.listaDeTransferencias.isEmpty()) {
            descripcion = "==NO HAY MOVIMIENTOS==";
        } else {
            int auxiliar = this.listaDeTransferencias.size();
            for (int e = 1; e <= auxiliar; e++) {
                auxiliar = auxiliar - 1;
                descripcion = descripcion + this.listaDeTransferencias.get(auxiliar).descripcionTransferencia() + "\n";                
            }
        }
        return descripcion;
    }
    
    
}
