/**
 * 
 */
function visibilidad() {
	let inputEmpleado = document.getElementById("inputEmpleado");
	let inputCliente = document.getElementById("inputCliente");
	let divEmpleado = document.getElementById("empleado");
	let divCliente = document.getElementById("cliente");
	if (inputEmpleado.checked) {
		divEmpleado.style.display="block";
		divCliente.style.display="none";
		} else{
			divCliente.style.display="block";
			divEmpleado.style.display="none";
			}
}