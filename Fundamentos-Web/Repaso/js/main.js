const climas = [
  {
    img: '<ion-icon name="rainy"></ion-icon>',
    temperatura: "3°C - 14°C",
    estado: "Tormentas",
  },
  {
    img: '<ion-icon name="cloudy"></ion-icon>',
    temperatura: "5°C - 12°C",
    estado: "Nublado",
  },
  {
    img: '<ion-icon name="partly-sunny"></ion-icon>',
    temperatura: "9°C - 18°C",
    estado: "Parcialmente Nublado",
  },
  {
    img: '<ion-icon name="sunny"></ion-icon>',
    temperatura: "15°C - 23°C",
    estado: "Soleado",
  },
];

// Funcionalidad 1
alert("Cargando Reporte del Clima.");

// Funcionalidad 2
document.querySelector("#btnAcepto").addEventListener("click", function () {
  document.querySelector("#cookies").style.display = "none";
});

// Funcionalidad 3
document.querySelectorAll(".ciudades").forEach((ciudad) => {
  ciudad.onclick = (event) => {
    document.querySelector("#ciudad").innerText = event.target.innerText;

    let cards = document.querySelectorAll(".card");

    for (let card of cards) {
      let nroRandom = Math.floor(Math.random() * 4);
      let clima = climas[nroRandom];

      card.children[0].innerHTML = clima.img;
      card.children[2].innerText = clima.estado;
      card.children[3].innerText = clima.temperatura;
    }

    document.querySelector("#container").style.display = "flex";
  };
});
