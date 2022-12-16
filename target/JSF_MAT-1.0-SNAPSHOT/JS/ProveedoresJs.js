window.onload = function () {
    readProveedores();
};
function readProveedores() {
    let buscar = document.getElementById('buscar');
    $.ajax({
        data: {
            "crud": "sel",
            "txtBuscar": buscar.value
        },
        url: "./ProveedoresP",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            document.getElementById('tablaProveedores').innerHTML = datos;
        }
    });

}

function insertarProveedores() {
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
        url: "./ProveedoresP",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            if (datos === 'true') {
                alert("Proveedor Insertado");
            } else {
                alert("Proveedor No insertado");
            }
            document.getElementById('closeInsertar').click();
            readProveedores();
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

function updateProveedores() {
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
        url: "./ProveedoresP",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            if (datos === 'true') {
                alert("Proveedor Actualizado");
            } else {
                alert("Proveedor No Actualizado");
            }
            document.getElementById('closeUpdate').click();
            readProveedores();
        }

    });
}
function cargarDatosEliminar(id){
    document.getElementById('numInDel').value=id;
    
}
function eliminarProveedores(){
    let id = document.getElementById('numInDel').value;
     $.ajax({
        data: {
            "crud": "del",
            "txtID": id
        },
        url: "./ProveedoresP",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            if (datos === 'true') {
                alert("Proveedor Eliminado");
            } else {
                alert("Proveedor No Eliminado");
            }
            document.getElementById('closeDelete').click();
            readProveedores();
        }

    });
    
}

