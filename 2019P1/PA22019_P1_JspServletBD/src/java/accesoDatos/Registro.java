/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.util.List;

/**
 *
 * @author uth
 */
public class Registro {
    private List<Columnas> columnas;

    public Registro(List<Columnas> columnas) {
        this.columnas = columnas;
    }

    public List<Columnas> getColumnas() {
        return columnas;
    }

    public void setColumnas(List<Columnas> columnas) {
        this.columnas = columnas;
    }

    @Override
    public String toString() {
        String datos="";
        for (Columnas columna : columnas) {
            datos+="["+columna+"]";
        }
        return "Registro{" + "columnas=" + datos + '}';
    }
    
}
