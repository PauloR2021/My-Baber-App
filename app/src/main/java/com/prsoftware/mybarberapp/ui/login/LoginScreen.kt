/*
* Fun: Responsável por ter a estrutura do layout da interface para o cliente
*
* Author: Paulo Ricardo
*/


package com.prsoftware.mybarberapp.ui.login
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import androidx.compose.runtime.LaunchedEffect


@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    onLoginSucesso: () -> Unit,
    onCadastro: () -> Unit
)
{
    LaunchedEffect(viewModel.loginRealizado) {

        if (viewModel.loginRealizado) {
            onLoginSucesso()
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
            text="Barber App",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = "Login",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value =viewModel.email,
            onValueChange = {viewModel.onEmailChange(it)},
            label = {Text("E-mail")},
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),

        )

        Spacer(modifier = Modifier.height(16.dp))
        
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
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick ={viewModel.entrar()},
            modifier = Modifier.fillMaxWidth()
        ){
            Text("Entrar")
        }

        // MENSAGEM DO LOGIN
        if (viewModel.mensagem.isNotBlank()) {

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            if(viewModel.mensagem.equals("E-mail ou senha inválidos")){
                Text(
                    text = viewModel.mensagem,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.Red
                )
            }else{
                Text(
                    text = viewModel.mensagem,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }


        TextButton(
            onClick = {onCadastro()}
        ) {
            Text("Criar um Conta")
        }

        Spacer(modifier = Modifier.height(24.dp))

    }

}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun LoginScreenPreview(){
    MaterialTheme(){
        LoginScreen(
            onLoginSucesso = {},
            onCadastro = {}
        )
    }
}
