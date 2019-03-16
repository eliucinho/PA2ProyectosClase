/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author uth
 */
@WebServlet(urlPatterns = {"/servletMostrarMensaje"})
public class servletMostrarMensaje extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(
            HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        String nombre=request.getParameter("nombre");
        
        List<String> listaNombres=new ArrayList<>();
        listaNombres.add("jorge");
        listaNombres.add("sammy");
        listaNombres.add("oscar");
        listaNombres.add("carlos");
        listaNombres.add("eliud");
        
        String tabla="<table>";
        String fila="";
        String bandera="";
        for (String nombreTmp : listaNombres) {
            if (nombreTmp.equals(nombre)) {
                bandera="(encontrado)";
            }else{
                bandera="";
            }
            fila+="<tr><td>"+nombreTmp+"</td><td>"+bandera+"</td></tr>";
        }
        tabla+=fila;
        tabla+="</table>";
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>uth</title>");                   
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista Nombre: "+nombre+"</h1>");
            out.println(tabla);
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
