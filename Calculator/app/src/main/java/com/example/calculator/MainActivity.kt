package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        with(binding) {
            btn0.setOnClickListener { textFields("0") }
            btn1.setOnClickListener { textFields("1") }
            btn2.setOnClickListener { textFields("2") }
            btn3.setOnClickListener { textFields("3") }
            btn4.setOnClickListener { textFields("4") }
            btn5.setOnClickListener { textFields("5") }
            btn6.setOnClickListener { textFields("6") }
            btn7.setOnClickListener { textFields("7") }
            btn8.setOnClickListener { textFields("8") }
            btn9.setOnClickListener { textFields("9") }
            btnCom.setOnClickListener { textFields(".") }
            btnPls.setOnClickListener { textFields("+") }
            btnMns.setOnClickListener { textFields("-") }
            btnMlp.setOnClickListener { textFields("*") }
            btnDiv.setOnClickListener { textFields("/") }

            btnEq.setOnClickListener {
                try {
                    val ex = ExpressionBuilder(mathOperation.text.toString()).build()
                    val res = ex.evaluate()

                    val longRes = res.toLong()
                    if(res == longRes.toDouble()) {
                        result.text = longRes.toString()
                    } else{
                        result.text = res.toString()
                    }
                } catch (e:Exception) {
                    Log.d("Error", "message: ${e.message}")
                }
            }

            btnBack.setOnClickListener {
                val str = mathOperation.text.toString()
                if(str.isNotEmpty())
                    mathOperation.text = str.substring(0, str.length-1)
            }
        }
    }

    private fun textFields(str: String) {
        if(binding.result.text != ""){
            binding.mathOperation.text = binding.result.text
            binding.result.text = ""
        }
        binding.mathOperation.append(str)
    }
}