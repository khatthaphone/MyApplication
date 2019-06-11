package com.retech.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {

    // EditTexts
    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var etResult: EditText

    // Buttons
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        initViews()

        btnAdd.setOnClickListener(this)
        btnSubtract.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnDivide.setOnClickListener(this)

    }

    private fun initViews() {
        etNumber1 = et_number1
        etNumber2 = et_number2
        etResult = et_result

        btnAdd = btn_add
        btnSubtract = btn_subtract
        btnMultiply = btn_multiply
        btnDivide = btn_divide
    }

    override fun onClick(v: View?) {
        if (!etNumber1.text.isNullOrBlank() && !etNumber2.text.isNullOrBlank()) {
            val num1 = etNumber1.text.toString().toLong()
            val num2 = etNumber2.text.toString().toLong()
            var result = 0L

            when(v?.id) {
                R.id.btn_add -> result = num1 + num2
                R.id.btn_subtract -> result = num1 - num2
                R.id.btn_multiply -> result = num1 * num2
                R.id.btn_divide -> result = num1 / num2
            }

            etResult.setText("$result")

        } else {
            Toast.makeText(this, "Please Enter Number1 and Number2", Toast.LENGTH_SHORT).show()
        }
    }

}
