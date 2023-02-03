package com.temi.temi_speak_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.robotemi.sdk.*


class MainActivity : AppCompatActivity() {
    private lateinit var robot: Robot


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        robot.speak(TtsRequest.create("hi, i'm temi. Please enter something that you want me to say"))
        val textinput = findViewById<EditText>(R.id.text_field)
        val textview = findViewById<TextView>(R.id.text_view)
        val button = findViewById<Button>(R.id.btn_submit)

        button.setOnClickListener{
            val text = textinput.text.toString()
            if(!text.isEmpty()){
                textview.text = "$text"
                robot.speak(TtsRequest.create("$text"))
            }
            else {
                Toast.makeText(this, "Please enter text in textfield", Toast.LENGTH_SHORT).show()
                textview.text = ""
                robot.speak(TtsRequest.create("text field is empty. Please enter something"))
            }
        }
    }
}
