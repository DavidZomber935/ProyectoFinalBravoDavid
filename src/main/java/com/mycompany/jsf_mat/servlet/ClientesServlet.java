
package com.mycompany.jsf_mat.servlet;

import com.mycompany.jsf_mat.acceso.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ClientesS",urlPatterns ="/ClientesS")
public class ClientesServlet extends HttpServlet{
    
    //GET = http://localhost:8080/JSF_MAT/ClientesS?crud=sel&txtBuscar=
   //get
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        String menu = request.getParameter("crud");
        if (menu.equals("sel")) {
            readClientes(request,response); 
        }else if (menu.equals("up")){
            updateClientes(request,response); 
        }else if (menu.equals("in")){
            insertClientes(request,response);    
        }else if (menu.equals("del")){
            deleteClientes(request,response);   
        }
    }
    //post
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
      // TODO document why this method is empty
    }
    //CRUD
    private void deleteClientes(HttpServletRequest request, HttpServletResponse response){
        try{
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            int id = Integer.parseInt(request.getParameter("txtID"));
            Clientes c = new Clientes();
            boolean r = c.deleteClientes(id);
            pw.println(r);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    private void readClientes(HttpServletRequest request, HttpServletResponse response){
        try{
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            String tabla= "<table class='table table-hover'>";
            tabla +="<thead class='thead-dark'>";
            tabla +="<tr>";
            tabla +="<th>ID";
            tabla +="</th>";
            tabla +="<th>NOMBRES";
            tabla +="</th>";
            tabla +="<th>RUC";
            tabla +="</th>";
            tabla +="<th>CONTACTO";
            tabla +="</th>";
            tabla +="<th>DIRECCION";
            tabla +="</th>";
            tabla +="<th>Accion";
            tabla +="</th>";
            tabla +="</tr>";
            tabla +="</thead>";
            tabla +="<tbody>";
            tabla +="</tbody>"; 
            tabla +="</tabla>";
            pw.println(tabla);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void insertClientes(HttpServletRequest request, HttpServletResponse response){
          try{
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            String nom = request.getParameter("txtNom");
            String ruc = request.getParameter("txtRuc");
            String con = request.getParameter("txtCon");
            String dir = request.getParameter("txtDir");
            Clientes c = new Clientes();
            boolean r = c.insertClientes(nom, ruc, con, dir);
            pw.println(r);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void updateClientes(HttpServletRequest request, HttpServletResponse response){
          try{
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            int id =Integer.parseInt(request.getParameter("numId"));
            String nom = request.getParameter("txtNom");
            String ruc = request.getParameter("txtRuc");
            String con = request.getParameter("txtCon");
            String dir = request.getParameter("txtDir");
            Clientes c = new Clientes();
            boolean r = c.updateClientes(id, nom, ruc, con, dir);
            pw.println(r);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
