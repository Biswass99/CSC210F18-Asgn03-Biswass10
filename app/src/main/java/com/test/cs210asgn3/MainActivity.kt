package com.test.cs210asgn3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        buttonPress.setOnClickListener {
            val loanAmountString : String = loanAmountBox.text.toString()
            val loanAmount : Double = loanAmountString.toDouble()

            val annualInterestRateString : String = annualInterestRateBox.text.toString()
            val annualInterestRate : Double = annualInterestRateString.toDouble()


            val discountFactorFive : Double = computeDiscountFactor(5, annualInterestRate)
            val fiveYearPayments : Double = (loanAmount/discountFactorFive)
            fiveYearPayment.text = "5 year monthly Payment is %.2f".format(fiveYearPayments)

            val discountFactorTen : Double = computeDiscountFactor(10, annualInterestRate)
            val tenYearPayments : Double = (loanAmount/discountFactorTen)
            tenYearPayment.text = "10 year monthly Payment is %.2f".format(tenYearPayments)

            val discountFactorFifteen : Double = computeDiscountFactor(15, annualInterestRate)
            val fifteenYearPayments : Double = (loanAmount/discountFactorFifteen)
            fifteenYearPayment.text = "15 year monthly Payment is %.2f".format(fifteenYearPayments)
           }

    }
    public fun computeDiscountFactor (years: Int, interestRate: Double): Double {
        val numberOfMonths : Double = (years*12).toDouble()
        val monthlyInterestRate : Double = (interestRate/(100.0*12.0))
        val discountFactor : Double
        discountFactor = ((1-Math.pow(1+monthlyInterestRate, -numberOfMonths))/monthlyInterestRate)
        return discountFactor
    }

}
