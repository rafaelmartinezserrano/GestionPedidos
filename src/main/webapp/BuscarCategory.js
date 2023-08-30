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
		`<ul class="listaCategoryDiv" class="border border-dark-subtle">
			<li> Producto: <span>${producto.productName}</span></li>
<<<<<<< HEAD
			<li> Precio:  <span>${producto.unitPrice}</span></li>
			<input type="button" value="Anadir al Carrito" class="btn btn-light" style="background-color: #F279B2" onclick=""/>
=======
			<li> Precio: <span>${producto.unitPrice}</span></li>
			<input type="button" value="Añadir al Carrito" class="btn btn-light" style="background-color: #F279B2" onclick="addToCarrito(${producto.productID})"/>
			<li><a href="LoadProduct?busquedaId=${producto.productID}"> Modificar datos producto</a></li>
>>>>>>> 349b69b52ae3c992584d6d6a8454f457c75a24e6
         </ul>`;
         
	}
	resultadoBusqueda.innerHTML = textoCategory;
}

function addToCarrito(productID){
	
	axios.post(
		"AddToCarrito",
		null,
		{params:{productId:productID,
		quantity:1}}
	).then(
		function(respuesta){
			if(respuesta.status==200){
				console.log("Producto añadido al carrito")
			} else {
				console.log("Error HTTP")
			}
		}
	).catch(
		function(error){
			console.error(error);
		}
	)
	
}