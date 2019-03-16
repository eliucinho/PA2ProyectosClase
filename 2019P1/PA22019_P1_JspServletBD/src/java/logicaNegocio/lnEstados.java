/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import accesoDatos.Columnas;
import accesoDatos.Registro;
import accesoDatos.gestorDB;
import java.util.List;

/**
 *
 * @author uth
 */
public class lnEstados {
    public String getTablaEstados(){
        String tablaCompleta="";
        String nombreTabla="ESTADOS";
        String [] columnas={"USUARIO","DESCRIPCION"};
        String filtro="";
        
        List<Registro> lista=gestorDB.getTabla(columnas, nombreTabla, filtro);
        tablaCompleta+="<table>";
        for (Registro variableTmp : lista) {                
                tablaCompleta+="<tr>";
                for (Columnas columna : variableTmp.getColumnas()) {                    
                    tablaCompleta+="</td>";
                    tablaCompleta+=columna.getValor();                    
                    tablaCompleta+="</td>";
                }
                tablaCompleta+="</tr>";
            }
            
            tablaCompleta+="</table>";
            return tablaCompleta;
    }
    
    public String getTablaEstadosByUsuario(String usuario){
        String tablaCompleta="";
        String nombreTabla="ESTADOS";
        String [] columnas={"USUARIO","DESCRIPCION"};
        String filtro=" WHERE USUARIO = '"+usuario+"'";
        
        List<Registro> lista=gestorDB.getTabla(columnas, nombreTabla, filtro);
        tablaCompleta+="<table>";
        for (Registro variableTmp : lista) {                
                tablaCompleta+="<tr>";
                for (Columnas columna : variableTmp.getColumnas()) {                    
                    tablaCompleta+="</td>";
                    tablaCompleta+=columna.getValor();                    
                    tablaCompleta+="</td>";
                }
                tablaCompleta+="</tr>";
            }
            
            tablaCompleta+="</table>";
            return tablaCompleta;
    }
    
}
