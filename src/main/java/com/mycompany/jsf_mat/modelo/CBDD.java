
package com.mycompany.jsf_mat.modelo;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class CBDD {
    private Statement st;
    private String driver;
    private String user;
    private String clave;
    private String cadena;
    private Connection cnx;
    
    public CBDD(){
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.user = "root";
        this.clave = "1234";
        this.cadena = "jdbc:mysql://localhost/factupim?useSSL=false&serverTimezone=UTC";
        this.cnx = crearConexion();
    }


    public String getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public String getClave() {
        return clave;
    }

    public String getCadena() {
        return cadena;
    }

    public Connection getCnx() {
        return cnx;
    }
    
    private Connection crearConexion(){
        try{
           Class.forName(getDriver()).newInstance();
           return DriverManager.getConnection(getCadena(),getUser(),getClave());
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean ejecutar(String sql){
        try{
            st=getCnx().createStatement();
            int r = st.executeUpdate(sql);
            if (r==1) {
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
           e.printStackTrace();  
           return false;
        }
    }
    //select
    public ResultSet consulta(String sql){
        ResultSet rs= null;
        try{
            st = getCnx().createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
}
