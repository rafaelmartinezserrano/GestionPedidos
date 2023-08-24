/**
 * 
 */
document.getElementById("cajaTxt").addEventListener("keyup", buscarProductosPorId);

function buscarProductosPorId() {
	let cajaTxt = document.getElementById("cajaTxt").value;
	if (cajaTxt != "") {
		axios.post(
			"FindProductById",
			null,
			{ params: { busquedaId: cajaTxt } }
		).then(function(respuesta) {
			imprimirProductos(respuesta.data);
		}).catch(function(error) {
			console.log(error);
		});
	}
}

function imprimirProductos(producto) {
	let divProductos = document.getElementById("divProductos");
	console.log(producto)
	divProductos.innerHTML =
		`<div>
		<ul>
		<li><span>Id del producto: </span>${producto.productID}</li>
		<li><span>Nombre del producto: </span>${producto.productName}</li>
		<li><span>Productos por lote: </span>${producto.quantityPerUnit}</li>
		<li><span>Unidades en stock: :</span>${producto.unitsInStock}</li>
		<li><span>Precio de la unidad:</span>${producto.unitPrice}</li>
		</ul>
		<div><input type="button" value="Comprar" onclick=""/> </div>`;
}