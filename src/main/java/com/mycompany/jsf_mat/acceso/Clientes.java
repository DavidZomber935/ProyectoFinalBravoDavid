package com.mycompany.jsf_mat.acceso;

import com.mycompany.jsf_mat.modelo.CBDD;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Clientes {

    private int idCli;
    private String nombresCli;
    private String rucCli;
    private String contactoCli;
    private String direccionCli;
    private String buscar;
    private CBDD c;

    public Clientes() {
        c = new CBDD();
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public String getNombresCli() {
        return nombresCli;
    }

    public void setNombresCli(String nombresCli) {
        this.nombresCli = nombresCli;
    }

    public String getRucCli() {
        return rucCli;
    }

    public void setRucCli(String rucCli) {
        this.rucCli = rucCli;
    }

    public String getContactoCli() {
        return contactoCli;
    }

    public void setContactoCli(String contactoCli) {
        this.contactoCli = contactoCli;
    }

    public String getDireccionCli() {
        return direccionCli;
    }

    public void setDireccionCli(String direccionCli) {
        this.direccionCli = direccionCli;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public boolean insertClientes(String n, String r, String c, String d) {
        setNombresCli(n);
        setRucCli(r);
        setContactoCli(c);
        setDireccionCli(d);
        String sql = "INSERT INTO `clientes`"
                + "(`nombres_cli`, `ruc_cli`, `contacto_cli`, "
                + "`direccion_cli`) "
                + "VALUES "
                + "('" + getNombresCli() + "',"
                + "'" + getRucCli() + "',"
                + "'" + getContactoCli() + "',"
                + "'" + getDireccionCli() + "')";
        return this.c.ejecutar(sql);
    }

    public boolean deleteClientes(int id) {
        setIdCli(id);
        String sql = "DELETE FROM `clientes` \n"
                + "WHERE `id_cli`= " + getIdCli();
        return c.ejecutar(sql);
    }

    public boolean updateClientes(int id, String n, String r, String c, String d) {
        setIdCli(id);
        setNombresCli(n);
        setRucCli(r);
        setContactoCli(c);
        setDireccionCli(d);
        String sql = "UPDATE `clientes` SET `nombres_cli`='" + getNombresCli() + "',\n"
                + "`ruc_cli`='" + getRucCli() + "',\n"
                + "`contacto_cli`='" + getContactoCli() + "',\n"
                + "`direccion_cli`='" + getDireccionCli() + "'\n"
                + "WHERE `id_cli`=" + getIdCli();
        return this.c.ejecutar(sql);
    }

    public ResultSet selectClientes(String b) {
        setBuscar(b);
        String sql = "SELECT * FROM `clientes`\n"
                + "WHERE `nombres_cli` like '%"+getBuscar()+"%'\n"
                + "or `ruc_cli` like '%"+getBuscar()+"%'";
        return c.consulta(sql);
    }
}
