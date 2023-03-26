package com.example.hw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        intent?.extras?.let {
            val value1 = it.getString("key1")
            val value2 = it.getString("key2")

            val bundle = Bundle()
            bundle.putString("key1",value1.toString())
            bundle.putString("key2",value2.toString())

            val button = findViewById<Button>(R.id.button2)
            button.setOnClickListener{
                val value3 = findViewById<TextView>(R.id.editTextTextPassword3)
                val value4 = findViewById<TextView>(R.id.editTextTextPassword5)
                bundle.putString("key3","尺寸: "+value3.text.toString())
                bundle.putString("key4","顏色: "+value4.text.toString())
                setResult(Activity.RESULT_OK, Intent().putExtras(bundle))
                finish()
            }
        }
    }
}