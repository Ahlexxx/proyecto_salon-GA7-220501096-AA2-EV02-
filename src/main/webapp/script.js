document.getElementById('citaForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const usuario = document.getElementById('usuario').value;
    const servicio = document.getElementById('servicio').value;
    const funcionario = document.getElementById('funcionario').value;
    const fecha = document.getElementById('fecha').value;
    const hora = document.getElementById('hora').value;

    const formData = new URLSearchParams();
    formData.append('usuario', usuario);
    formData.append('servicio', servicio);
    formData.append('funcionario', funcionario);
    formData.append('fecha', fecha);
    formData.append('hora', hora);

    fetch('/proyecto_salon/CitasServlet', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: formData.toString()
    })
    .then(response => response.json())
    .then(data => {
        if (data.status === 'success') {
            alert('Cita agendada con éxito!');
        } else {
            alert('Error al agendar la cita: ' + data.message);
        }
    })
    .catch(error => console.error('Error:', error));
});

