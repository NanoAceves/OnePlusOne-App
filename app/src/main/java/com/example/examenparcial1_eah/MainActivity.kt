package com.example.examenparcial1_eah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

//private val TAG = "MainActivity"
private val TEXT = "TEXT_OUTPUT"

class MainActivity : AppCompatActivity() {


    private var textResult: TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput1: EditText= findViewById<EditText>(R.id.editText1)
        val userInput2: EditText= findViewById<EditText>(R.id.editText2)
        val userInput3: EditText= findViewById<EditText>(R.id.editText3)

        userInput1.text.clear()
        userInput2.text.clear()
        userInput3.text.clear()

        textResult=findViewById<TextView>(R.id.textView)

        var bAgregar: Button=findViewById<Button>(R.id.button2)
        var bLimpiar: Button=findViewById<Button>(R.id.button)

        bAgregar?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?){
                if (textResult?.text=="Cuadro de Texto: Resultado"){
                    textResult?.text=""
                }
                if (userInput1.getText().toString().trim().equals("") || userInput2.getText().toString().trim().equals("") || userInput3.getText().toString().trim().equals("")){

                }else{
                    textResult?.append(userInput1?.text)
                    textResult?.append(" + ")
                    textResult?.append(userInput2?.text)
                    textResult?.append(" = ")
                    textResult?.append(userInput3?.text)
                    textResult?.append("\n")
                    userInput1?.text?.clear()
                    userInput2?.text?.clear()
                    userInput3?.text?.clear()
                }

            }
        })

        bLimpiar?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?){
                textResult?.text=""
                userInput1?.text?.clear()
                userInput2?.text?.clear()
                userInput3?.text?.clear()
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT, textResult?.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textResult?.text=savedInstanceState.getString(TEXT)
    }
}

