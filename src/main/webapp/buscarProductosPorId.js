/**
 * 
 */
document.getElementById("cajaTxt").addEventListener("keyup", buscarProductosPorId);

function buscarProductosPorId() {
	let cajaTxt = document.getElementById("cajaTxt").value;
	if (cajaTxt != "") {
		axios.post(
			"buscarProductosPorId",
			null,
			{ params: { busqueda: cajaTxt } }
		).then(function(respuesta) {
			imprimirProductos(respuesta.data);
		}).catch(function(error) {
			console.log(error);
		});
	}
}

function imprimirProductos(producto) {
	let divProductos = document.getElementById("divProductos");
	divProductos.innerHTML =
		`<div class="productId">${producto.id}</div>
		<div class="productName">${producto.name}</div>
		<div class="quantityPerUnit">${producto.quantityPerUnit}</div>
		<div class="unitsInStock">${producto.unitsInStock}</div>
		<div class="unitPrice">${producto.unitPrice}</div>
		<div> <input type="button" value="Añadir" onclick=""/> </div>`;
}