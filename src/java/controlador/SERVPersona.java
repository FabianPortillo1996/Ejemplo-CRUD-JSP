/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelado.DAOPersona;
import uml.Persona;

/**
 *
 * @author User
 */
public class SERVPersona extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            DAOPersona dao = new DAOPersona();
            Persona p = new Persona();
            List<Persona> datos = new ArrayList<>();

            String respuesta = "";
            RequestDispatcher rd = null;

            try {
                if (request.getParameter("btnInsertar") != null) {
                    
                    p.setId(Integer.parseInt(request.getParameter("id")));
                    p.setNombres(request.getParameter("nombre"));
                    p.setApellidos(request.getParameter("apellidos"));
                    p.setEdad(Integer.parseInt(request.getParameter("edad")));

                    respuesta = dao.insertar(p);
                    request.setAttribute("Respuesta", respuesta);
                    System.out.println(respuesta);
                    
                }else if(request.getParameter("btnModificar") != null){
                    p.setId(Integer.parseInt(request.getParameter("id")));
                    p.setNombres(request.getParameter("nombre"));
                    p.setApellidos(request.getParameter("apellidos"));
                    p.setEdad(Integer.parseInt(request.getParameter("edad")));

                    respuesta = dao.modificar(p);
                    request.setAttribute("Respuesta", respuesta);
                   
                }else if(request.getParameter("btnModificar") != null){
                    p.setId(Integer.parseInt(request.getParameter("id")));
                    dao.eliminar(p);
                }
                rd = request.getRequestDispatcher("vistaPersona.jsp");
            } catch (Exception e) {
            }
            rd.forward(request, response);
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
