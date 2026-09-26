/*
* Class: Responsável por gerenciar o APP.
* Chama a Tela do login quando o APP inicia
*
* Author: Paulo Ricardo
*/

package com.prsoftware.mybarberapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.prsoftware.mybarberapp.ui.login.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme{
                LoginScreen()
            }
        }

    }
}
