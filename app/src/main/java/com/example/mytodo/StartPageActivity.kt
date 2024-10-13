package com.example.mytodo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StartPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)

        val floatingActionButton =
            findViewById<FloatingActionButton>(R.id.floatingActionButtonstartpage)
        floatingActionButton.setOnClickListener {
            // Navigate to another activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}