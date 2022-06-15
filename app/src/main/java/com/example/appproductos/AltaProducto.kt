package com.example.appproductos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class AltaProducto : AppCompatActivity() {
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alta_producto)

        val btnAltaProducto : Button = findViewById(R.id.botonAltaBD)
        val nombreReg = findViewById<EditText>(R.id.nombreRegistrado)
        val tallaReg = findViewById<EditText>(R.id.tallaRegistrada)
        val colorReg = findViewById<EditText>(R.id.colorRegistrado)
        val precioReg = findViewById<EditText>(R.id.precioRegistrado)

        btnAltaProducto.setOnClickListener {

            database = FirebaseDatabase.getInstance().getReference("Productos")
            val Producto = Producto(nombreReg.text.toString(), tallaReg.text.toString(), colorReg.text.toString(), precioReg.text.toString().toFloat())
            database.child(nombreReg.text.toString()).setValue(Producto).addOnSuccessListener {

                nombreReg.text.clear()
                tallaReg.text.clear()
                colorReg.text.clear()
                precioReg.text.clear()

                Toast.makeText(this, "Alta de Producto OK", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {

                Toast.makeText(this, "Error en el Alta", Toast.LENGTH_SHORT).show()

            }

        }




    }
}