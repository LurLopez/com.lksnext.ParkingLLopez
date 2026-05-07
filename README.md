# 🚗 Gestor de Parking - LKS Next

Proyecto de aplicación Android para la gestión de plazas de parking, desarrollado como parte del Aula de Empresa de LKS Next (UPV/EHU).

## 🎨 Diseño y Prototipo
El diseño visual y la experiencia de usuario (UX/UI) de la aplicación se han planificado previamente. Puedes explorar el diseño interactivo en el siguiente enlace:
* **[Ver prototipo interactivo en Figma](https://star-cursor-06478954.figma.site)**

## 🚀 Estado actual del desarrollo
* Actualmente se están implementando las funcionalidades e interfaces de **Login** y **Registro (Register)** utilizando Jetpack Compose y navegación moderna (Single-Activity).

## 🌿 Organización del Repositorio (GitFlow)
Para mantener un entorno de trabajo ordenado y profesional, el proyecto utiliza la estrategia de ramas de GitFlow:
* **`master`**: Rama principal que contiene únicamente el código estable y funcional.
* **`develop`**: Rama de integración donde se unen todos los avances comprobados.
* **`feature/*`**: Ramas de trabajo individuales (por ejemplo, `feature/login`) donde se desarrolla cada nueva funcionalidad de forma aislada.

## 🔍 Calidad del Código (Integración Continua)
He configurado un flujo de trabajo automático mediante **GitHub Actions**. Cada vez que se hace un *commit* o se abre una *Pull Request*, el código se envía a **SonarCloud** para realizar un análisis estático de calidad de forma automática. 

Esto me permite detectar y solucionar posibles fallos, vulnerabilidades o *code smells* antes de fusionar el código con la rama `develop`.
