/*
var btnMenu = document.getElementById('btn-menu');
var nav = document.getElementById('nav');

btnMenu.addEventListener('click', function () { //cuando hago click, a nav se le agrega clase mostrar
  nav.classList.toggle('mostrar');
});
*/
/*
function boot()
{
	var inputs = document.getElementsByTagName("input");

	var validate = function()
	{
		console.log("validating")
		console.log("user length"+document.formulario.usr.value.length)
		if (document.formulario.usr.value.length < 7)
		{
			
			document.formulario.submitBtn.setAttribute("disabled", "true");
			console.log(document.formulario.submitBtn.getAttribute("disabled"));
		}
		else
		{
			console.log("usr length succeed")
			document.formulario.submitBtn.setAttribute("disabled", "false");
			console.log(document.formulario.submitBtn.getAttribute("disabled"));
		}
			
	}
	
	console.log(inputs);
	
	[].forEach.call(inputs, input =>
	{
		input.addEventListener("keyup",validate);
		input.addEventListener("paste",validate);
		input.addEventListener("change",validate);
		});
}
*/

function validar(){
  if(!document.formulario.usr.value.length){
    alert("Completar nombre de usuario.");
  }
  else if(!document.formulario.clave.value.length){
    alert("Completar contraseña.");
  }
  else if (document.getElementById("log").value === "selec")
  {
	  alert("Elija un rol.");
  }
  else
  {
    var selectedValue = document.getElementById("log").value;
    switch(selectedValue){
           case "alumno":
           //window.open("http://127.0.0.1:49923/Alumno/index.html");
        	//llamar al BusinessDelegate   
        break;
          case "profesor":
            //window.open("http://127.0.0.1:49708/Profesor/index.html");
        	//llamar al BusinessDelegate  
        break;
          case "admin":
              //window.open("http://127.0.0.1:49708/Profesor/index.html");
          	//llamar al BusinessDelegate  
          break;
    }
  }
}