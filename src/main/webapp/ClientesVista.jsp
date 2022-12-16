<%-- 
    Document   : ClientesVista
    Created on : 21 jun. 2022, 09:08:44
    Author     : Home
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
        <script src="./JS/ClientesJs.js"></script>
        <!-- libreria para los estilos -->
        <%@include file="./libreria/librerias.jsp"%>
        
    </head>
    <body>
        <div>
            <!-- cabezera y menu -->
            <%@include file="./libreria/header.jsp"%>
        </div>
        <div class="container">
            <h1 style="text-align: center">Clientes</h1>
            <hr><!-- comment -->
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
                            <button type="button" class="btn btn-primary" style="width: 85px;height: 40px" data-toggle="modal"data-target="#buscarCliente" onclick="readClientes()">Buscar</button>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button type="button" class="btn btn-success" style="width: 85px;height: 40px"data-toggle="modal"data-target="#insertarCliente">Insertar</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="container">
            <div id="tablaClientes">

            </div>
        </div>
        <div>
            <!--pie de pagina-->
        </div>

        <!-- The Modal -->
        <div class="modal" id="insertarCliente">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Insertar Clientes</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <form>
                            <table>
                                <tr>
                                    <td>
                                        <label>Nombre:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtNom"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                       <label>RUC:</label> 
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtRuc"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Contacto:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtCon"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Direccion:</label>
                                    </td>
                                    <td>
                                        <input type="textfield" class="form-control" id="txtDir"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        
                                    </td>
                                    <td>
                                        <button type="button" class="btn btn-primary" onclick="insertarClientes()">Insertar</button>
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
        <div class="modal" id="actualizarCliente">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Actualizar Clientes</h4>
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
                                        <label>Nombre:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtNomUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                       <label>RUC:</label> 
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtRucUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Contacto:</label>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="txtConUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Direccion:</label>
                                    </td>
                                    <td>
                                        <input type="textfield" class="form-control" id="txtDirUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        
                                    </td>
                                    <td>
                                        <button type="button" class="btn btn-primary" onclick="updateClientes()">Actualizar</button>
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
        <div class="modal" id="eliminarCliente">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Eliminar Clientes</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <input type="hidden" id="numInDel" readonly/>
                        <h3>¿Deseas eliminar este registro?</h3>
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" onclick="eliminarClientes()">Si</button>
                        <button type="button" class="btn btn-danger" data-dismiss="modal" id="closeDelete">No</button>
                        
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
