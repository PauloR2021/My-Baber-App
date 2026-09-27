/*
* Data Class: Responsável por pegar o retorno da API
* quando o usuário fazer o login e é bem sucessido
*
* Author: Paulo Ricardo
*/


package com.prsoftware.mybarberapp.data.remote.dto
data class ResponseUsuario(
    val id : Long,
    val nome : String,
    val email : String,
    val role : String
)
