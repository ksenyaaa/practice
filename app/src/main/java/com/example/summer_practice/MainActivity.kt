package com.example.summer_practice

import kotlin.random.Random
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

fun appendString(arg1: String?, arg2: String): String {
    arg1?.let {

    }
}

abstract class Car(
    open val brand: String,
    open val model: String,
    open val year: Int,
    open val color: String,

) {
    abstract fun printInfo{
        println("Brand: $brand; Model: $model, Year: $year, Color: $color)
    }
}


data class Crossover(
    override val brand: String,
    override val model: String,
    override val year: Int,
    override val color: String,
    val driveType: String,
    val enginePower: Int
) : Car(brand, model, year, color) {
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
    val payload: Int,
    val cabinType: String
) : Car(brand, model, year, color) {
    override fun printInfo() {
        println("Payload")
        println("Cabin Type")
    }
}

data class SportsCar(
    override val brand: String,
    override val model: String,
    override val year: Int,
    override val color: String,
    val transmissionType: String
) : Car(brand, model, year, color) {
    override fun printInfo() {
        println("Transmission Type")
    }
}

data class Suv(
    override val brand: String,
    override val model: String,
    override val year: Int,
    override val color: String,
    val driveType: String
) : Car(brand, model, year, color) {
    override fun printInfo() {
        println("Drive Type")

    }
}

fun getRandomCar(): Car {

    val brands = listOf("Toyota", "Honda", "Ford", "BMW", "Mercedes-Benz")
    val models = listOf("Camry", "Civic", "Explorer", "3 Series", "C-Class")
    val colors = listOf("Red", "Blue", "Black", "Silver", "White")

    val randomBrand = brands.random()
    val randomModel = models.random()
    val randomYear = Random.nextInt(1990, 2024)
    val randomColor = colors.random()

    val randomType = Random.nextInt(1, 4)
    when (randomType) {
        1 -> {return Crossover (randomBrand, randomModel, randomYear, randomColor)}
        2 -> {return Truck (randomBrand, randomModel, randomYear, randomColor)}
        3 -> {return SportsCar (randomBrand, randomModel, randomYear, randomColor)}
        4 -> {return Suv(randomBrand, randomModel, randomYear, randomColor)}
    }

}

fun main() {
    val randomCar = getRandomCar()
    println(randomCar)
}

fun carCompetition(car: Car) {
    if (this.maxSpeed > car.maxSpeed) {
        println("${this.name} wins")
    } else if (this.maxSpeed < car.maxSpeed) {
        println("${car.name} wins")
    } else {
        println("Tie")
    }
}