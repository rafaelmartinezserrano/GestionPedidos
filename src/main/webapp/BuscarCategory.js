 document.getElementById("CajaTxt").addEventListener("keyup" , buscarCategory)
 
 
 
  function buscarCategory () {
	let TxtBusqueda = document.getElementById("CajaTxt").value;
	// post é o metodo usado HTTP
	if(TxtBusqueda != ""){
		axios.post(
		//nome do SERVLET
		"BuscarCancionesPorTitulo", 
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
	for (let category of lista ) {
		textoCategory = textoCategory + 
		`<div>
			<span> Titulo: ${category.titulo}</span>
			<audio controls="controls" controlsList="nodownload">
				<source src="${"/"+ category.urlFichero}" type=""/> 
			</audio>
			<input type="button" value="Anadir al Carrito" class="btn btn-dark"/>
         </div>`;
         
	}
	resultadoBusqueda.innerHTML = textoCategory;
}