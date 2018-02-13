<%-- 
    Document   : vistaPersona
    Created on : 13/02/2018, 03:42:34 PM
    Author     : Fabian
--%>

<%@page import='modelado.DAOPersona' %>
<%@page import='java.util.*' %>
<%@page import='uml.Persona' %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persona</title>
    </head>
    
    <%
        DAOPersona dao = new DAOPersona();
        List<Persona> datos = new ArrayList();
    %>
    <body>
        <form  name="formPersona" method="POST" action="SERVPersona" />
        <div class="form-item">
            <label>ID persona: </label><input type="number" name="id" />
        </div>
        <div class="form-item">
            <label>Nombres: </label><input type="text" name="nombre" />
        </div>  
        <div class="form-item">
            <label>Apellidos: </label><input type="text" name="apellidos" />
        </div> 
        <div class="form-item">
            <label>Edad: </label><input type="number" name="edad" min="0" />
        </div> 
        <div class="form-control">
            <input type="submit" name="btnInsertar" value="Insertar" />
            <input type="submit" name="btnModificar" value="Modificar" />
            <input type="submit" name="btnEliminar" value="Eliminar" />
        </div>
    </form>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Edad</th>
                </tr>
            </thead>
            <tbody>
                <%
                    datos = dao.consultar();
                    for(Persona p : datos){     
                 %>
                 <tr>
                     <td><%= p.getId() %></td>
                    <td><%=  p.getNombres() %></td>
                    <td><%=  p.getApellidos() %></td>
                    <td><%=  p.getEdad() %></td>
                </tr>  
                <% }
                %>
            </tbody>
        </table>
</body>
</html>
