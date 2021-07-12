package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Xử lý các nút số
        btn0.setOnClickListener { appendVal("0", false) }
        btn1.setOnClickListener { appendVal("1", false) }
        btn2.setOnClickListener { appendVal("2", false) }
        btn3.setOnClickListener { appendVal("3", false) }
        btn4.setOnClickListener { appendVal("4", false) }
        btn5.setOnClickListener { appendVal("5", false) }
        btn6.setOnClickListener { appendVal("6", false) }
        btn7.setOnClickListener { appendVal("7", false) }
        btn8.setOnClickListener { appendVal("8", false) }
        btn9.setOnClickListener { appendVal("9", false) }
        btnDot.setOnClickListener { appendVal(".", false) }

        // Xử lý các phím chức năng
        btnCE.setOnClickListener { appendVal("", true) }
        btnDiv.setOnClickListener { appendVal(" / ", false) }
        btnMul.setOnClickListener { appendVal(" * ", false) }
        btnSub.setOnClickListener { appendVal(" - ", false) }
        btnSum.setOnClickListener { appendVal(" + ", false) }

        btnOnC.setOnClickListener {
            tvExpression.text = tvExpression.text.toString()
                .substring(0, tvExpression.text.toString().length - 1)
        }

        btnEqual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    tvExpression.text = longResult.toString()
                } else
                    tvExpression.text = result.toString()

            } catch (e: Exception) {
            }
        }
    }

        fun appendVal(string: String, isClear: Boolean) {
            if (isClear) {
                tvExpression.text = ""
            } else {
                tvExpression.append(string)
            }
        }
}

