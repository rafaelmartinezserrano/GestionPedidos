// document.getElementById("CajaTxt").addEventListener("keyup" , buscarCategory)
 
 
 
  function buscarCategory () {
	let TxtBusqueda = document.getElementById("CajaTxt").value;
	// post é o metodo usado HTTP
	if(TxtBusqueda != ""){
		axios.post(
		//nome do SERVLET
		"FindProductByCategory", 
		null,
		//chamar o parametro, passar tipo e valor, sempre com o nome  {params: {} } . 
		{params: {busqueda: TxtBusqueda }}
	).then(function (respuesta) { // executa
		imprimirCategory(respuesta.data);
	}).catch(function (error){ 
		console.log(error);
	});
  }	
}

function imprimirCategory (lista) {
	console.log(lista);
	let resultadoBusqueda = document.getElementById("listaCategoryDiv");
	let textoCategory = "";
	for (let producto of lista ) {
		textoCategory = textoCategory + 
		`<div>
			<span> Producto: ${producto.productName}</span>
			<span> Precio: ${producto.unitPrice}</span>
			<input type="button" value="Anadir al Carrito" class="btn btn-dark" onclick=""/>
         </div>`;
         
	}
	resultadoBusqueda.innerHTML = textoCategory;
}