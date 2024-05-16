package com.example.autenticaaofirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class TelaInicio : AppCompatActivity() {
    private val autentication by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicio)
        val email = findViewById<TextView>(R.id.txtMail)
        val txtemail = intent.getStringExtra("email")
        email.setText(txtemail)
        val txtsenha = intent.getStringExtra("senha")
        val btnsair = findViewById<Button>(R.id.btSair)
        email.text = autentication.currentUser?.email
        btnsair.setOnClickListener {
            logout()
        }
    }

    fun logout() {
        autentication.signOut()
        finish()
    }
}