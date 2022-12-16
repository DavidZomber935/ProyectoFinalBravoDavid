<%-- 
    Document   : ProductosVista
    Created on : 4 jul. 2022, 18:22:24
    Author     : Home
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <script src="./JS/ProductosJs.js"></script>
        <%@include file="./libreria/librerias.jsp"%>
    </head>
    <body>
        <div>
            <!-- cabezera y menu -->
            <%@include file="./libreria/header.jsp"%>
        </div>
        <div class="container">
            <h1 style="text-align: center">Productos</h1>
            <hr>
            <form>
                <table>
                    <tr>
                        <td>
                            <label>Buscar:</label>
                        </td>
                        <td>
                            <input type="text" class="form-control" id="buscar"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button type="button" class="btn btn-primary" style="width: 85px;height: 40px" data-toggle="modal"data-target="#buscarProducto">Buscar</button>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button type="button" class="btn btn-success" style="width: 85px;height: 40px"data-toggle="modal"data-target="#insertarProducto">Insertar</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="container">
            <div id="tablaProductos">

            </div>
        </div>
        <!-- The Modal -->
        <div class="modal" id="insertarProducto">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Insertar Productos</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <form>
                            <table>
                                <tr>
                                    <td>
                                        <label>Nombre Producto:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtNom"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Descripcion Producto:</label> 
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtDes"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Valor Referencia Compra:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtVrc"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Valor Referencia Venta:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtVrv"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Stock:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtStk"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Tiene Iva:</label>
                                    </td>
                                    <td>
                                        <select id="txtTi">
                                            <option value="Si">si</option>
                                            <option value="No">No</option>

                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Tipo de producto:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtTip"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>

                                    </td>
                                    <td>
                                        <button type="button" class="btn btn-primary" onclick="insertarProductos()">Insertar</button>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal" id="closeInsertar">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- The Modal -->
        <div class="modal" id="ActualizarProducto">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Actualizar Productos</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <form>
                            <table>
                                <tr>
                                    <td>
                                        <label>ID:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="numIdUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Nombre Producto:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtNomUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Descripcion Producto:</label> 
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtDesUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Valor Referencia Compra:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtVrcUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Valor Referencia Venta:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtVrvUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Stock:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtStkUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Tiene Iva:</label>
                                    </td>
                                    <td>
                                        <select id="txtTiUp">
                                            <option value="Si">si</option>
                                            <option value="No">No</option>

                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Tipo de producto:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtTipUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>

                                    </td>
                                    <td>
                                        <button type="button" class="btn btn-primary" onclick="updateProductos()">Actualizar</button>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal" id="closeUpdate">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- The Modal -->
        <div class="modal" id="eliminarProducto">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Eliminar Productos</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <input type="hidden" id="numInDel" readonly/>
                        <h3>¿Deseas eliminar este registro?</h3>
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" onclick="eliminarProductos()()">Si</button>
                        <button type="button" class="btn btn-danger" data-dismiss="modal" id="closeDelete">No</button>

                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
