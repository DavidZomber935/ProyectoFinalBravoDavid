/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jsf_mat.acceso;

import com.mycompany.jsf_mat.modelo.CBDD;
import java.sql.ResultSet;

/**
 *
 * @author Home
 */
public class Usuarios {

    private int idU;
    private String usuarioU;
    private String claveU;
    private String rolU;
    private String buscarU;
    private CBDD c;

    public Usuarios() {
        c = new CBDD();
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getUsuarioU() {
        return usuarioU;
    }

    public void setUsuarioU(String usuarioU) {
        this.usuarioU = usuarioU;
    }

    public String getClaveU() {
        return claveU;
    }

    public void setClaveU(String claveU) {
        this.claveU = claveU;
    }

    public String getRolU() {
        return rolU;
    }

    public void setRolU(String rolU) {
        this.rolU = rolU;
    }

    public String getBuscarU() {
        return buscarU;
    }

    public void setBuscarU(String buscarU) {
        this.buscarU = buscarU;
    }

    public ResultSet verificarUsuario(String usuario, String clave) {
        setUsuarioU(usuario);
        setClaveU(clave);
        String sql = "SELECT * FROM `usuario` \n"
                + "WHERE `usuario_u` = '"+getUsuarioU()+"'\n"
                + "and `clave_u` = SHA1('"+getClaveU()+"')";
        return c.consulta(sql);
    }

}
