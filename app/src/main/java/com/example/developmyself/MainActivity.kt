package com.example.developmyself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zeroButton.setOnClickListener{setTextFields("0")}
        button1.setOnClickListener{setTextFields("1")}
        button2.setOnClickListener{setTextFields("2")}
        button3.setOnClickListener{setTextFields("3")}
        button4.setOnClickListener{setTextFields("4")}
        button5.setOnClickListener{setTextFields("5")}
        button6.setOnClickListener{setTextFields("6")}
        button7.setOnClickListener{setTextFields("7")}
        button8.setOnClickListener{setTextFields("8")}
        button9.setOnClickListener{setTextFields("9")}
        minusButton.setOnClickListener{setTextFields("-")}
        plusButton.setOnClickListener{setTextFields("+")}
        multiplyButton.setOnClickListener{setTextFields("*")}
        divideButton.setOnClickListener{setTextFields("/")}
        rightBracketButton.setOnClickListener{setTextFields(")")}
        leftBracketButton.setOnClickListener{setTextFields("(")}

        allClearButton.setOnClickListener{
            mathOperation.text = ""
            resultText.text = ""
        }

        backButton.setOnClickListener{
            val str = mathOperation.text.toString()
            if(str.isNotEmpty())
                mathOperation.text = str.substring(0, str.length - 1)
            resultText.text = ""
        }
        equalButton.setOnClickListener{
            try{
                val ex = ExpressionBuilder(mathOperation.text.toString()).build()
                val result = ex.evaluate() 

                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    resultText.text = longRes.toString()
                else
                    resultText.text = result.toString()
            }catch (e: Exception){
                Log.d("Error", "Message: ${e.message}")
                mathOperation.text = ""
                resultText.text = ""
            }
        }
    }

    fun setTextFields(str: String){
        if(resultText.text != ""){
            mathOperation.text = resultText.text
            resultText.text = ""
        }

        mathOperation.append(str)

    }
}