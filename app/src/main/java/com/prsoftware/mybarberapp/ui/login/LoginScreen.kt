package com.prsoftware.mybarberapp.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen(){
    var email by remember {
        mutableStateOf("")
    }

    var senha by remember {
        mutableStateOf("")
    }

    var mensagem by remember {
        mutableStateOf("")
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
            value = email,
            onValueChange = {email= it},
            label = {Text("E-mail")},
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),

        )

        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = senha,
            onValueChange = {senha = it},
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
            onClick ={

            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text("Entrar")
        }

        TextButton(
            onClick = {}
        ) {
            Text("Criar um Conta")
        }


    }

}

@Preview(
    showBackground = true,
    showSystemUi = true,
    widthDp = 360,
    heightDp = 800
)
@Composable
fun LoginScreenPreview(){
    MaterialTheme(){
        LoginScreen()
    }
}