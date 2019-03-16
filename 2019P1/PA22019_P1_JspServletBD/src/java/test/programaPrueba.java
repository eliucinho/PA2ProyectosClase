/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import accesoDatos.Registro;
import accesoDatos.gestorDB;
import java.util.List;

/**
 *
 * @author uth
 */
public class programaPrueba {
    public static void main(String [] args){
        String nombreTabla="ESTADOS";
        String [] columnas={"USUARIO","DESCRIPCION"};
        String filtro="";
        
        List<Registro> lista=gestorDB.getTabla(columnas, nombreTabla, filtro);
        
        for (Registro variableTmp : lista) {
            System.out.println(variableTmp);
        }
        
    }
}
