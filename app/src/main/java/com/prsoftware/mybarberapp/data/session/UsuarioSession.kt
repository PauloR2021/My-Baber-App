package com.prsoftware.mybarberapp.data.session

object UsuarioSession {

    var id: Long? = null
        private set
    var nome: String = ""
        private set

    var email: String = ""
        private set

    var role: String = ""
        private set

    fun salvar(
        id: Long,
        nome: String,
        email: String,
        role: String
    ){
        this.id = id
        this.nome = nome
        this.email = email
        this.role = role
    }

    fun limpar() {
        id = null
        nome = ""
        email = ""
        role = ""
    }
}