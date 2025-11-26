package com.example.gessoo3

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val questionField = findViewById<EditText>(R.id.Question)
        val answerField = findViewById<EditText>( R.id.Answer)
        val SaveBtn = findViewById<ImageView>( R.id.imageView)
        val cancelBtn = findViewById<ImageView>( R.id.imageView2)

        cancelBtn.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

        SaveBtn.setOnClickListener {

            val userQuestion = questionField.text.toString()
            val answerQuestion = answerField.text.toString()

            val data = Intent() // create a new Intent, this is where we will put our data

            data.putExtra(
                "string1",
                userQuestion
            ) // puts one string into the Intent, with the key as 'string1'

            data.putExtra(
                "string2",
                answerQuestion
            ) // puts another string into the Intent, with the key as 'string2

            setResult(RESULT_OK, data) // set result code and bundle data for response

            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}