package com.lksnext.ParkingLLopez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Importaciones para la navegación (¡Asegúrate de tener la librería en build.gradle.kts!)
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.lksnext.ParkingLLopez.ui.theme.LKSProyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LKSProyectoTheme {
                // 1. Inicializamos el controlador de navegación
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // 2. El NavHost gestiona qué pantalla se ve
                    NavHost(
                        navController = navController,
                        startDestination = "login", // Arranca en el login
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        // Ruta 1: Pantalla de Login
                        composable("login") {
                            LoginScreen(
                                // Le decimos qué hacer cuando pulse "Regístrate"
                                onNavigateToRegister = { navController.navigate("register") }
                            )
                        }

                        // Ruta 2: Pantalla de Registro
                        composable("register") {
                            RegisterScreen(
                                // Le decimos qué hacer cuando pulse "Inicia sesión"
                                onNavigateToLogin = { navController.popBackStack() },
                                onNavigateToVerify = { email -> /* De momento vacío */ }
                            )
                        }
                    }
                }
            }
        }
    }
}

// 3. Modificamos el LoginScreen para que reciba la acción de navegar
@Composable
fun LoginScreen(
    onNavigateToRegister: () -> Unit, // <--- Parámetro nuevo
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Gestor de Parking", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text(text = "Iniciar sesión", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email (@lksnext.com)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        TextButton(
            onClick = { /* Lógica de recuperar contraseña */ },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("¿Has olvidado tu contraseña?")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /* Lógica de entrar */ },
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            Text("ENTRAR", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 4. Se ejecuta la navegación al pulsar el botón
        TextButton(onClick = onNavigateToRegister) {
            Text("¿No tienes cuenta? Regístrate")
        }
    }
}