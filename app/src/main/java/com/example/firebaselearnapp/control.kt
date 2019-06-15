package com.example.firebaselearnapp

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.View

import kotlinx.android.synthetic.main.activity_control.*
import kotlinx.android.synthetic.main.content_control.*
import kotlin.String as String1

class control : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "APPLICATION UNDER DEVELOPMENT", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            info.text= R.string.warning.toString()

        }
    }





}
