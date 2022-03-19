package com.myapp.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class Questions : AppCompatActivity(),View.OnClickListener {
    var ql=ArrayList<QuestionsInfo>()
    var currentPosition=1
    var selectedOption:Int=0
    var correctAnswers:Int=0
    var username:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        username=intent.getStringExtra(Constants.USER_NAME)


        ql=Constants.getQuestionsInfo()

        setQuestion()
        var option1=findViewById<TextView>(R.id.o1)
        var option2=findViewById<TextView>(R.id.o2)
        var option3=findViewById<TextView>(R.id.o3)
        var option4=findViewById<TextView>(R.id.o4)

        var butt = findViewById<Button>(R.id.btnSubmit)

        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)
        butt.setOnClickListener(this)

    }
    private fun setQuestion()
    {
        defaultOption()

        var butt = findViewById<Button>(R.id.btnSubmit)
        if(currentPosition==ql.size)
        {
            butt.text="FINISH"
        }
        else
            butt.text="Submit"
        var curprogress=findViewById<ProgressBar>(R.id.progressBar)
        var currquestion=ql[currentPosition-1]

        curprogress.progress=currentPosition
        var textP=findViewById<TextView>(R.id.progressText)
        textP.text="$currentPosition"+"/"+curprogress.max


        var q=findViewById<TextView>(R.id.QuizQuestion)
        q.text=currquestion.question

        var option1=findViewById<TextView>(R.id.o1)
        var option2=findViewById<TextView>(R.id.o2)
        var option3=findViewById<TextView>(R.id.o3)
        var option4=findViewById<TextView>(R.id.o4)

        option1.text=currquestion.optionOne
        option2.text=currquestion.optionTwo
        option3.text=currquestion.optionThree
        option4.text=currquestion.optionFour

        var qImage=findViewById<ImageView>(R.id.imgQuestion)
        qImage.setImageResource(currquestion.image)
    }
    //reset options
    private fun defaultOption()
    {
        var options=ArrayList<TextView>()
        var option1=findViewById<TextView>(R.id.o1)
        var option2=findViewById<TextView>(R.id.o2)
        var option3=findViewById<TextView>(R.id.o3)
        var option4=findViewById<TextView>(R.id.o4)

        options.add(option1)
        options.add(option2)
        options.add(option3)
        options.add(option4)

        for(o in options)
        {
            o.setTextColor(Color.parseColor("#7A8089"))
            o.typeface= Typeface.DEFAULT
            o.background=ContextCompat.getDrawable(this,R.drawable.default_option)
        }
    }

    override fun onClick(v: View?) {
        var option1=findViewById<TextView>(R.id.o1)
        var option2=findViewById<TextView>(R.id.o2)
        var option3=findViewById<TextView>(R.id.o3)
        var option4=findViewById<TextView>(R.id.o4)
        when(v?.id)
        {
            R.id.o1->{
                selectedOption(option1,1)
            }
            R.id.o2->{
                selectedOption(option2,2)
            }
            R.id.o3->{
                selectedOption(option3,3)
            }
            R.id.o4->{
                selectedOption(option4,4)
            }
            R.id.btnSubmit->{
                if(selectedOption==0)
                {
                    currentPosition++
                    if(currentPosition<=ql.size)
                    {
                        setQuestion()
                    }
                    else
                    {
                       // Toast.makeText(this, "You have Completed the quiz", Toast.LENGTH_SHORT)
                          //  .show()
                        var intent=Intent(this,Result_UI::class.java)
                        intent.putExtra(Constants.USER_NAME,username)
                        intent.putExtra(Constants.CORRECT_ANSWERS,correctAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS,ql.size)
                        startActivity(intent)
                    }
                }
                else
                {
                    val q=ql[currentPosition-1]
                    if(q.correctAnswer!=selectedOption)
                    {
                        answerView(selectedOption,R.drawable.wrong_option)
                    }
                    else {
                        correctAnswers++
                    }
                    answerView(q.correctAnswer,R.drawable.correct_option)

                    var butt = findViewById<Button>(R.id.btnSubmit)
                    if(currentPosition==ql.size)
                    {
                        butt.text="FINISH"
                    }
                    else
                        butt.text="Go to Next Question"
                    selectedOption=0
                }
            }
        }
    }
    //reset options and select an option
    private fun selectedOption(tv:TextView,num:Int)
    {
        defaultOption()
        selectedOption=num

        tv.setTextColor(Color.parseColor("#363A43"))

        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.select_option)
    }
    //view the wrong and right options
    private fun answerView(answer:Int,dView:Int)
    {
        var option1=findViewById<TextView>(R.id.o1)
        var option2=findViewById<TextView>(R.id.o2)
        var option3=findViewById<TextView>(R.id.o3)
        var option4=findViewById<TextView>(R.id.o4)

        if(answer==1)
        {
            option1.background=ContextCompat.getDrawable(this,dView)
        }
        if(answer==2)
        {
            option2.background=ContextCompat.getDrawable(this,dView)
        }
        if(answer==3)
        {
            option3.background=ContextCompat.getDrawable(this,dView)
        }
        if(answer==4)
        {
            option4.background=ContextCompat.getDrawable(this,dView)
        }

    }
}
