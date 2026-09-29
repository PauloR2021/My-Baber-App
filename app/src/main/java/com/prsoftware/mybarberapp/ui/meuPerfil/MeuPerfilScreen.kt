package com.prsoftware.mybarberapp.ui.meuPerfil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prsoftware.mybarberapp.data.session.UsuarioSession

@Composable
fun MeuPerfilScreen(
    viewModel: MeuPerfilViewModel = viewModel(),
    onHome : () -> Unit
){

    LaunchedEffect(viewModel.trocaSenhaRealizado) {

        if (viewModel.trocaSenhaRealizado) {
            onHome()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        Button (
            onClick = {onHome()},
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(
                text = " 🏠 Home",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Meu Perfil",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = UsuarioSession.id?.toString() ?: "",
            onValueChange = {},
            label = {Text("ID")},
            modifier = Modifier.fillMaxWidth(),
            readOnly = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = UsuarioSession.nome,
            onValueChange = {},
            label = {Text("Nome")},
            modifier = Modifier.fillMaxWidth(),
            readOnly = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = UsuarioSession.email,
            onValueChange = {},
            label = {Text("Email")},
            modifier = Modifier.fillMaxWidth(),
            readOnly = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = UsuarioSession.role,
            onValueChange = {},
            label = {Text("Acesso")},
            modifier = Modifier.fillMaxWidth(),
            readOnly = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Realizar a troca de senha ?",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = viewModel.senha,
            onValueChange = {viewModel.onSenhaChange(it)},
            label = {Text("Senha")},
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = viewModel.confirmarSenha,
            onValueChange = {viewModel.onConfirmarSenha(it)},
            label = {Text("Confirmar Senha")},
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = viewModel.mensagem,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.Red
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick ={viewModel.alterarSenha()},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Alterar Senha")
        }



    }

}

@Preview(
    showBackground = true,
)
@Composable
fun MeuPerfilPreview(){
    MaterialTheme(){
        MeuPerfilScreen(
            onHome = {}
        )
    }
}