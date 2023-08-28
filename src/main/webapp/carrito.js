/**
 * 
 */
 
 function changeQuantity(valor, idProduct){
	 let textQuantity = document.getElementById("quantity"+idProduct);
	 let quantity = parseInt(textQuantity.value) + valor;
	 if (quantity > 0) {
		 textQuantity.value = quantity;
		 axios.post(
			 "ChangeQuantityFromCarrito",
			 null,
			 {params: {cant: quantity, idProduct: idProduct}}
		 ).then(function(respuesta){
			//No es necesario repintar el carrito, porque ya se modificó el valor de la caja de texto
			 console.log(respuesta.data);
		 }).catch(function(error){
			 console.error(error);
		 });
	 }
 }
 
 function deleteProduct(product){
	 axios.post(
		 "DeleteProductFromCarrito",
		 null,
		 {params: {prod: product}}
	 ).then(function(respuesta){
		 printCart(respuesta.data);
	 }).catch(function(error){
		 console.log(error);
	 })
 }
 
 function printCart(carrito){
	 let prodInCartList = document.getElementById("prodInCartList");
	 let list = ""
	for(let i of carrito.listOD){
		list += `
			<ul>
				<li>
					<div class="btn_box">
						<input type="button" value="-" id="btnDeleteOne" onclick="changeQuantity(-1, ${i.product.productID});">
						<input type="number" readonly="readonly" value="<%=${i.quantity} %>" id="quantity">
						<input type="button" value="+" id="btnAddOne" onclick="changeQuantity(1, ${i.product.productID});">
					<div class="prodDetail">
						<%=${i.product} %>
					</div>
					</div>
					<div class="btnDelete_box" id="btnDeleteAll">
						<img alt="delete" src="Imagenes/itemCarritoDelete.png" id="itemDelete" onclick="deleteProduct(${i.product.productID});">
					</div>
				</li>
			</ul>
		`;
	}
	prodInCartList.innerHTML = list;
 }
 
 
 
 
 
 
 