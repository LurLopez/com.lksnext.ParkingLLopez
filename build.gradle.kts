// Archivo de la raíz: LKSProyecto/build.gradle.kts
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    id("org.sonarqube") version "5.0.0.4638" apply false // Asegúrate de que ponga 'apply false'
}