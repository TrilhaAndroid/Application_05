package br.com.leonardobarral.application_05

//import androidx.navigation.NavHost
//import androidx.navigation.compose.rememberNavController


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.leonardobarral.application_05.screens.LoginScreen
import br.com.leonardobarral.application_05.screens.MenuScreen
import br.com.leonardobarral.application_05.screens.PedidosScreen
import br.com.leonardobarral.application_05.screens.PerfilScreen
import br.com.leonardobarral.application_05.ui.theme.Application_05Theme

//import com.google.accompanist.navigation.animation.composable


class MainActivity : ComponentActivity() {
//    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Application_05Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
//                    val navController = rememberAnimatedNavController()

                    NavHost(
//                    AnimatedNavHost(
//                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "login",
//                        exitTransition = {
//                            slideOutOfContainer(
//                                towards = AnimatedContentTransitionScope.SlideDirection.End,
//                                tween(2000) // Especifique a duração em milissegundos
//                            ) + fadeOut(
//                                animationSpec = tween(2000)
//                            )
//                        },
//                        enterTransition = {
//                            slideIntoContainer(
//                                towards = AnimatedContentTransitionScope.SlideDirection.Down,
//                                tween(2000) // Especifique a duração em milissegundos
//                            )
//                        }

                    ) {

                        composable(route = "login") {
                            LoginScreen(navController)
                        }

                        composable(
                            route = "menu?nome={nome}",
                            arguments = listOf(
                                navArgument(name = "nome") {
                                    type = NavType.StringType
                                    defaultValue = ""
                                }
                            )) {
                            MenuScreen(
                                navController,
                                it.arguments?.getString("nome")!!
                            )
                        }


                        composable(route = "perfil/{nome}/{numero}") {
                            PerfilScreen(
                                navController,
                                it.arguments?.getString("nome")!!,
                                it.arguments?.getString("numero")!!
                            ) //double bang
                        }


                        composable(
                            route = "pedidos?numero={numero}",
                            arguments = listOf(navArgument(name = "numero") {
                                defaultValue = "Nenhm pedido selecionado"
                            }
                            )
                        ) {
                            PedidosScreen(navController, it.arguments?.getString("numero")!!)
                        }
                    }
                }
            }
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ActivityPreview() {
    Application_05Theme {
//        LoginScreen()
//        MenuScreen()
//        PerfilScreen()
//        PedidosScreen()
    }
}
