
package com.mycompany.jsf_mat.acceso;

import com.mycompany.jsf_mat.modelo.CBDD;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class Proveedores {
    private int idPro;
    private String nombresPro;
    private String rucPro;
    private String contactoPro;
    private String direccionPro;
    private String buscar;
    private CBDD c;

    public Proveedores() {
        c = new CBDD();
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getNombresPro() {
        return nombresPro;
    }

    public void setNombresPro(String nombresPro) {
        this.nombresPro = nombresPro;
    }

    public String getRucPro() {
        return rucPro;
    }

    public void setRucPro(String rucPro) {
        this.rucPro = rucPro;
    }

    public String getContactoPro() {
        return contactoPro;
    }

    public void setContactoPro(String contactoPro) {
        this.contactoPro = contactoPro;
    }

    public String getDireccionPro() {
        return direccionPro;
    }

    public void setDireccionPro(String direccionPro) {
        this.direccionPro = direccionPro;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }
     public boolean insertProveedores(String n, String r, String c, String d) {
        setNombresPro(n);
        setRucPro(r);
        setContactoPro(c);
        setDireccionPro(d);
        String sql = "INSERT INTO `proveedores`"
                + "(`nombres_pro`, `ruc_pro`, `contacto_pro`, "
                + "`direccion_pro`) "
                + "VALUES "
                + "('" + getNombresPro() + "',"
                + "'" + getRucPro() + "',"
                + "'" + getContactoPro() + "',"
                + "'" + getDireccionPro() + "')";
        return this.c.ejecutar(sql);
    }

    public boolean deleteProveedores(int id) {
        setIdPro(id);
        String sql = "DELETE FROM `proveedores` \n"
                + "WHERE `id_pro`= " + getIdPro();
        return c.ejecutar(sql);
    }

    public boolean updateProveedores(int id, String n, String r, String c, String d) {
        setIdPro(id);
        setNombresPro(n);
        setRucPro(r);
        setContactoPro(c);
        setDireccionPro(d);
        String sql = "UPDATE `proveedores` SET `nombres_pro`='" + getNombresPro() + "',\n"
                + "`ruc_pro`='" + getRucPro() + "',\n"
                + "`contacto_pro`='" + getContactoPro() + "',\n"
                + "`direccion_pro`='" + getDireccionPro() + "'\n"
                + "WHERE `id_pro`=" + getIdPro();
        return this.c.ejecutar(sql);
    }

    public ResultSet selectProveedores(String b) {
        setBuscar(b);
        String sql = "SELECT * FROM `proveedores`\n"
                + "WHERE `nombres_pro` like '%"+getBuscar()+"%'\n"
                + "or `ruc_pro` like '%"+getBuscar()+"%'";
        return c.consulta(sql);
    }
}
