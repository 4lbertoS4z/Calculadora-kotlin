package com.example.calculadora

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Variables que se utilizan para almacenar los números y operadores
    private lateinit var binding: ActivityMainBinding
    private var currentNumber: String = ""
    private var currentOperator: String = ""
    private var previousNumber: String = ""
    private var result: Double = 0.0
    private var justPressedEquals: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializa el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Crea un listener para el botón Clear
        binding.btnClear.setOnClickListener {
            // Limpia los valores
            currentNumber = ""
            currentOperator = ""
            previousNumber = ""
            justPressedEquals = false
            // Muestra 0 en la pantalla
            binding.tvResult.text = "0"
        }
        // Crea un listener para el botón Backspace
        binding.btnBackspace.setOnClickListener {
            // Elimina el último dígito ingresado
            if (currentNumber.isNotEmpty()) {
                currentNumber = currentNumber.dropLast(1)
                binding.tvResult.text = if (currentNumber.isEmpty()) "0" else currentNumber
            }
        }

        // Crear los listener para los botones de operaciones
        binding.btnDivide.setOnClickListener {
            handleOperatorClick("/")
        }
        binding.btnMultiply.setOnClickListener {
            handleOperatorClick("*")
        }
        binding.btnSubtract.setOnClickListener {
            handleOperatorClick("-")
        }
        binding.btnAdd.setOnClickListener {
            handleOperatorClick("+")
        }

        // Crear los listener para los botones de  numeros
        binding.btnNine.setOnClickListener {
            // Si acabamos de pulsar el botón "=" se resetean los valores de operaciones previas
            if (justPressedEquals) {
                previousNumber = ""
                justPressedEquals = false
            }
            handleNumberClick("9")
        }
        binding.btnEight.setOnClickListener {
            if (justPressedEquals) {
                previousNumber = ""
                justPressedEquals = false
            }
            handleNumberClick("8")
        }
        binding.btnSeven.setOnClickListener {
            if (justPressedEquals) {
                previousNumber = ""
                justPressedEquals = false
            }
            handleNumberClick("7")
        }
        binding.btnSix.setOnClickListener {
            if (justPressedEquals) {
                previousNumber = ""
                justPressedEquals = false
            }
            handleNumberClick("6")
        }
        binding.btnFive.setOnClickListener {
            if (justPressedEquals) {
                previousNumber = ""
                justPressedEquals = false
            }
            handleNumberClick("5")
        }
        binding.btnFour.setOnClickListener {
            if (justPressedEquals) {
                previousNumber = ""
                justPressedEquals = false
            }
            handleNumberClick("4")
        }
        binding.btnThree.setOnClickListener {
            if (justPressedEquals) {
                previousNumber = ""
                justPressedEquals = false
            }
            handleNumberClick("3")
        }
        binding.btnTwo.setOnClickListener {
            if (justPressedEquals) {
                previousNumber = ""
                justPressedEquals = false
            }
            handleNumberClick("2")
        }
        binding.btnOne.setOnClickListener {
            if (justPressedEquals) {
                previousNumber = ""
                justPressedEquals = false
            }
            handleNumberClick("1")
        }
        binding.btnZero.setOnClickListener {
            if (justPressedEquals) {
                previousNumber = ""
                justPressedEquals = false
            }
            handleNumberClick("0")
        }
        binding.btnDecimal.setOnClickListener {
// Verifica si el número actual está vacío, lo que significa que aún no se ha ingresado ningún número
            if (currentNumber.isEmpty()) {
// Si es así, se coloca un 0 antes del punto decimal para comenzar el número decimal
                currentNumber = "0."
// De lo contrario, si el número actual ya tiene un punto decimal, no se agrega otro
            } else if (!currentNumber.contains(".")) {
// Si no tiene un punto decimal, se agrega uno al número actual
                currentNumber += "."
            }
// Se muestra el número actualizado en la vista de texto
            binding.tvResult.text = currentNumber
        }
        binding.btnEquals.setOnClickListener {
            calculate()
        }
    }
    private fun handleNumberClick(number: String) {
        currentNumber += number
        binding.tvResult.text = currentNumber
    }

    private fun handleOperatorClick(operator: String) {
        if (currentNumber.isNotEmpty()) {
            if (!justPressedEquals) {
                calculate()
            }
            currentOperator = operator
            justPressedEquals = false
            previousNumber = currentNumber
            currentNumber = ""
        }
    }

    private fun calculate() {
        if (currentNumber.isNotEmpty() && previousNumber.isNotEmpty()) {
            val previous = previousNumber.toDouble()
            val current = currentNumber.toDouble()
            when (currentOperator) {
                "+" -> result = previous + current
                "-" -> result = previous - current
                "*" -> result = previous * current
                "/" -> result = previous / current
            }
            binding.tvResult.text = result.toString()
            currentNumber = result.toString()
            justPressedEquals = true
        }
    }
}




