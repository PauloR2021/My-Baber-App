/*
* Interface: Responsável por ter todas os EndPoints da API
*
* Author: Paulo Ricardo
*/

package com.prsoftware.mybarberapp.data.remote
import com.prsoftware.mybarberapp.data.remote.dto.login.LoginRequest
import com.prsoftware.mybarberapp.data.remote.dto.usuario.ResponseUsuario
import com.prsoftware.mybarberapp.data.remote.dto.usuario.UsuarioRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    //Chamando o endpoint da API para dentro do Android
    //O Retorno da função é Response<String> porque na API o EndPoint retornar uma String
    @POST("/auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<ResponseUsuario>

    @POST("/auth/register")
    suspend fun cadastrar(
        @Body request: UsuarioRequest
    ): Response<ResponseUsuario>
}