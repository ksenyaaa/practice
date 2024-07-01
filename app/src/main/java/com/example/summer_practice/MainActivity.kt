package com.example.summer_practice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        appendString(arg1 = "first", arg2 = "second")

        }
    override fun onDestroy() {
        super.onDestroy()
    }
}

fun appendString(arg1: String?, arg2: String): String{
    arg1?.let {

    }




abstract class Car(
    open val brand: String,
    open val model: String,
    open val year: Int,
    open val color: String,
    open val mileage: Int
) {

    abstract fun printInfo() {
        println("Brand: $brand; Model: $model, Year: $year, Color: $color, Mileage: $mileage km")

    }

}
data class Crossover(
    override val brand: String,
    override val model: String,
    override val year: Int,
    override val color: String,
    override val mileage: Int,
    val driveType: String,
    val enginePower: Int
) : Car(brand, model, year, color, mileage) {
    override fun printInfo() {
        println("Drive Type")
        println("Engine Power")
    }
}

data class Truck(
    override val brand: String,
    override val model: String,
    override val year: Int,
    override val color: String,
    override val mileage: Int,
    val payload: Int,
    val cabinType: String
) : Car(brand, model, year, color, mileage) {
    override fun printInfo() {
        println("Payload")
        println("Cabin Type")
    }
}