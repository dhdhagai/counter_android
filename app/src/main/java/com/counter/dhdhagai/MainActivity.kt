package com.counter.dhdhagai

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.counter.dhdhagai.ui.theme.COunterTheme

class MainActivity : ComponentActivity() {
    lateinit var radio : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        radio = findViewById(R.id.button)
        radio.setOnClickListener { radioListen }

    }
    var radioListen = View.OnClickListener (function = {
        Toast.makeText(this, "Testing", Toast.LENGTH_SHORT)
    })
}