package br.com.fiap.shift.primeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    var value: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Constantes dos elementos de tela
        val viewBackground: ConstraintLayout = findViewById(R.id.viewBackground)
        val lblValue: TextView = findViewById(R.id.lblValue)
        val txtValue: EditText = findViewById(R.id.txtValue)
        val btnWithdraw: TextView = findViewById(R.id.btnWithdraw)
        val btnDeposit: TextView = findViewById(R.id.btnDeposit)

        // Tratamento do click do botão de sacar
        btnWithdraw.setOnClickListener {
            val newValue = txtValue.text.toString().toDoubleOrNull()
            newValue?.let {
                value -= it
                lblValue.text = "R$ $value"
            }
        }

        // Tratamento do click do botão de depositar
        btnDeposit.setOnClickListener {
            val newValue = txtValue.text.toString().toDoubleOrNull()
            newValue?.let {
                value += it
                lblValue.text = "R$ $value"
            }
        }

        // Tratamento do tap no fundo da tela para ocultar o teclado
        viewBackground.setOnClickListener { it.hideKeyboard() }
    }

    fun View.hideKeyboard() {
        val inputMethodManager = context!!.getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        inputMethodManager?.hideSoftInputFromWindow(this.windowToken, 0)
    }
}