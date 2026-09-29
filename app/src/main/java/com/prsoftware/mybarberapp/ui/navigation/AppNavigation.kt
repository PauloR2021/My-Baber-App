/*
* Funcao: Responsavel por gerenciar as rotas das telas dentro do APP
* "startDestination" - Inicia qual rota vai abrir por primeiro quando o APP é inicializado
* "Composable" - Faz a denclaração das rotas e seus parametros
* Chama o nome do Arquivo da Tela, aonde está o layout
* Pode passar todos os parametros que a tela vai receber para validar as configurações
*
* Author: Paulo Ricardo
* */


package com.prsoftware.mybarberapp.ui.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.prsoftware.mybarberapp.ui.cadastro.CadastroScreen
import com.prsoftware.mybarberapp.ui.home.HomeScreen
import com.prsoftware.mybarberapp.ui.login.LoginScreen
import com.prsoftware.mybarberapp.ui.meuPerfil.MeuPerfilScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ){
        // LOGIN
       composable("login"){
           LoginScreen(
               // PARAMETRO PARA VALIDAR SE FOI REALIZADO O LOGIN COM SUCESSO
               // SUCESSO - TRUE VAI PARA A TELA DE HOME
               onLoginSucesso = {
                   navController.navigate("home"){
                       popUpTo("login"){
                           inclusive = true
                       }
                   }
               },

               // PARAMETRO PARA IR PARA A TELA DE CADASTRO
               onCadastro = {
                   navController.navigate("cadastro")
               }
           )
       }

        // CADASTRO
        composable("cadastro"){
            CadastroScreen(
                // PARAMETRO PARA VOLTAR PARA A TELA DE LOGIN
                onVoltar = {
                    navController.popBackStack()
                }
            )
        }


        // HOME
        composable("home"){
            HomeScreen(
                onLogout = {
                    navController.navigate("login")
                },
                onNovoAgendamento = {

                },
                onMeusAgendamentos = {

                },
                onMeuPerfil = {
                    navController.navigate("meuPerfil")

                }
            )
        }

        // NOVO AGENDAMENTO
        composable ("novoAgendamento"){}

        // MEUS AGENDAMENTOS
        composable ("meusAgendamento"){}

        // MEU PERFIL
        composable ("meuPerfil"){
            MeuPerfilScreen(
                onHome = {
                    navController.popBackStack()
                }

            )
        }
    }
}