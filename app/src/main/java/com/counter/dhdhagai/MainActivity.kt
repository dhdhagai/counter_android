package com.counter.dhdhagai

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton: Button = findViewById(R.id.button)

        myButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val myIntent = Intent(this@MainActivity, CounterActivity::class.java)
                myIntent.putExtra("Enabled", true)
                startActivity(myIntent)
            }
        })
        val radioButton: RadioButton = findViewById(R.id.button2)
        radioButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                showToast("Enabled 1")
            }
        })
    }
    private fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}