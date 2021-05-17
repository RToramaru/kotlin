package com.example.applicationnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.iid.FirebaseInstanceId

class MainActivity : AppCompatActivity() {

    lateinit var btnSend:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend = findViewById(R.id.bottom_send_notification)
        btnSend.setOnClickListener{
            this.showNotification("1234", "Notificação", "Testando notificação")
        }

        Log.i("**newToken", FirebaseInstanceId.getInstance().token.toString())
    }
}