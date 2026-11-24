# Medícate

Proyecto intermodular de 2.º de DAM. Medícate es una aplicación Android para organizar medicamentos y tomas de perfiles locales. El proyecto usa Kotlin, Jetpack Compose y Material 3 en un único módulo `app`.

## Abrir y compilar

1. Abre la raíz del repositorio en Android Studio y sincroniza Gradle.
2. Usa JDK 17 o superior para Gradle e instala el SDK de Android 37.1 desde el gestor de SDK.
3. Ejecuta la configuración `app` en un emulador o dispositivo con Android 8.0 (API 26) o superior.

Para generar el APK de depuración desde la terminal, ejecuta `./gradlew :app:assembleDebug`. En Windows, usa `gradlew.bat :app:assembleDebug`.

## Organización del código

El código Kotlin está en `app/src/main/java/com/medicate/app`. `MainActivity` carga la interfaz de Compose y aplica el tema de `ui/theme`. La pantalla inicial muestra el nombre de la aplicación.

El equipo añadirá estos paquetes conforme implemente las funcionalidades siguiendo MVVM:

- `ui/screens` y `ui/components` para pantallas y componentes reutilizables.
- `viewmodel` para gestionar el estado y las acciones de cada pantalla.
- `data` para repositorios, entidades y acceso a la base de datos local.
- `navigation` para las rutas entre pantallas.
