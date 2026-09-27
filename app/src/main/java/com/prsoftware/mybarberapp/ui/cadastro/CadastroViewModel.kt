/*
* Class - Responsavel por controlar as ações da tela de Cadastro de Usuário
* Realiza a validação do Retrofit com a API Spring
*
* Author: Paulo Ricardo
*/

package com.prsoftware.mybarberapp.ui.cadastro
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prsoftware.mybarberapp.data.remote.RetrofitClient
import com.prsoftware.mybarberapp.data.remote.dto.usuario.UsuarioRequest
import kotlinx.coroutines.launch

class CadastroViewModel: ViewModel (){

    var nome by mutableStateOf("")
        private set

    var email by mutableStateOf("")
        private set

    var senha by mutableStateOf("")
        private set

    var confirmarSenha by mutableStateOf("")
        private set

    var mensagem by mutableStateOf("")
        private set

    var cadastroRealizado by mutableStateOf(false)
        private set

    fun onNomeChange(novoNome : String){
        nome = novoNome
    }
    fun onEmailChange(novoEmail : String){
        email = novoEmail
    }

    fun onSenhaChange(novaSenha : String){
        senha = novaSenha
    }

    fun onConfirmarSenha(novoConfirmarSenha : String){
        confirmarSenha = novoConfirmarSenha
    }

    fun cadastrar(){

        if(nome.isBlank() || email.isBlank() || senha.isBlank() || confirmarSenha.isBlank()){
            mensagem = "Preencha todos os campos de cadastro"
            return
        }

        if(senha.length <6){
            mensagem = "A senha deve ter pelo menos 6 caracteres"
            return
        }

        if (senha != confirmarSenha) {
            mensagem = "As senhas não coincidem"
            return
        }

        viewModelScope.launch {
            try {
                val request = UsuarioRequest(
                    nome = nome,
                    email = email,
                    senha = senha
                )
                val response = RetrofitClient.api.cadastrar(request)

                if(response.isSuccessful){
                    cadastroRealizado = true
                }else{
                    mensagem = "Não foi possivel cadastrar o usuário"
                }

            }catch (e: Exception){
                mensagem = "Erro ao conectar com o servidor"
            }
        }

    }

}
