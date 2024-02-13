package com.example.homework16hackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework16hackathon.registration.RegistrationFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, RegistrationFragment()).commit()
    }
}