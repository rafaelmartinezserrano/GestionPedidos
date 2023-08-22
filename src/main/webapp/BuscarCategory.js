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
	let resultadoBusqueda = document.getElementById("listaCancionesDiv");
	let textoAudio = "";
	for (let cancion of lista ) {
		textoAudio = textoAudio + 
		`<div>
			<span> Titulo: ${cancion.titulo}</span>
			<audio controls="controls" controlsList="nodownload">
				<source src="${"Canciones/"+ cancion.urlFichero}" type="audio/mpeg"/> 
			</audio>
			<input type="button" value="Borrar" class="btn btn-danger" onclick="borrarCancion(${cancion.idCancion}, '${cancion.urlFichero}');"/>
			<input type="button" value="Ver Letra" class="btn btn-dark" onclick="letraCancion('${cancion.titulo}');"/>
         </div>`;
         
	}
	resultadoBusqueda.innerHTML = textoAudio;
}