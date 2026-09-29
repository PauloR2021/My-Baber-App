package com.prsoftware.mybarberapp.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prsoftware.mybarberapp.data.session.UsuarioSession


@Composable
fun HomeScreen(
    onLogout : () -> Unit,
    onNovoAgendamento : () -> Unit,
    onMeusAgendamentos : () -> Unit,
    onMeuPerfil : () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button (
            onClick = {onLogout()},
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(
                text = "Logout",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Barber APP",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Olá,${UsuarioSession.nome}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "O que deseja fazer? ",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        // BOTÃO PARA IR PARA A TELA DE NOVO AGENDAMENTO
        Button(
            onClick ={},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(" ✂️ Novo Agendamento")
        }

        Spacer(modifier = Modifier.height(5.dp))

        // BOTÃO PARA IR PARA A TELA DE MEUS AGENDAMENTOS
        Button(
            onClick ={},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(" \uD83D\uDCC5 Meus Agendamentos  ")
        }

        Spacer(modifier = Modifier.height(5.dp))

        // BOTÃO PARA IR PARA A TELA DE MEU PERFIL
        Button(
            onClick ={onMeuPerfil()},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("\uD83D\uDC64 Meu Perfil    ")
        }

    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview(){
    MaterialTheme(){
        HomeScreen (
            onLogout = {},
            onNovoAgendamento = {},
            onMeusAgendamentos = {},
            onMeuPerfil = {}
        )
    }

}