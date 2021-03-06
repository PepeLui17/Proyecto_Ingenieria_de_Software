function cargarElementos() {
    var btnLibros = document.getElementById("btnLibros");
    var btnEmpleados = document.getElementById("btnEmpleados");
    var btnClientes = document.getElementById("btnClientes");
    var btnNuevaVenta = document.getElementById("btnNuevaVenta");
    var btnReporteVentas = document.getElementById("btnReporteVentas");
    var btnSalir = document.getElementById("btnSalir");

    if (btnLibros !== null) {
        btnLibros.addEventListener('click', linkLibros, false);
    }
    if (btnEmpleados !== null) {
        btnEmpleados.addEventListener('click', linkEmpleados, false);
    }
    if (btnClientes !== null) {
        btnClientes.addEventListener('click', linkClientes, false);
    }
    if (btnNuevaVenta !== null) {
        btnNuevaVenta.addEventListener('click', linkNuevaVenta, false);
    }
    if (btnReporteVentas !== null) {
        btnReporteVentas.addEventListener('click', linkReporteVentas, false);
    }
    if (btnSalir !== null) {
        btnSalir.addEventListener('click', linkLogOut, false);
    }
}

function linkLibros() {
    location.href = "http://quijote:8081/pruebaCAS/vendedor/opcionLibros.xhtml";
}
function linkEmpleados() {
    location.href = "http://quijote:8081/pruebaCAS/administrador/opcionEmpleados.xhtml";
}
function linkClientes() {
    location.href = "http://quijote:8081/pruebaCAS/vendedor/opcionClientes.xhtml";
}
function linkNuevaVenta() {
    location.href = "http://quijote:8081/pruebaCAS/vendedor/opcionNuevaVenta.xhtml";
}
function linkReporteVentas() {
    location.href = "http://quijote:8081/pruebaCAS/administrador/opcionReporteDeVenta.xhtml";
}
function linkLogOut() {
    location.href = "https://quijote:8443/cas/logout";
}


window.onload = function() {
    cargarElementos();
};