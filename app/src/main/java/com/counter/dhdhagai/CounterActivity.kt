package com.counter.dhdhagai

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity

class CounterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.counter_activity)
    }
}