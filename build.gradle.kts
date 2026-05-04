plugins {
    // El "apply false" es OBLIGATORIO aquí arriba
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("org.sonarqube") version "5.0.0.4638" apply false
}