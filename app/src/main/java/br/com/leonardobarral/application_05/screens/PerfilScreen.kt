package br.com.leonardobarral.application_05.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun PerfilScreen(
    navController: NavController,
    nome: String,
    numero: String
) {



    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4CAF50))
            .padding(horizontal = 100.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row (
            modifier = Modifier
                .minimumInteractiveComponentSize()
        ){
            Text(
                text = "PERFIL - $nome - $numero",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Start,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

        }
        Row (
            modifier = Modifier
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(
                onClick = {
                    navController.navigate("menu")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
//                    .offset(y = (-150).dp)
            ) {
                Text(
                    text = "Voltar",
                    color = Color.Blue,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }

        }

    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PerfilScreenPreview() {
//    PerfilScreen()
//}