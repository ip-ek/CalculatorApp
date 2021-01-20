package com.ipk.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    //her seferinde + ile concat yerine append w string builder
    var firstNumber:StringBuilder? = null
    var secondNumber:StringBuilder? = null
    var operation: StringBuilder? =null
    var resFlag:Boolean=true

    lateinit var text:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.setTheme(R.style.Theme_Light)
        clickersOfNumbers()
        clickersOfOperands()

        btn_eq.setOnClickListener {
            when(operation.toString()){
                "+" -> (text.append("\n="+(firstNumber.toString().toInt() + secondNumber.toString().toInt())))
                "-" -> (text.append("\n="+(firstNumber.toString().toInt() - secondNumber.toString().toInt())))
                "x" -> (text.append("\n="+(firstNumber.toString().toInt() * secondNumber.toString().toInt())))
                "/" -> (text.append("\n="+(firstNumber.toString().toInt() / secondNumber.toString().toInt().toDouble())))
                else -> text.append("\n="+firstNumber.toString().toInt())
            }
            reset()
        }

        btn_ac.setOnClickListener {
            reset()
            text.setText("0")
        }

        btn_theme.setOnClickListener {

        }
    } //onCreate

    fun reset(){
        resFlag=true
        if(!firstNumber.isNullOrBlank()){
            firstNumber!!.setLength(0)
        }
        if(!secondNumber.isNullOrBlank()){
            secondNumber!!.setLength(0)
        }
        if (!operation.isNullOrBlank()){
            operation!!.setLength(0)
        }
    }

    fun numberClicked(num:String){
        if (resFlag==true){
            text.setText("")
            resFlag=false
        }
        if (operation.isNullOrBlank()){
            if (firstNumber.isNullOrBlank()){
                firstNumber=StringBuilder(num)
            }else{
                firstNumber!!.append(num)
            }
            text.append(num)
        }else{
            if (secondNumber.isNullOrBlank()){
                secondNumber=StringBuilder(num)
            }else{
                secondNumber!!.append(num)
            }
            text.append(num)
        }
    } //numberClicked

    fun opClicked(op:String){
        //önceki girilen silinmeli
        if (!operation.isNullOrBlank()){
            var txt=text.getText().toString()
            text.setText(txt.substring(0, txt.length-1))
        }
        operation = StringBuilder(op)
        text.append(op)
    }

    fun clickersOfOperands(){
        btn_sum.setOnClickListener {
            opClicked("+")
        }

        btn_sub.setOnClickListener {
            opClicked("-")
        }

        btn_mul.setOnClickListener {
            opClicked("x")
        }

        btn_div.setOnClickListener {
            opClicked("/")
        }
    } //clickersOfOperands

    fun clickersOfNumbers(){
        btn_0.setOnClickListener {
            numberClicked("0")
        }

        btn_1.setOnClickListener {
            numberClicked("1")
        }

        btn_2.setOnClickListener {
            numberClicked("2")
        }

        btn_3.setOnClickListener {
            numberClicked("3")
        }

        btn_4.setOnClickListener {
            numberClicked("4")
        }

        btn_5.setOnClickListener {
            numberClicked("5")
        }

        btn_6.setOnClickListener {
            numberClicked("6")
        }

        btn_7.setOnClickListener {
            numberClicked("7")
        }

        btn_8.setOnClickListener {
            numberClicked("8")
        }

        btn_9.setOnClickListener {
            numberClicked("9")
        }

    } // clickersOfNumbers

}