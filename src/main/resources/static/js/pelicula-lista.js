const d = document;

const $pelicualLista = d.querySelector(".pelicula-lista");

d.addEventListener("DOMContentLoaded", (e) => {
  fetch("http://localhost:8080/api/peliculas")
    .then((resp) => resp.json())
    .then((data) => {
      console.log(data);

      let elementos = "";

      data.forEach((element) => {
        elementos += generaHtmlItem(element);
      });

      $pelicualLista.innerHTML = elementos;
    });
});

d.addEventListener("click", (e) => {
  if (e.target.matches(".eliminar-pelicula")) {
    const $btnEliminar = e.target;
    const id = $btnEliminar.getAttribute("data-pelicula-id");

    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: "btn btn-success",
        cancelButton: "btn btn-danger",
      },
      buttonsStyling: false,
    });

    Swal.fire({
      title: "¿Estas seguro de realizar esta acción?",
      text: "No se podrá revertir la acción",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si",
      ancelButtonText: "No, cancelar!",
    }).then((result) => {
      if (result.isConfirmed) {
        // Swal.fire("Deleted!", "Your file has been deleted.", "success");
        console.log("eliminado");
        fetch(`http://localhost:8080/api/peliculas/${id}`, {
          method: "DELETE",
        })
          .then((resp) => resp.status)
          .then((status) => {
            console.log(status);
            location.replace(`http://localhost:8080/pelicula/lista`);
          });
      }
    });
  }
});

const generaHtmlItem = (item) => {
  let urlImg =
    item.imagen == null || item.imagen == ""
      ? "/img/no-image.jpg"
      : item.imagen;
  return `
    <div class="pelicula-item">
        <div class="pelicula-link">
		    <div class="image-container">
				<a href="/pelicula/formimg/${item.id}">
					<img src="${urlImg}"
						alt="Imagen">
					<div class="image-overlay">
						<span>Acutalizar imagen</span>
					</div>
				</a>
			</div>

			<div class="pelicula-desc">
				<h3 class="pelicula-titulo">${item.titulo}</h3>
				<p class="pelicula-generos">${item.generos}</p>
				<p class="pelicula-generos">${item.sinopsis}</p>
            </div>
            </div>
            <div class="btn-group">
                
                <button class="btn eliminar-pelicula text-danger" data-pelicula-id="${item.id}" class="btn">
                    <img src="/svg/x-circle.svg">
                    Eliminar
                </button>
                <a class="btn" href="/pelicula/detalle/${item.id}">Ver detalle</a>
                        
         </div>
    </div>`;
};
