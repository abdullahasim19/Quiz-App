package com.myapp.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result_UI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_ui)
        var username=intent.getStringExtra(Constants.USER_NAME)
        var correct=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        var total=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)

        var txt=findViewById<TextView>(R.id.name)
        txt.setText("Username: ${username}")
        var res=findViewById<TextView>(R.id.result)
        res.setText("Your Score is ${correct}/${total}")

        var b=findViewById<Button>(R.id.btn)
        b.setOnClickListener{
            var i=Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        }

    }
}

