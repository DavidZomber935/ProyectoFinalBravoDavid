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
public class Productos {

    private int idProd;
    private String nombreProd;
    private String descripcionProd;
    private double valorRefCompProd;
    private double valorRefVentaProd;
    private int stockProd;
    private String tieneIvaProd;
    private String tipoProd;
    private String buscar;
    private CBDD p;

    public Productos() {
        p = new CBDD();
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getDescripcionProd() {
        return descripcionProd;
    }

    public void setDescripcionProd(String descripcionProd) {
        this.descripcionProd = descripcionProd;
    }

    public double getValorRefCompProd() {
        return valorRefCompProd;
    }

    public void setValorRefCompProd(double valorRefCompProd) {
        this.valorRefCompProd = valorRefCompProd;
    }

    public double getValorRefVentaProd() {
        return valorRefVentaProd;
    }

    public void setValorRefVentaProd(double valorRefVentaProd) {
        this.valorRefVentaProd = valorRefVentaProd;
    }

    public int getStockProd() {
        return stockProd;
    }

    public void setStockProd(int stockProd) {
        this.stockProd = stockProd;
    }

    public String getTieneIvaProd() {
        return tieneIvaProd;
    }

    public void setTieneIvaProd(String tieneIvaProd) {
        this.tieneIvaProd = tieneIvaProd;
    }

    public String getTipoProd() {
        return tipoProd;
    }

    public void setTipoProd(String tipoProd) {
        this.tipoProd = tipoProd;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public boolean insertProductos(String n, String d, double vc, double vv, int s, String ti, String tp) {
        setNombreProd(n);
        setDescripcionProd(d);
        setValorRefCompProd(vc);
        setValorRefVentaProd(vv);
        setStockProd(s);
        setTieneIvaProd(ti);
        setTipoProd(tp);
        String sql = "INSERT INTO `productos`"
                + "(`nombre_prod`, `descripcion_prod`, `valor_ref_comp_prod`, "
                + "`valor_ref_venta_prod`,`stock_prod`,`tiene_iva_prod`,`tipo_prod`) "
                + "VALUES "
                + "('" + getNombreProd() + "',"
                + "'" + getDescripcionProd() + "',"
                + "'" + getValorRefCompProd() + "',"
                + "'" + getValorRefVentaProd() + "',"
                + "'" + getStockProd() + "',"
                + "'" + getTieneIvaProd() + "',"
                + "'" + getTipoProd() + "')";
        return this.p.ejecutar(sql);
    }

    public boolean deleteProductos(int id) {
        setIdProd(id);
        String sql = "DELETE FROM `productos` \n"
                + "WHERE `id_prod`= " + getIdProd();
        return p.ejecutar(sql);
    }

    public boolean updateProductos(String n, String d, double vc, double vv, int s, String ti, String tp) {
        setNombreProd(n);
        setDescripcionProd(d);
        setValorRefCompProd(vc);
        setValorRefVentaProd(vv);
        setStockProd(s);
        setTieneIvaProd(ti);
        setTipoProd(tp);
        String sql = "UPDATE `productos` SET `nombre_prod`='" + getNombreProd() + "',\n"
                + "`descripcion_prod`='" + getDescripcionProd() + "',\n"
                + "`valor_ref_comp_prod`=" + getValorRefCompProd() + ",\n"
                + "`valor_ref_venta_prod`=" + getValorRefVentaProd() + ",\n"
                + "`stock_prod`=" + getStockProd() + ",\n"
                + "`tiene_iva_prod`='" + getTieneIvaProd() + "',\n"
                + "`tipo_prod`='" + getTipoProd() + "'\n"
                + "WHERE `id_prod`=" + getIdProd();
        return this.p.ejecutar(sql);
    }

    public ResultSet selectProductos(String b) {
        setBuscar(b);
        String sql = "SELECT * FROM `productos`\n"
                + "WHERE `nombre_prod` like '%" + getBuscar() + "%'\n"
                + "or `descripcion_prod` like '%" + getBuscar() + "%'";
        return p.consulta(sql);
    }

}
