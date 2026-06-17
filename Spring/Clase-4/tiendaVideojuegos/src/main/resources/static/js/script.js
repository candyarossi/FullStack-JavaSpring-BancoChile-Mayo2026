let botonesPrecio = document.querySelectorAll(".precio");
let arrayBotones = Array.from(botonesPrecio);
arrayBotones.shift();

let coins = document.querySelector("#coins").innerText.slice(1);

arrayBotones.forEach((btn) => {
  let precio = btn.innerText.slice(1);

  if (Number(precio) < Number(coins)) {
    btn.onmouseover = function () {
      this.innerText = "Comprar";
    };

    btn.onmouseout = function () {
      this.innerText = "$" + precio;
    };
  } else {
    btn.style.backgroundColor = "#151515";
    btn.style.color = "lightcoral";
    btn.style.border = "1px solid lightcoral";
    btn.href = "#";
  }
});
