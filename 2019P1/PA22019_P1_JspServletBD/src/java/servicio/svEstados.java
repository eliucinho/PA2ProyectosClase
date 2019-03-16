/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import logicaNegocio.lnEstados;

/**
 *
 * @author uth
 */
public class svEstados {
    public String getTablaEstados(){
        lnEstados lnEstados=new lnEstados();
        
        return lnEstados.getTablaEstados();
    }
    
    public String getTablaEstadosByUsuario(String usuario){
        lnEstados lnEstados=new lnEstados();
        
        return lnEstados.getTablaEstadosByUsuario(usuario);
    }
}
