function verificarUsuario(){
    let u = document.getElementById('txtUsuario');
    let c = document.getElementById('txtClave');
    
    $.ajax({
        data:{
            "txtUsuario":u.value,
            "txtClave":c.value
        },
        url:"./UsuariosU",
        async:true,
        type:"GET",
        dataType:"text",
        success: function(datos){
            datos = datos.trim();
            if(datos === 'true'){
                window.location.href="./MenuPrincipal.jsp";
            }else{
                window.location.href="./login.jsp";
            }
        }
        
    })
}


