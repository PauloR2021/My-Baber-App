/*
* Data Class - Responsavel por armazenar as informaçoes do novo usuario para cadastro
*
* Author: Paulo Ricardo
*/

package com.prsoftware.mybarberapp.data.remote.dto
data class UsuarioRequest(
    val nome : String,
    val email : String,
    val senha : String
)
