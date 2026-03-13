
# Coffee Jazz - Manual de Instalación Local

## Requisitos Previos

- **Java 21+** (JDK)
- **Maven 3.8+**
- **Node.js y npm** (Para levantar el servidor web)
- **Git**

## 1. Clonar el repositorio

```bash
git clone https://github.com/dam-ops1/coffee-jazz.git
cd coffee-jazz
```

## 2. Configuración del Backend (Spring Boot)

### a) Variables y archivos necesarios

- Verifica que el archivo `serviceAccountKey.json` esté en `coffee-jazz-backend/src/main/resources/`.
- Revisa y ajusta las variables en `application.properties` según tu entorno.

### b) Compilar y ejecutar

Desde la carpeta del backend:

```bash
cd coffee-jazz-backend
.\mvnw clean install
.\mvnw spring-boot:run
```

El backend debería estar disponible en:  
`http://localhost:8080`

## 3. Configuración del Frontend

Puedes usar una extensión de VS Code como "Live Server" o instalar un servidor simple:

```bash
npm install -g serve
cd frontend
serve .
```

Esto servirá el frontend en `http://localhost:3000` (o el puerto que indique la terminal).

## 5. Notas adicionales

- Si usas base de datos o servicios externos, revisa la configuración en `application.properties`.
- Si tienes problemas con dependencias, ejecuta `mvnw clean install -U` para forzar la actualización.

