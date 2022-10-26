package com.example.demokotlin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get

class VendreActivity : AppCompatActivity() {
 lateinit var AL: ArrayList<Produit>
 lateinit var sp :Spinner
 lateinit var txt: TextView
 lateinit var btnCalculer: Button
    lateinit var btnFermer: Button
 lateinit var txtQte: EditText
 lateinit var rad: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendre)
        AL=intent.getSerializableExtra("liste") as ArrayList<Produit>
        var AA= ArrayAdapter<String>(applicationContext,android.R.layout.simple_list_item_1,AL.map { it.code })
        sp=findViewById(R.id.spLstPro) as Spinner
        txt=findViewById(R.id.txtPrix) as TextView
        btnCalculer=findViewById(R.id.btnCalculer) as Button
        btnFermer=findViewById(R.id.btnFermer) as Button
        txtQte=findViewById(R.id.txtQuantite) as EditText
        rad=findViewById(R.id.rad1) as RadioButton
        sp.adapter=AA

        sp.onItemSelectedListener =object :OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
               var P =AL.find{it.code==sp.getItemAtPosition(position).toString()}
                txt.text=P?.prix.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        btnCalculer.setOnClickListener{
            var x:Float =txt.text.toString().toFloat() * txtQte.text.toString().toInt()
            var Mt :Float =if (rad.isChecked) x+ txt.text.toString().toFloat()*0.2f else  x + txt.text.toString().toFloat()*0.1f
    Toast.makeText(applicationContext,"Le prix est :" + Mt.toString(),Toast.LENGTH_LONG).show()

        }
btnFermer.setOnClickListener{
    finish()
}
        }// oncreate


    }//Fin classe
