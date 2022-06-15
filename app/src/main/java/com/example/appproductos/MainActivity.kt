package com.example.appproductos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btntoAltaProducto : Button = findViewById(R.id.toAltaProducto)
        val btntoVerProducto : Button = findViewById(R.id.toVerProducto)

        btntoAltaProducto.setOnClickListener {
            val ventanaAltaProducto : Intent = Intent(this, AltaProducto::class.java)
            startActivity(ventanaAltaProducto)
        }

        btntoVerProducto.setOnClickListener {
            val ventanaVerProductos : Intent = Intent(this, VerProductos::class.java)
            startActivity(ventanaVerProductos)
        }
    }
}