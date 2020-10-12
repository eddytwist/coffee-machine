package machine

import java.lang.Math.abs
import java.util.Scanner
import kotlin.system.exitProcess

val scan = Scanner(System.`in`)
var waterIn = 400
var milkIn = 540
var coffeeBeansIn = 120
var disposableCupsIn = 9
var moneyIn = 550

fun main() {
    println("--------------------")
    while (true)
        showActions()
}

fun showCoffeeMachineHas() {
    println("The coffee machine has: ")
    println("$waterIn of water")
    println("$milkIn of milk")
    println("$coffeeBeansIn of coffee beans")
    println("$disposableCupsIn of disposable cups")
    if (moneyIn > 0) println("$$moneyIn of money")
    else println("$moneyIn of money")
}

fun showActions() {
    print ("Write action (buy, fill, take, remaining, exit): ")
    when (scan.next()) {
        "buy" -> buy()
        "fill" -> fill()
        "take" -> take()
        "remaining" -> remaining()
        "exit" -> exitProcess(1)
    }
    println()
}

fun fill() {
    print("\nWrite how many ml of water do you want to add: ")
    val waterAdd : Int = scan.nextInt()
    print("Write how many ml of milk do you want to add: ")
    val milkAdd : Int = scan.nextInt()
    print("Write how many grams of coffee beans do you want to add: ")
    val coffeeBeansAdd : Int = scan.nextInt()
    print("Write how many disposable cups of coffee do you want to add: ")
    val disposableCupsAdd : Int = scan.nextInt()
    waterIn += abs(waterAdd)
    milkIn += abs(milkAdd)
    coffeeBeansIn += abs(coffeeBeansAdd)
    disposableCupsIn += abs(disposableCupsAdd)
    println()
}

fun take() {
    println("\nI gave you $$moneyIn")
    moneyIn = 0
    println()
}

fun buy() {
    print("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    when (scan.next()) {
        "1" -> makeCoffee(250, 0, 16, 1, 4) //espresso
        "2" -> makeCoffee(350, 75, 20, 1, 7) //latte
        "3" -> makeCoffee(200,100, 12, 1, 6) //cappuccino
        else -> return
    }
}

fun remaining() {
    println()
    showCoffeeMachineHas()
}

fun checkWater(resource : Int) : Boolean {
    return waterIn - resource >= 0
}

fun checkMilk(resource : Int) : Boolean {
    return milkIn - resource >= 0
}

fun checkCoffeeBeans(resource : Int) : Boolean {
    return coffeeBeansIn - resource >= 0
}

fun checkDisposableCups(resource : Int) : Boolean {
    return disposableCupsIn - resource >= 0
}

fun makeCoffee (water: Int, milk: Int, coffeeBeans: Int, disposableCups: Int, money: Int) {
    if(!checkWater(water)) println("Sorry, not enough water!")
    else if (!checkMilk(milk)) println("Sorry, not enough milk!")
    else if (!checkCoffeeBeans(coffeeBeans)) println("Sorry, not enough coffee beans!")
    else if (!checkDisposableCups(disposableCups)) println("Sorry, not enough disposable cups!")
    else {
        println("I have enough resources, making you a coffee!")
        waterIn -= water
        milkIn -= milk
        coffeeBeansIn -= coffeeBeans
        disposableCupsIn -= disposableCups
        moneyIn += money
    }
}