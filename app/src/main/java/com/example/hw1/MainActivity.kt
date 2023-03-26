package com.example.hw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val bundle = Bundle()
            val editTextTextPassword = findViewById<EditText>(R.id.editTextTextPassword)
            bundle.putString("key1",editTextTextPassword.text.toString())
            val editTextTextPassword4 = findViewById<EditText>(R.id.editTextTextPassword4)
            bundle.putString("key2",editTextTextPassword4.text.toString())

            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtras(bundle)
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.extras?.let{
            if(requestCode == 1 && resultCode == Activity.RESULT_OK) {
                findViewById<TextView>(R.id.textView7).text = it.getString("key1")
                findViewById<TextView>(R.id.textView8).text = it.getString("key2")
                findViewById<TextView>(R.id.textView4).text = it.getString("key3")
                findViewById<TextView>(R.id.textView6).text = it.getString("key4")
            }
        }
    }
}