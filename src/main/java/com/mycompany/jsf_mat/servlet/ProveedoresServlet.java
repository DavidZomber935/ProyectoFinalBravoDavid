
package com.mycompany.jsf_mat.servlet;

import com.mycompany.jsf_mat.acceso.Proveedores;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="ProveedoresP",urlPatterns ="/ProveedoresP")
public class ProveedoresServlet extends HttpServlet{
     
    //GET = http://localhost:8080/JSF_MAT/ClientesS?crud=sel&txtBuscar=
   //get
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        String menu = request.getParameter("crud");
        if (menu.equals("sel")) {
            readProveedores(request,response); 
        }else if (menu.equals("up")){
            updateProveedores(request,response); 
        }else if (menu.equals("in")){
            insertProveedores(request,response);    
        }else if (menu.equals("del")){
            deleteProveedores(request,response);   
        }
    }
    //post
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
      // TODO document why this method is empty
    }
    //CRUD
    private void deleteProveedores(HttpServletRequest request, HttpServletResponse response){
        try{
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            int id = Integer.parseInt(request.getParameter("txtID"));
            Proveedores p = new Proveedores();
            boolean r = p.deleteProveedores(id);
            pw.println(r);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    private void readProveedores(HttpServletRequest request, HttpServletResponse response){
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
    private void insertProveedores(HttpServletRequest request, HttpServletResponse response){
          try{
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            String nom = request.getParameter("txtNom");
            String ruc = request.getParameter("txtRuc");
            String con = request.getParameter("txtCon");
            String dir = request.getParameter("txtDir");
            Proveedores p = new Proveedores();
            boolean r = p.insertProveedores(nom, ruc, con, dir);
            pw.println(r);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void updateProveedores(HttpServletRequest request, HttpServletResponse response){
          try{
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            int id =Integer.parseInt(request.getParameter("numId"));
            String nom = request.getParameter("txtNom");
            String ruc = request.getParameter("txtRuc");
            String con = request.getParameter("txtCon");
            String dir = request.getParameter("txtDir");
            Proveedores p = new Proveedores();
            boolean r = p.updateProveedores(id, nom, ruc, con, dir);
            pw.println(r);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
