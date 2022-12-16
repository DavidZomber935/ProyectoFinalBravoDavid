<%-- 
    Document   : login
    Created on : 19 jul. 2022, 08:12:36
    Author     : Home
--%>
<%HttpSession sesion = request.getSession();
    sesion.setAttribute("estado", "0");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <script src="./JS/UsuariosJs.js"></script>
        <%@include file="./libreria/librerias.jsp"%>

    </head>
    <body>
        <div class="container" align="center">
            <h1>login</h1>
            <form>
                <table>
                    <tr>
                        <td>
                            <label>usuario:</label>
                        </td>
                        <td>
                            <input type="text" id='txtUsuario'/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>clave:</label>
                        </td>
                        <td>
                            <input type="password" id='txtClave'/>
                        </td>
                    </tr>
                    <tr>
                        <td>

                        </td>
                        <td>
                            <button class='btn btn-primary' type="button" onclick="verificarUsuario()">iniciar sesión</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
