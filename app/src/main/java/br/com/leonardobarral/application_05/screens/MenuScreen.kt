package br.com.leonardobarral.application_05.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
fun MenuScreen(navController: NavController, nome: String) {
    var nomev by remember{
        mutableStateOf(nome)
    }
    var numerov by remember{
        mutableStateOf("")
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .padding(horizontal = 100.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row (
            modifier = Modifier
                .minimumInteractiveComponentSize()
        ){
            Text(
                text = "MENU",
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
                value = nomev,
                label = {
                        Text(text = "Nome")
                },
                onValueChange = {
                    nomev = it
                },
                placeholder = {
                    Text(text = "Escreva seu nome")
                }
            )

            Spacer(modifier = Modifier.height(20.dp))
            
            TextField(
                value = numerov
                ,
                label = {
                    Text(text = "Número")
                },
                onValueChange = {
                    numerov = it
                },
                placeholder = {
                    Text(text = "Escreva o número do pedido")
                },
            )
        }

        Column (
            modifier = Modifier
                .padding(vertical = 50.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceAround
        ){
            Button(
                onClick = {
                    if(nomev.isNotEmpty() && numerov.isNotEmpty()) {
                        navController.navigate("perfil/$nomev/$numerov")
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
//                    .offset(y=(-150).dp)
            ) {
                Text(
                    text = "Perfil",
                    color = Color.Blue,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }

            Column (
                modifier = Modifier
                    .height(160.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick ={

                        var option = "pedidos"
                        if(numerov.isNotEmpty()) option += "?numero=$numerov"
                        navController.navigate(option)

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
//                    .offset(y=(-150).dp)
                ) {
                    Text(
                        text = "Pedidos",
                        color = Color.Blue,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    onClick = {
                        navController.navigate("login")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
//                    .offset(y=(-150).dp)
                ) {
                    Text(
                        text = "Sair",
                        color = Color.Blue,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

        }

    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun MenuScreenPreview() {
//    MenuScreen()
//}