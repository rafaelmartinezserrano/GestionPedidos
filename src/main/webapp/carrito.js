/**
 * 
 */
 
 function deleteOne(){
	 let quantity = 1;
	 axios.post(
		 "DeleteOneFromCarrito",
		 null,
		 {params: {cant: quantity}}
	 ).then(function(respuesta){
		 console.log(respuesta.data);
	 }).catch(function(error){
		 console.error(error);
	 });
 }
 
 function addOne(){
	 let quantity = 1;
	 axios.post(
		 "AddToCarrito",
		 null,
		 {params: {cant: quantity}}
	 ).then(function(respuesta){
		 console.log(respuesta.data);
	 }).catch(function(error){
		 console.error(error);
	 });
 }
 
 function deleteAll(product){
	 axios.post(
		 "DeleteFromCarrito",
		 null,
		 {params: {prod: product}}
	 ).then(function(respuesta){
		 printCart(respuesta.data);
	 }).catch(function(error){
		 console.log(error);
	 })
 }
 
 function printCart(carritoElementList){
	 let prodInCartList = document.getElementById("prodInCartList");
	 let list = ""
	for(let i of carritoElementList){
		list += `
			<ul>
				<li id="${i.getProduct()}">
					<div class="btn_box">
						<input type="button" value="-" id="btnDeleteOne">
						<input type="number" readonly="readonly" value="<%=${i.getQuantity()} %>" id="quantity">
						<input type="button" value="+" id="btnAddOne">
					<div class="prodDetail">
						<%=${i.getProduct()} %>
					</div>
					</div>
					<div class="btnDelete_box" id="btnDeleteAll">
						<img alt="delete" src="Imagenes/itemCarritoDelete.png" id="itemDelete" onclick="deleteAll(<%=${i.getProduct()}%>);">
					</div>
				</li>
			</ul>
		`
	}
	prodInCartList.innerHTML = list;
 }
 
 
 
 
 
 
 