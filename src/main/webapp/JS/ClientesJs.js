window.onload = function () {
    readClientes();
};
function readClientes() {
    let buscar = document.getElementById('buscar');
    $.ajax({
        data: {
            "crud": "sel",
            "txtBuscar": buscar.value
        },
        url: "./ClientesS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            document.getElementById('tablaClientes').innerHTML = datos;
        }
    });

}

function insertarClientes() {
    let nombres = document.getElementById('txtNom');
    let ruc = document.getElementById('txtRuc');
    let contacto = document.getElementById('txtCon');
    let direccion = document.getElementById('txtDir');
    $.ajax({
        data: {
            "crud": "in",
            "txtNom": nombres.value,
            "txtRuc": ruc.value,
            "txtCon": contacto.value,
            "txtDir": direccion.value
        },
        url: "./ClientesS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            if (datos === 'true') {
                alert("Cliente Insertado");
            } else {
                alert("Cliente No insertado");
            }
            document.getElementById('closeInsertar').click();
            readClientes();
        }

    });
}
function cargarDatosActualizar(id, n, r, c, d) {
    document.getElementById('numIdUp').value = id;
    document.getElementById('txtNomUp').value = n;
    document.getElementById('txtRucUp').value = r;
    document.getElementById('txtConUp').value = c;
    document.getElementById('txtDirUp').value = d;
}

function updateClientes() {
    let id = document.getElementById('numIdUp').value;
    let n = document.getElementById('txtNomUp').value;
    let r = document.getElementById('txtRucUp').value;
    let c = document.getElementById('txtConUp').value;
    let d = document.getElementById('txtDirUp').value;
    $.ajax({
        data: {
            "crud": "up",
            "numId": id,
            "txtNom": n,
            "txtRuc": r,
            "txtCon": c,
            "txtDir": d
        },
        url: "./ClientesS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            if (datos === 'true') {
                alert("Cliente Actualizado");
            } else {
                alert("Cliente No Actualizado");
            }
            document.getElementById('closeUpdate').click();
            readClientes();
        }

    });
}
function cargarDatosEliminar(id){
    document.getElementById('numInDel').value=id;
    
}
function eliminarClientes(){
    let id = document.getElementById('numInDel').value;
     $.ajax({
        data: {
            "crud": "del",
            "txtID": id
        },
        url: "./ClientesS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            if (datos === 'true') {
                alert("Cliente Eliminado");
            } else {
                alert("Cliente No Eliminado");
            }
            document.getElementById('closeDelete').click();
            readClientes();
        }

    });
    
}