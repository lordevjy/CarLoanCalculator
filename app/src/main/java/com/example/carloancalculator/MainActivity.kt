package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtPrice.requestFocus()
        btnCalculate.setOnClickListener(){
            calLoan()
        }
    }

    private fun calLoan(){
        val carPrice:Double = txtPrice.text.toString().toDouble()
        val downPayment:Double = txtDownPayment.text.toString().toDouble()
        val period:Double = txtLoanPeriod.text.toString().toDouble()
        val interestRate:Double = txtInterest.text.toString().toDouble()

        val carLoan:Double = carPrice - downPayment
        val interest:Double = carLoan * (interestRate / 100) * period
        val monthlyRepayment:Double = (carLoan + interest) / period / 12

        viewcarLoan.text = "RM %.2f".format(carLoan)
        viewInterest.text = "%.2f %%".format(interest)
        viewMonthlyRepayment.text = "RM %.2f".format(monthlyRepayment)
    }


}
