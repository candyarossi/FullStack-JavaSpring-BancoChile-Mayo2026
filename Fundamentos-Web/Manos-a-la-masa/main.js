var sandwich = {
  pan: "masa madre",
  proteína: "asado",
  queso: "queso suizo lacey",
  salsas: ["lechuga romana", "tomates reliquia", "salsa de rábano"],
};

console.log(sandwich);

function sandwichFactory(pan, proteína, queso, salsas) {
  var sandwich = {};
  sandwich.pan = pan;
  sandwich.proteína = proteína;
  sandwich.queso = queso;
  sandwich.salsas = salsas;
  return sandwich;
}

var s1 = sandwichFactory("trigo", "pavo", "provolone", [
  "mostaza",
  "cebolla frita",
  "rúcula",
]);
console.log(s1);

/* Fabrica de pizzas V1 */

function fabricaPizzasV1(tipoCorteza, salsa, quesos, salsas) {
  let pizza = {};
  pizza.tipoCorteza = tipoCorteza;
  pizza.salsa = salsa;
  pizza.quesos = quesos;
  pizza.salsas = salsas;
  return pizza;
}

/* Fabrica de pizzas V2 */

let fabricaPizzasV2 = function (tipoCorteza, salsa, quesos, salsas) {
  let pizza = {
    tipoCorteza: tipoCorteza,
    salsa: salsa,
    quesos: quesos,
    salsas: salsas,
  };
  return pizza;
};

/* Fabrica de pizzas V3 */

let fabricaPizzasV3 = (tipoCorteza, salsa, quesos, salsas) => {
  return {
    tipoCorteza: tipoCorteza,
    salsa: salsa,
    quesos: quesos,
    salsas: salsas,
  };
};

/* Pruebas */

let pizzaV1 = fabricaPizzasV1(
  "lanzada a mano",
  "marinara",
  ["mozzarella", "feta"],
  ["champiñones", "aceitunas", "cebollas"],
);
let pizzaV2 = fabricaPizzasV2(
  "lanzada a mano",
  "marinara",
  ["mozzarella", "feta"],
  ["champiñones", "aceitunas", "cebollas"],
);
let pizzaV3 = fabricaPizzasV3(
  "lanzada a mano",
  "marinara",
  ["mozzarella", "feta"],
  ["champiñones", "aceitunas", "cebollas"],
);

console.log(pizzaV1);
console.log(pizzaV2);
console.log(pizzaV3);
