// DOM -> Document Object Model

console.log(document);
console.log(document.body);
console.log(document.head);

console.dir(document);
console.dir(document.body);
console.dir(document.head);

// ACCESO AL DOM

// getElementById()
let itemXid = document.getElementById("item2");
console.log(itemXid);

// getElementsByClassName()
let enlacesXclass = document.getElementsByClassName("enlaces");
console.log(enlacesXclass);

// FOR .. OF
for (let enlace of enlacesXclass) {
  console.log(enlace);
}

// getElementsByTagName()
let itemsXtag = document.getElementsByTagName("li");
console.log(itemsXtag);

for (let item of itemsXtag) {
  console.log(item);
}

// MODIFICAR ELEMENTOS

// innerText
console.log(itemXid.innerText);
itemXid.innerText = "Nuevo Item 2";

// innerHTML
console.log(itemXid.innerHTML);
itemXid.innerHTML =
  '<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxn81f8dZh8W4HPCT3bSV1_EsxFKejWu5k7Q&s" width="20%" />';

// className / id
let segundoEnlace = enlacesXclass[1];

console.log(segundoEnlace.className);
console.log(segundoEnlace.id);

segundoEnlace.className = "nuevaClase";
segundoEnlace.className += " otraClase";
segundoEnlace.id = "enlace2";

console.log(segundoEnlace);

// AGREGAR ELEMENTOS
let lista = document.getElementById("lista");

let nuevoItem = document.createElement("li");
nuevoItem.innerText = "Item 4";

lista.append(nuevoItem);

// QUITAR ELEMENTOS
itemXid.remove();

// ACCESO AL DOM

// querySelector()

// Seleccion por ID
let listaXquery = document.querySelector("#lista");
console.log(listaXquery);

// Seleccion por Class
let enlaceXquery = document.querySelector(".enlaces");
console.log(enlaceXquery);

// Seleccion por Tag/Etiqueta
let tituloXquery = document.querySelector("h1");
console.log(tituloXquery);

// querySelectorAll()
let enlacesXqueryAll = document.querySelectorAll(".enlaces");
console.log(enlacesXqueryAll);

for (let enlace of enlacesXqueryAll) {
  console.log(enlace);
}

// EVENTOS

// Opcion 1: addEventListener()
let btn1 = document.getElementById("btn1");

btn1.addEventListener("click", respuestaClick);

function respuestaClick() {
  console.log("Click de BTN1");
}

// Opcion 2: propiedades de nodos (onNombreEvento)
let btn2 = document.getElementById("btn2");

btn2.onclick = () => {
  console.log("Click de BTN2");
};

// Opcion 3: atributos HTML (onNombreEvento) -> en HTML

// EVENTOS DEL MOUSE
let input1 = document.querySelector("#texto1");

input1.onclick = () => {
  console.log("INPUT CLICK");
};

input1.onmousemove = () => {
  console.log("INPUT MOVE");
};

// EVENTOS DEL TECLADO
let input2 = document.querySelector("#numero1");

input2.onkeyup = () => {
  console.log("INPUT KEYUP");
};

input2.onkeydown = () => {
  console.log("INPUT KEYDOWN");
};

// EVENTOS CHANGE/INPUT
let input3 = document.querySelector("#texto2");

input3.oninput = (e) => {
  console.log("EVENTO INPUT");
};

input3.onchange = (e) => {
  console.log("EVENTO CHANGE");
  console.log(e);
  console.dir(e.target);
  console.log(e.target.value);
};

// EVENTO SUBMIT
let form = document.querySelector("#formulario");

form.addEventListener("submit", enviarInformacion);

function enviarInformacion(e) {
  e.preventDefault();

  let inputsFormulario = e.target.children;

  console.log(inputsFormulario[0].id + ":" + inputsFormulario[0].value);
  console.log(inputsFormulario[1].id + ":" + inputsFormulario[1].value);
  console.log(inputsFormulario[2].id + ":" + inputsFormulario[2].value);
  console.log(inputsFormulario[3].id + ":" + inputsFormulario[3].value);

  let reset = document.getElementById("resetBtn");
  reset.click();
}
