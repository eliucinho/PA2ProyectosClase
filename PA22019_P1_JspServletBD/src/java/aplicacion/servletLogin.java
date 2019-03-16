/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author uth
 */
@WebServlet(name = "servletLogin", urlPatterns = {"/paginas/servletLogin"})
public class servletLogin extends HttpServlet {
        //por cuestiones de tiempo no se fue a la base de datos
        private String contraseniaGenerica="hola uth";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //obteniendo el usuario y contrasenia del formulario de login
        String usuario=(String)request.getParameter("usuario");
        String contrasenia=(String)request.getParameter("contrasenia");
        
        //validar que la contrasenia sea correcta
        if (contrasenia.equals(contraseniaGenerica)) {
            request.getSession().setAttribute("usuario", usuario);
            response.sendRedirect("servletEstados");
        }else{
            request.getSession().setAttribute("estadoError", "true");                    
            response.sendRedirect("../index.jsp?estadoError=true");
        }
        
        //response.setContentType("text/html;charset=UTF-8");
        
        //se deja comentado por que el servlet no se va a utilizar para generar paginas, solo para gestionar informacion
        /*try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
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
