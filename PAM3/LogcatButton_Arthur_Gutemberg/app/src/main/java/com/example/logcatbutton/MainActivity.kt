
package com.example.logcatbutton

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.logcatbutton.ui.theme.LogcatButtonTheme

const val APP_TAG = "APP_TAREFAS"

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LogcatButtonTheme {
                TelaApp()
            }
        }
    }
}

@Composable
fun TelaApp() {

    var nome by remember { mutableStateOf("") }
    var tarefa by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFE3F2FD)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Controle de Tarefas",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFF0D47A1)
            )

            Text(
                text = "Arthur Gutemberg",
                color = Color(0xFF1565C0)
            )

            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Seu nome") }
            )

            TextField(
                value = tarefa,
                onValueChange = { tarefa = it },
                label = { Text("Tarefa realizada") }
            )

            BotaoAcao("Registrar") {
                Log.i(APP_TAG, "Usuario $nome registrou a tarefa: $tarefa")
            }

            BotaoAcao("Atualizar") {
                Log.d(APP_TAG, "Usuario $nome atualizou a tarefa: $tarefa")
            }

            BotaoAcao("Aviso") {
                Log.w(APP_TAG, "Usuario $nome gerou aviso na tarefa: $tarefa")
            }

            BotaoAcao("Erro") {
                Log.e(APP_TAG, "Erro na tarefa de $nome -> $tarefa")
            }

        }

    }

}

@Composable
fun BotaoAcao(texto: String, acao: () -> Unit) {

    ElevatedButton(
        onClick = acao,
        modifier = Modifier
            .fillMaxWidth(0.65f)
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = Color(0xFF1976D2),
            contentColor = Color.White
        )
    ) {

        Text(text = texto)

    }

}
