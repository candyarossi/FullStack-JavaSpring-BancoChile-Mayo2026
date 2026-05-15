// ARRAYS / ARREGLOS
//   i   =   0    1    2    3
let array = ["a", "b", "c", "d"];
console.log(array);

// Acceso a valores
console.log(array[0]);
console.log(array[2]);
console.log(array[10]);

// Modificación de un valor
array[10] = "k";
console.log(array);

// Agregar Elementos
array.push("final");
console.log(array);

array.unshift("inicio");
console.log(array);

// Quitar elementos
let final = array.pop();
console.log(array);
console.log(final);

let inicio = array.shift();
console.log(array);
console.log(inicio);

// OBJETOS
let persona = {
  nombre: "Candela",
  apellido: "Yarossi",
  id: 39111111,
};

console.log(persona);

// Acceso a propiedades
console.log(persona.nombre);
console.log(persona["apellido"]);

persona.nombre = "Cande";
console.log(persona);

// Modificación de propiedades
persona["nombre"] = "Candy";
console.log(persona);

persona.colorFavorito = "Violeta";
console.log(persona);

persona["edad"] = 29;
console.log(persona);

// USO del 'this'
let persona = {
  nombre: "Candela",
  apellido: "Yarossi",
  id: 39111111,
  mostrarDatos: function () {
    return this.nombre + " " + this.apellido;
  },
  verObjeto: function () {
    return this;
  },
};

console.log(persona.mostrarDatos());
console.log(persona.verObjeto());

console.log(this);
console.log(global);

// OPERADOR IN
console.log("edad" in persona);
console.log("id" in persona);

if (!("edad" in persona)) {
  persona.edad = 18;
}

console.log(persona);

// FOR ... IN
for (let prop in persona) {
  if (prop === "mostrarDatos" || prop === "verObjeto") {
    continue;
  } else {
    console.log(prop + " -> " + persona[prop]);
  }
}

// ARRAYS DE OBJETOS
let user1 = { nombre: "User 1", email: "user1@mail.com", id: 1234 };
let user2 = { nombre: "User 2", email: "user2@mail.com", id: 5678 };
let user3 = { nombre: "User 3", email: "user3@mail.com", id: 9012 };

let users = [user1, user2, user3];

let newUser = { nombre: "New User", email: "newuser@mail.com", id: 3456 };
users.push(newUser);
console.log(users);

// FOR ... OF
for (let user of users) {
  console.log(user.nombre);
}

// FUNCIONES
function suma() {
  let nro1 = 9;
  let nro2 = 5;
  let rta = nro1 + nro2;
  console.log(rta);
}

suma();
suma();

// Función con parámetros
function sumaV2(nro1, nro2) {
  let rta = nro1 + nro2;
  console.log(rta);
}

sumaV2(2, 5);
sumaV2(8, 4);

// Función con retorno
function sumaV3(nro1, nro2) {
  let rta = nro1 + nro2;
  return rta;
}

let resultado = sumaV3(5, 8);
console.log(resultado);

// FUNCIONES ANÓNIMAS FUNCIONES FLECHA
let alto = 5;
let ancho = 8;

const calcularArea = function (alto, ancho) {
  return alto * ancho;
};

console.log("El area es: " + calcularArea(alto, ancho));

// FUNCIONES FLECHA
const calcularPerimetro = (alto, ancho) => (alto + ancho) * 2;

console.log("El perimetro es: " + calcularPerimetro(alto, ancho));

// FUNCIONES DE ARRAYS
let user1 = { nombre: "Daniela", email: "user1@mail.com", id: 1234 };
let user2 = { nombre: "Vanesca", email: "user2@mail.com", id: 5678 };
let user3 = { nombre: "Belen", email: "user3@mail.com", id: 9012 };
let user4 = { nombre: "Cynthia", email: "user4@mail.com", id: 3456 };

let users = [user1, user2, user3, user4];

// Splice
let userEliminado = users.splice(2, 1);
console.log(users);
console.log(userEliminado);

// Join
let letras = ["a", "b", "c"];
let strLetras = letras.join(" - ");
console.log(strLetras);

// Concat
let letras2 = ["d", "e", "f"];
let todasLasLetras = letras.concat(letras2);
console.log(todasLasLetras);

// Slice
let primeros2 = letras.slice(0, 2);
console.log(primeros2);

// IndexOf
let indexB = letras.indexOf("b");
let indexZ = letras.indexOf("z");

console.log(indexB);
console.log(indexZ);

// Includes
let rtaB = letras.includes("b");
let rtaZ = letras.includes("z");

console.log(rtaB);
console.log(rtaZ);

// Reverse
letras.reverse();
console.log(letras);

// Length
let tamano = letras.length;
console.log(tamano);

for (let i = 0; i < letras.length; i++) {
  console.log(letras[i]);
}
