package com.myapp.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.nio.file.Files.find

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        var b=findViewById<Button>(R.id.btnStart)

        b.setOnClickListener(){
            var t=findViewById<EditText>(R.id.nameText)
            if(t.text.isEmpty())
            {
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show()
            }
            else
            {
                val intent=Intent(this,Questions::class.java)
                intent.putExtra(Constants.USER_NAME,t.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }

}