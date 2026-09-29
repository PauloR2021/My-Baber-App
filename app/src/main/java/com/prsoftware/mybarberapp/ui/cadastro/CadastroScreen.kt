/*
* Fun: Responsável por ter a estrutura do layout para Cadastrar novos clientes
*
* Author: Paulo Ricardo
*/

package com.prsoftware.mybarberapp.ui.cadastro
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
import androidx.compose.material3.TextButton
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

@Composable
fun CadastroScreen(
    viewModel: CadastroViewModel = viewModel(),
    onVoltar: () -> Unit
){

    LaunchedEffect(viewModel.cadastroRealizado) {

        if (viewModel.cadastroRealizado) {
            onVoltar()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Cadastrar-se no APP",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Realize agora seu cadastro",
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = viewModel.nome,
            onValueChange = {viewModel.onNomeChange(it)},
            label = {Text("Nome")},
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = viewModel.email,
            onValueChange = {viewModel.onEmailChange(it)},
            label = {Text("Email")},
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
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

        Button(
            onClick ={viewModel.cadastrar()},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cadastrar")
        }

        // MENSAGEM DE CONFIRMAÇÃO DO CADASTRO
        if (viewModel.mensagem.isNotBlank()) {

            Spacer(
                modifier = Modifier.height(12.dp)
            )
            Text(
                text = viewModel.mensagem,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.Red
            )
        }

        TextButton(
            onClick ={onVoltar()},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun CadastroScreenPreview(){
    MaterialTheme(){
        CadastroScreen(
            onVoltar = {}
        )
    }
}