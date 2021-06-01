package br.com.brq.treinefacil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.brq.treinefacil.objects.User

class MainActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var botao: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        carregarElementos()

        botao.setOnClickListener(){
            val usuario = User(email.text.toString(), password.text.toString())
            val validaEmail = usuario.validaLogin()
            val validaSenha = usuario.validaSenha()

            if(validaEmail && validaSenha){
                startActivity(Intent(this, Menu::class.java))
            }
            else{
                if(!validaEmail){
                    email.error = "E-mail Incorreto"
                }
                if(!validaSenha){
                    password.error = "Senha Incorreta"
                }
            }
        }
    }
    fun carregarElementos(){
        email = findViewById(R.id.et_email)
        password = findViewById(R.id.et_password)
        botao = findViewById(R.id.b_login)
    }
}