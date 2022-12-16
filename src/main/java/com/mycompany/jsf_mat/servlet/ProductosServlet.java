    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jsf_mat.servlet;

import com.mycompany.jsf_mat.acceso.Productos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Home
 */
@WebServlet(name = "ProductosP", urlPatterns = "/ProductosP")
public class ProductosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("crud");
        if (menu.equals("sel")) {
            readProductos(request, response);
        } else if (menu.equals("up")) {
            updateProductos(request, response);
        } else if (menu.equals("in")) {
            insertProductos(request, response);
        } else if (menu.equals("del")) {
            deleteProductos(request, response);
        }
    }

    //post
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
      // TODO document why this method is empty
    }

    //CRUD
    private void deleteProductos(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            int id = Integer.parseInt(request.getParameter("txtID"));
            Productos p = new Productos();
            boolean r = p.deleteProductos(id);
            pw.println(r);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void readProductos(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            String tabla = "<table class='table table-hover'>";
            tabla += "<thead class='thead-dark'>";
            tabla += "<tr>";
            tabla += "<th>ID";
            tabla += "</th>";
            tabla += "<th>NOMBRE PRODUCTO";
            tabla += "</th>";
            tabla += "<th>DESCRIPCION";
            tabla += "</th>";
            tabla += "<th>VALOR REF. COMPRA";
            tabla += "</th>";
            tabla += "<th>VALOR REF. VENTA";
            tabla += "</th>";
            tabla += "<th>STOCK";
            tabla += "</th>";
            tabla += "<th>TIENE IVA?";
            tabla += "</th>";
            tabla += "<th>TIPO";
            tabla += "</th>";
            tabla +="<th>Accion";
            tabla +="</th>";
            tabla += "</tr>";
            tabla += "</thead>";
            tabla += "<tbody>";
            tabla += "</tbody>";
            tabla += "</tabla>";
            pw.println(tabla);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertProductos(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            String nom = request.getParameter("txtNom");
            String des = request.getParameter("txtDes");
            double vrc = Double.parseDouble(request.getParameter("txtVrc"));
            double vrv = Double.parseDouble(request.getParameter("txtVrv"));
            int stk = Integer.parseInt(request.getParameter("txtStk"));
            String ti = request.getParameter("txtTi");
            String tip = request.getParameter("txtTip");
            Productos p = new Productos();
            boolean r = p.insertProductos(nom, des, vrc, vrv, stk, ti, tip);
            pw.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateProductos(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            String nom = request.getParameter("txtNom");
            String des = request.getParameter("txtDes");
            double vrc = Double.parseDouble(request.getParameter("txtVrc"));
            double vrv = Double.parseDouble(request.getParameter("txtVrv"));
            int stk = Integer.parseInt(request.getParameter("txtStk"));
            String ti = request.getParameter("txtTi");
            String tip = request.getParameter("txtTip");
            Productos p = new Productos();
            boolean r = p.updateProductos(nom, des, vrc, vrv, stk, ti, tip);
            pw.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}