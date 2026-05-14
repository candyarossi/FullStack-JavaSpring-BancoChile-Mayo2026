// Comentario de una línea

/*
Comentario de 
varias líneas
 */

/**
 * PALABRAS RESERVADAS:
 * break, case, catch, continue, default, let, delete, do, else, finally, for, function,
 * if, in, instanceof, new, return, switch, this, throw, try, typeof, var, void, while,
 * with, y varias más...
 */

/**
 * TIPOS DE VALORES:
 * - Number (números)
 * - Strings (cadenas de caracteres)
 * - Boolean (true o false)
 * - Object (objetos)
 * - Array (arreglos)
 * - Null
 * - Undefined
 */

let numero;
console.log(numero);
numero = 3;
console.log(numero);

// Variables en ES5

var nombre;
nombre = "Cande";

// Variables en ES6

let apellido;
apellido = "Yarossi";

const cohorte = "BancoChile";
cohorte = "567";

// OPERACIONES básicas con números

let num1 = 2;
let num2 = 6;

let suma = num1 + num2;
let resta = num2 - num1;
let multiplicacion = num1 * num2;
let division = num2 / num1;

// OPERACIONES básicas con strings

let str1 = "Banco";
let str2 = "Chile";

let rta1 = str1 + str2;
let rta2 = str1 + " de " + str2;
let rta3 = str1 + 1;
let rta4 = "1" + 1;
let rta5 = "1" - 1;
let rta6 = "a" - 1;
let rta7 = 1 + "1";

console.log(rta7);

/* CONDICIONALES */

if (true) {
  console.log("Soy un if con condicion TRUE");
}

if (false) {
  console.log("Soy un if con condicion FALSE");
}

/**
 * COMPARACIONES
 * == -> Es igual
 * === -> Es estrictamente igual
 * != -> Es distinto
 * !== -> Es estrictamente distinto
 * <, >, <=, <= -> Menor, mayor, menor/igual, mayor/igual
 */

let nro = 5;

if (nro === "5") {
  console.log("Es igual");
}

if (nro == 4) {
  console.log("Es igual");
}

if (nro == 4) {
  console.log("Es igual a 4");
} else {
  console.log("No es igual a 4");
}

if (nro == 4) {
  console.log("Es igual a 4");
} else if (nro < 4) {
  console.log("Es menor a 4");
} else if (nro > 4) {
  console.log("Es mayor a 4");
} else {
  console.log("No es un número");
}

let nro = 5;
let esMenorA10 = nro < 10;

if (esMenorA10) {
  console.log("Es menor");
}

let nombre1 = "Cande";

if (nombre1) {
  console.log("HOLA!");
}

/**
 * OPERADORES LOGICOS
 * AND -> &&
 * OR -> ||
 * NOT -> !
 *
 * - Tablas de Verdad -> Álgebra de Boole
 */

console.log("AND: ");

console.log("- true AND true: ", true && true);
console.log("- true AND false: ", true && false);
console.log("- false AND true: ", false && true);
console.log("- false AND false: ", false && false);

console.log("OR: ");

console.log("- true OR true: ", true || true);
console.log("- true OR false: ", true || false);
console.log("- false OR true: ", false || true);
console.log("- false OR false: ", false || false);

console.log("NOT: ");

console.log("- NOT true: ", !true);
console.log("- NOT false: ", !false);

console.log("");

let nombre = "";
let nro = 5;
let esMenorA10 = nro < 10;

// false  &&   true     &&   true
//      false           &&   true
//             false
if (nombre && esMenorA10 && nro == 5) {
  console.log("Hola mundo 1");
}

// false  ||    true    ||   true
//       true           ||   true
//              true
if (nombre || esMenorA10 || nro == 5) {
  console.log("Hola mundo 2");
}

// false  || (   true    &&    true )
// false  ||         (true)
//             true
if (nombre || (esMenorA10 && nro == 5)) {
  console.log("Hola mundo 3");
}

/**CICLOS
 *
 * - por conteo -> FOR
 * - condicionales -> WHILE
 */

// FOR
// Factorial -> 4! = 4*3*2*1

let nro = 4;
let factorial = 1;

for (let i = 1; i <= nro; i++) {
  factorial = factorial * i;
}

console.log(factorial);

// WHILE

let nro2 = 4;
let factorial2 = 1;
let i = 1;

while (i <= nro2) {
  factorial2 = factorial2 * i;
  i++;
}

console.log(factorial2);
