/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

/**
 *
 * @author uth
 */
public class fila {
    private String nombreFila;
    private String valorFila;

    public fila(String nombreFila, String valorFila) {
        this.nombreFila = nombreFila;
        this.valorFila = valorFila;
    }

    public String getNombreFila() {
        return nombreFila;
    }

    public void setNombreFila(String nombreFila) {
        this.nombreFila = nombreFila;
    }

    public String getValorFila() {
        return valorFila;
    }

    public void setValorFila(String valorFila) {
        this.valorFila = valorFila;
    }

    @Override
    public String toString() {
        return "fila{" + "nombreFila=" + nombreFila + ", valorFila=" + valorFila + '}';
    }
    
}
