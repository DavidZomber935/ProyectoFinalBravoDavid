window.onload = function () {
    readProductos();
};
function readProductos() {
    let buscar = document.getElementById('buscar');
    $.ajax({
        data: {
            "crud": "sel",
            "txtBuscar": buscar.value
        },
        url: "./ProductosP",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            document.getElementById('tablaProductos').innerHTML = datos;
        }
    });

}

function insertarProductos() {
    let nombre_producto = document.getElementById('txtNom');
    let descripcion = document.getElementById('txtDes');
    let valor_referencia_compra = document.getElementById('txtVrc');
    let valor_referencia_venta = document.getElementById('txtVrv');
    let stock = document.getElementById('txtStk');
    let tiene_iva = document.getElementById('txtTi');
    let tipo_producto = document.getElementById('txtTip');
    $.ajax({
        data: {
            "crud": "in",
            "txtNom": nombre_producto.value,
            "txtDes": descripcion.value,
            "txtVrc": valor_referencia_compra.value,
            "txtVrv": valor_referencia_venta.value,
            "txtStk": stock.value,
            "txtTi": tiene_iva.value,
            "txtTip": tipo_producto.value
        },
        url: "./ProductosP",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            if (datos === 'true') {
                alert("Producto Insertado");
            } else {
                alert("Producto No insertado");
            }
            document.getElementById('closeInsertar').click();
            readProductos();
        }

    });
}
function cargarDatosActualizar(id, n, d, vc, vv, s, t, tp) {
    document.getElementById('numIdUp').value = id;
    document.getElementById('txtNomUp').value = n;
    document.getElementById('txtDesUp').value=d;
    document.getElementById('txtVrcUp').value=vc;
    document.getElementById('txtVrvUp').value=vv;
    document.getElementById('txtStkUp').value=s;
    let selectIva = document.getElementById('txtTiUp');
    if(t === 'SI'){
        selectIva.options[0].selected=true;
    }else if(t === 'NO'){
        selectIva.options[1].selected=true;
    }
    document.getElementById('txtTipUp').value=tp;

}

function updateProductos() {
    let id = document.getElementById('numIdUp').value;
    let n = document.getElementById('txtNomUp').value;
    let d = document.getElementById('txtDesUp').value;
    let vc = document.getElementById('txtVrcUp').value;
    let vv = document.getElementById('txtVrvUp').value;
    let s = document.getElementById('txtStkUp').value;
    let t = document.getElementById('txtTiUp').value;
    let tp = document.getElementById('txtTipUp').value;
    
    $.ajax({
        data: {
            "crud": "up",
            "numId": id,
            "txtNom": n,
            "txtDes": d,
            "txtVrc": vc,
            "txtVrv": vv,
            "txtStk": s,
            "txtTi": t,
            "txtTip": tp
        },
        url: "./ProductosP",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            if (datos === 'true') {
                alert("Producto Actualizado");
            } else {
                alert("Producto No Actualizado");
            }
            document.getElementById('closeUpdate').click();
            readProductos();
        }

    });
}
function cargarDatosEliminar(id){
    document.getElementById('numInDel').value=id;
    
}
function eliminarProductos(){
    let id = document.getElementById('numInDel').value;
     $.ajax({
        data: {
            "crud": "del",
            "txtID": id
        },
        url: "./ProductosP",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            if (datos === 'true') {
                alert("Producto Eliminado");
            } else {
                alert("Producto No Eliminado");
            }
            document.getElementById('closeDelete').click();
            readProductos();
        }

    });
    
}

