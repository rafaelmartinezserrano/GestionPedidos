// document.getElementById("CajaTxt").addEventListener("keyup" , buscarCategory)
 
 
 
  function buscarCategory () {
	let TxtBusqueda = document.getElementById("select").value;
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
		`<ul class="listaCategoryDiv">
			<li> Producto: <span>${producto.productName}</span></li>
			<li> Precio: <span>${producto.unitPrice}</span></li>
			<input type="button" value="Anadir al Carrito" class="btn btn-light" style="background-color: #F279B2" onclick=""/>
         </ul>`;
         
	}
	resultadoBusqueda.innerHTML = textoCategory;
}