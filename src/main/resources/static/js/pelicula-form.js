const d = document;
const $form = d.getElementById("pelicula-form");
const $spinner = d.querySelector(".spinner-loader");

d.addEventListener("submit", (e) => {
  e.preventDefault();

  $spinner.classList.remove("none");

  const form = new FormData($form);

  const selectClasificacion = d.getElementById("select-clasificacion");
  // console.log(selectClasificacion.value);

  const checkboxes = document.querySelectorAll(
    'input[type="checkbox"]:checked'
  );
  const generosSeleccionados = [];

  checkboxes.forEach((checkbox) => {
    var generoId = checkbox.getAttribute("data-genero-id");
    generosSeleccionados.push(generoId);
  });

  const body = {
    titulo: form.get("titulo"),
    duracion: form.get("duracion"),
    sinopsis: form.get("sinopsis"),
    clasificacion: selectClasificacion.value,
    generos: generosSeleccionados,
  };

  if (generosSeleccionados.length == 0) {
    console.log("Selecciona generos");
    $spinner.classList.add("none");
    Swal.fire({
      text: "Seleccion por lo menos un genero",
      icon: "error",
    });
    return;
  }

  console.log($form);
  registrarPelicula(body);
});

const registrarPelicula = async (body) => {
  try {
    const resp = await fetch("http://localhost:8080/api/peliculas", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    });

    const data = await resp.json();

    if (data.id) {
      console.log(`Se registro la pelicula ${data.titulo}`);
      // Quitar loader
      $spinner.classList.add("none");
      // const alerta = await Swal.fire({
      //   title: "Listo!",
      //   text: "La pelicula a sido creada",
      //   icon: "success",
      //   confirmButtonText: "Volver al inicio",
      //   allowOutsideClick: false,
      // });

      // if (alerta.isConfirmed) {
      //   location.replace("http://localhost:8080/");
      // }
      location.replace(`http://localhost:8080/pelicula/formimg/${data.id}`);
    }
  } catch (error) {
    console.log(error);
  }
};
