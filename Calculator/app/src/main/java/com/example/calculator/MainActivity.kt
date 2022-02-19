package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var math_operation: TextView
    private lateinit var result: TextView
    private lateinit var btn_0: TextView
    private lateinit var btn_1: TextView
    private lateinit var btn_2: TextView
    private lateinit var btn_3: TextView
    private lateinit var btn_4: TextView
    private lateinit var btn_5: TextView
    private lateinit var btn_6: TextView
    private lateinit var btn_7: TextView
    private lateinit var btn_8: TextView
    private lateinit var btn_9: TextView

    private lateinit var btn_pls: TextView
    private lateinit var btn_mns: TextView
    private lateinit var btn_mlp: TextView
    private lateinit var btn_div: TextView
    private lateinit var btn_back: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        math_operation = findViewById(R.id.math_operation)
        btn_0 = findViewById(R.id.btn_0)
        btn_1 = findViewById(R.id.btn_1)
        btn_2 = findViewById(R.id.btn_2)
        btn_3 = findViewById(R.id.btn_3)
        btn_4 = findViewById(R.id.btn_4)
        btn_5 = findViewById(R.id.btn_5)
        btn_6 = findViewById(R.id.btn_6)
        btn_7 = findViewById(R.id.btn_7)
        btn_8 = findViewById(R.id.btn_8)
        btn_9 = findViewById(R.id.btn_9)

        btn_pls = findViewById(R.id.btn_pls)
        btn_mns = findViewById(R.id.btn_mns)
        btn_mlp = findViewById(R.id.btn_mlp)
        btn_div = findViewById(R.id.btn_div)
        btn_back = findViewById(R.id.btn_back)

        btn_0.setOnClickListener {textFields("0")}
        btn_1.setOnClickListener {textFields("1")}
        btn_2.setOnClickListener {textFields("2")}
        btn_3.setOnClickListener {textFields("3")}
        btn_4.setOnClickListener {textFields("4")}
        btn_5.setOnClickListener {textFields("5")}
        btn_6.setOnClickListener {textFields("6")}
        btn_7.setOnClickListener {textFields("7")}
        btn_8.setOnClickListener {textFields("8")}
        btn_9.setOnClickListener {textFields("9")}
        btn_mns.setOnClickListener {textFields("-")}
        btn_pls.setOnClickListener {textFields("+")}
        btn_mlp.setOnClickListener {textFields("\u2715")}
        btn_div.setOnClickListener {textFields("\u00F7")}

        btn_back.setOnClickListener {
            val str = math_operation.text.toString()
            if(str.isNotEmpty())
                math_operation.text = str.substring(0, str.length-1)
            result.text = ""
        }
    }

    fun textFields(str: String){
        math_operation.append(str);
    }
}