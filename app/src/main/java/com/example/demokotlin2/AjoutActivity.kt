package com.example.demokotlin2

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class AjoutActivity : AppCompatActivity() {
  lateinit var AL:ArrayList<Produit>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajout)
        //Intent itt=intent en kotlin c'est intent
        AL=intent.getSerializableExtra("liste") as ArrayList<Produit>

        var btnE =findViewById(R.id.btnEnregistrer) as Button
        var btnF =findViewById(R.id.btnFermer) as Button
        btnE.setOnClickListener{

      var ADB : AlertDialog.Builder=AlertDialog.Builder(this@AjoutActivity)
            ADB.setTitle("Confirmation ajout")
                .setMessage("Etes-vous sûr de vouloir Enregistrer?")
                .setPositiveButton("Oui",
                    DialogInterface.OnClickListener
                    {d:DialogInterface,i:Int->
                        val P:Produit=Produit(findViewById<EditText>(R.id.txtCode).text.toString(),
                            findViewById<EditText>(R.id.txtDes).text.toString(),
                            findViewById<EditText>(R.id.txtPrix).text.toString().toFloat())
                        AL.add(P)

                    } )
                .setNegativeButton("non",
                DialogInterface.OnClickListener{
                        d:DialogInterface,i:Int->
                    d.cancel()
                }).setIcon(R.drawable.ic_launcher_background)
val AD:AlertDialog = ADB.create();
            AD.show();



        }
        btnF.setOnClickListener{
            var itt=Intent(applicationContext,MainActivity::class.java)
            itt.putExtra("liste",AL)
            startActivity(itt)}
    }
}