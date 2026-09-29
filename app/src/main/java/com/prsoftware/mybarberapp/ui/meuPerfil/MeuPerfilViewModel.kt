package com.prsoftware.mybarberapp.ui.meuPerfil

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.prsoftware.mybarberapp.data.remote.RetrofitClient
import com.prsoftware.mybarberapp.data.remote.dto.usuario.TrocarSenhaRequest
import com.prsoftware.mybarberapp.data.session.UsuarioSession
import kotlinx.coroutines.launch

class MeuPerfilViewModel : ViewModel (){

    var senha by mutableStateOf("")
        private set

    var confirmarSenha by mutableStateOf("")
        private set

    var mensagem by mutableStateOf("")
        private set

    var trocaSenhaRealizado by mutableStateOf(false)
        private set

    fun onSenhaChange(novaSenha : String){
        senha = novaSenha
    }

    fun onConfirmarSenha(novoConfirmarSenha : String){
        confirmarSenha = novoConfirmarSenha
    }

    fun alterarSenha(){

        if(senha.isBlank() || confirmarSenha.isBlank()){
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
                Log.e("API","Iniciando a troca de senha")
                val request = TrocarSenhaRequest(
                    email = UsuarioSession.email,
                    senha = senha
                )

                Log.e("API", request.toString())

                val response = RetrofitClient.api.trocarSenha(request)

                Log.d("API", "HTTP CODE: ${response.code()}")
                Log.d("API", "SUCESSO: ${response.isSuccessful}")
                Log.d("API", "BODY: ${response.body()}")

                if(response.isSuccessful){
                    trocaSenhaRealizado = true

                }else{
                    val erro = response.errorBody()?.string()

                    Log.e("API", "HTTP ${response.code()}")
                    Log.e("API", "ERROR BODY: $erro")
                    mensagem = "Não foi possivel trocar a senha do usuário"
                }

            }catch (e : Exception){
                mensagem = "Erro ao conectar com o servidor"
            }
        }

    }


}