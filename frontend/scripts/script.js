async function enviarFormulario(event) {
    event.preventDefault();

    const nombre = document.getElementById('nombre').value;
    const email = document.getElementById('email').value;
    const mensaje = document.getElementById('mensaje').value;

    if (!nombre || !email || !mensaje) {
        alert('Por favor, completa todos los campos.');
        return;
    }

    const datos = { nombre, email, mensaje };

    try {
        const response = await fetch('http://localhost:8080/contacto/save', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(datos)
        });

        const textoRespuesta = await response.text();

        if (response.ok) {
            alert('¡Éxito! ' + textoRespuesta);
            document.getElementById('contactForm').reset();
        } else {
            console.error('Error del servidor:', textoRespuesta);
            alert('Error al enviar: ' + textoRespuesta);
        }
    } catch (error) {
        console.error('Error de red:', error);
        alert('No se pudo conectar con el servidor. Verifica que el backend esté corriendo.');
    }
}  