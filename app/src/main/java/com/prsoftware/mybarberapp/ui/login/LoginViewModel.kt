/*
* Class: Responsável por injetar a regra de negocio da tela
* Tela de Login: Realiza a validação dos dados inseridos pelo usuário
* Valida se o usuário tem cadastro no banco de dados
* Realiza o login para dentro do sistema
*
* Author: Paulo Ricardo
*/

package com.prsoftware.mybarberapp.ui.login
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prsoftware.mybarberapp.data.remote.RetrofitClient
import com.prsoftware.mybarberapp.data.remote.dto.login.LoginRequest
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    var email by mutableStateOf("")
        private set

    var senha by mutableStateOf("")
        private set

    var mensagem by mutableStateOf("")
        private set

    var loginRealizado by mutableStateOf(false)
        private set

    fun onEmailChange(novoEmail: String) {
        email = novoEmail
    }


    fun onSenhaChange(novaSenha: String) {
        senha = novaSenha
    }


    fun entrar(){

        if(email.isBlank() || senha.isBlank()){
            mensagem = "Preencha e-mail e senha"
            return
        }

        viewModelScope.launch {
            try{
                val request = LoginRequest(
                    email = email,
                    senha = senha
                )
                val response =
                    RetrofitClient.api.login(request)

                if(response.isSuccessful){
                    val usuario = response.body()

                    if(usuario != null){
                        mensagem = "Bem-vindo, ${usuario.nome}"
                    }

                    loginRealizado = true
                }else{
                    mensagem = "E-mail ou senha inválidos"

                    loginRealizado = false
                }
            }catch(e: Exception){
                mensagem = "Erro ao conectar com o servidor"
            }
        }
    }
}