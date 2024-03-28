package br.com.leonardobarral.application_05.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun LoginScreen(navController : NavController) {

    var nome by remember{
        mutableStateOf("")
    }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(horizontal = 100.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row (
            modifier = Modifier
                .minimumInteractiveComponentSize()
        ){
            Text(
                text = "LOGIN",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Start,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

        }
        Column(
            modifier = Modifier
                .minimumInteractiveComponentSize()
                .padding(top = 50.dp)
        ){

            TextField(
                value = nome,
                label = {
                    Text(text = "Nome")
                },
                onValueChange = {
                    nome = it
                },
                placeholder = {
                    Text(text = "Escreva seu nome")
                }
            )
        }
        Row (
            modifier = Modifier
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(
                onClick = {

                    var option = "menu"

                    if(nome.isNotEmpty()) option +="?nome=$nome"

                    navController.navigate(option)

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .offset(y = (-150).dp)
            ) {
                Text(
                    text = "Entrar",
                    color = Color.Blue,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }

        }

    }
}

//
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun LoginScreenPreview() {
//    LoginScreen()
//}