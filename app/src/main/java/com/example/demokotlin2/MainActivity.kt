package com.example.demokotlin2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var Al : ArrayList<Produit>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            Al= intent.getSerializableExtra("liste") as ArrayList<Produit>
        }
        catch (ex:java.lang.Exception)
        {
            Al=ArrayList<Produit>()
        }
       var btn:Button=findViewById(R.id.btn1) as Button
        var btn2:Button=findViewById(R.id.btn2) as Button

        // var txt: EditText =findViewById(R.id.txt) as EditText
       // txt.setText(Al.size.toString())

        btn.setOnClickListener{

            var itt=Intent(applicationContext,AjoutActivity::class.java)
        itt.putExtra("liste",Al)
            startActivity(itt)
        }
        btn2.setOnClickListener{

            var itt=Intent(applicationContext,VendreActivity::class.java)
            itt.putExtra("liste",Al)
            startActivity(itt)
        }
    }
}