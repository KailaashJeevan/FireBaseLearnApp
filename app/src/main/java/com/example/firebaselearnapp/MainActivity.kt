package com.example.firebaselearnapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var fba: FirebaseAnalytics? =null
    private var aut: FirebaseAuth? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fba= FirebaseAnalytics.getInstance(this)
        aut=FirebaseAuth.getInstance()


    }
    fun loginNow(view:View){

        val email=email.text.toString()
        val password:String=pass.text.toString()

        run(email,password)
    }

    private fun run(email:String, password:String){

        aut!!.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){ task->
                if(task.isSuccessful)
                {
                    Toast.makeText(applicationContext,"LOGIN SUCCESSFUL",Toast.LENGTH_LONG).show()

                    val cuu=aut!!.currentUser
                    Log.d("Login", cuu!!.uid)
                }
                else{
                    Toast.makeText(applicationContext,"FAIL LOGIN",Toast.LENGTH_LONG).show()

                }
            }

    }

    override fun onStart() {
        super.onStart()
        val cUsr=aut!!.currentUser
        if(cUsr!=null)
        {
            val intent=Intent(this, control::class.java)
            startActivity(intent)
        }



    }
}
