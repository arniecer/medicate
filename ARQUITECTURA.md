# Arquitectura de Medícate

Medícate usa MVVM en un único módulo `app`. El código Kotlin está en `app/src/main/java/com/medicate/app`.

## Paquetes

| Ubicación | Responsabilidad y archivos |
| --- | --- |
| `MainActivity.kt` | Punto de entrada de Android. Carga la interfaz Compose y aplica el tema. |
| `ui/screens/` | Composables de pantalla organizados en `perfiles`, `inicio`, `tratamientos`, `detallemedicamento`, `inventario`, `renovaciones`, `historial` y `copias`. |
| `ui/components/` | Composables compartidos entre pantallas. |
| `ui/theme/` | Tema y estilos de Compose. |
| `ui/navigation/` | Rutas y grafo de navegación. La entrada prevista es la selección de perfil. El menú inferior tendrá Inicio, Inventario y Renovaciones. |
| `viewmodel/` | ViewModels que gestionan el estado y las acciones de cada pantalla. |
| `data/local/entity/` | Entidades que representan las tablas de Room. |
| `data/local/dao/` | Interfaces DAO con las consultas y operaciones de escritura de Room. |
| `data/local/database/` | Clase de base de datos Room que declara las entidades y expone los DAO. |
| `data/remote/api/` | Interfaces de Retrofit para consultar CIMA/AEMPS. |
| `data/remote/dto/` | Clases que representan las respuestas de la API. |
| `data/repository/` | Repositorios concretos que centralizan el acceso a los datos locales y remotos. |
| `data/preferences/` | Acceso a las preferencias de la aplicación mediante DataStore. |
| `notifications/` | Código de programación de recordatorios y receptores de alarmas. |

## Flujo MVVM

Por ejemplo, al abrir Inventario, la pantalla solicita los datos al ViewModel y observa su estado. El ViewModel consulta el repositorio, que usa el DAO para leer las entidades de Room. Con los datos recibidos, el ViewModel actualiza el estado que muestra la pantalla.

## Tecnologías

El proyecto ya usa Kotlin, Jetpack Compose y Material 3. Para el desarrollo posterior se prevén Navigation Compose, ViewModel, Coroutines y Flow/StateFlow, Room sobre SQLite, Retrofit para CIMA/AEMPS, DataStore y AlarmManager con BroadcastReceiver.

## Reglas de organización

- Extraer un composable a `ui/components/` cuando se reutilice en varias pantallas.
- Mantener en el ViewModel la lógica de pantalla, en el repositorio el acceso compartido a datos y en el DAO las consultas de Room.
- Pasar las dependencias por constructor al implementar las clases. Mantener clases concretas y añadir abstracciones solo cuando resuelvan una necesidad real.
