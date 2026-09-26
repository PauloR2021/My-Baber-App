/*
* Data Class: Responsável por enviar para a API o e-mail e senha de login
*
* Author: Paulo Ricardo
*/


package com.prsoftware.mybarberapp.data.remote.dto

data class LoginRequest(
    val email : String,
    val senha : String
){}
