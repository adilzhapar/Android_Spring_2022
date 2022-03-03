package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn0.setOnClickListener { textFields("0") }
        binding.btn1.setOnClickListener { textFields("1") }
        binding.btn2.setOnClickListener { textFields("2") }
        binding.btn3.setOnClickListener { textFields("3") }
        binding.btn4.setOnClickListener { textFields("4") }
        binding.btn5.setOnClickListener { textFields("5") }
        binding.btn6.setOnClickListener { textFields("6") }
        binding.btn7.setOnClickListener { textFields("7") }
        binding.btn8.setOnClickListener { textFields("8") }
        binding.btn9.setOnClickListener { textFields("9") }

        binding.btnCom.setOnClickListener { textFields(".") }
        binding.btnPls.setOnClickListener { textFields("+") }
        binding.btnMns.setOnClickListener { textFields("-") }
        binding.btnMlp.setOnClickListener { textFields("*") }
        binding.btnDiv.setOnClickListener { textFields("/") }

        binding.btnEq.setOnClickListener {
            try {

                val ex = ExpressionBuilder(binding.mathOperation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble()){
                    binding.result.text = longRes.toString()
                }else{
                    binding.result.text = binding.result.toString()
                }
            } catch (e:Exception) {
                Log.d("Error", "message: ${e.message}")
            }
        }

        binding.btnBack.setOnClickListener {
            val str = binding.mathOperation.text.toString()
            if(str.isNotEmpty())
                binding.mathOperation.text = str.substring(0, str.length-1)
        }
    }

    fun textFields(str: String){
        if(binding.result.text != ""){
            binding.mathOperation.text = binding.result.text
            binding.result.text = ""
        }
        binding.mathOperation.append(str)
    }
}