package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var TotalCarloan : Double = 0.0;
    var TotalInterest : Double = 0.0;
    var TotalMonthlyPay : Double = 0.0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculateCarLoan();
            calculateInterest();
            calculateMonthlyRepayment();
        }
    }

    private fun calculateCarLoan() {
        val car_price: TextView = findViewById(R.id.editTextCarPrice)
        val down_payment: TextView = findViewById(R.id.editTextDownPayment)
        var carprice: Double = car_price.text.toString().toDouble()
        var downpayment: Double = down_payment.text.toString().toDouble()

        TotalCarloan = carprice - downpayment;

        textViewLoan.text = "Loan : "+String.format("%.2f", TotalCarloan);
    }

    private fun calculateInterest() {
        val loan_Period: TextView = findViewById(R.id.editTextLoanPeriod)
        val interest_Rate: TextView = findViewById(R.id.editTextInterestRate)
        var loanPeriod: Int = loan_Period.text.toString().toInt()
        var interestRate: Double = interest_Rate.text.toString().toDouble()

        interestRate = interestRate/100;

        TotalInterest = TotalCarloan* interestRate * loanPeriod;

        textViewInterest.text = "Interest : "+String.format("%.2f", TotalInterest);
    }

    private fun calculateMonthlyRepayment() {
        val loan_Period: TextView = findViewById(R.id.editTextLoanPeriod)
        var loanPeriod: Int = loan_Period.text.toString().toInt()

        TotalMonthlyPay = (TotalCarloan + TotalInterest)/loanPeriod/12

        textViewMonthlyRepayment.text = "Monthly Repayment : "+String.format("%.2f", TotalMonthlyPay);

    }



}
