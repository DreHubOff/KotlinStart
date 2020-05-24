package com.studing

import com.studing.data.generate
import com.studing.model.ShopsManager

fun main(args: Array<String>) {
    val shopsManager = ShopsManager(generate())

    println("Enter the name of the store to find the cheapest phone.")
    println(shopsManager.findChPhone(readLine().orEmpty()))
    println()

    println("The phone that has the biggest discount: ")
    println(shopsManager.findMaxDiscount())
    println()

    println("Enter the name of the store: ")
    val inNameStore = readLine().orEmpty()
    println("Enter the name of the brand: ")
    val inNameBrand = readLine().orEmpty()
    println(shopsManager.findPhoneByBrand(inNameStore, inNameBrand))
    println()


    println("Enter the name of the store: ")
    val inNameStore2 = readLine().orEmpty()
    println("Enter the min cost: ")
    val minCost = readLine().orEmpty().toInt()
    println("Enter the max cost: ")
    val maxCost = readLine().orEmpty().toInt()
    println(shopsManager.findPhoneByRange(inNameStore2, minCost, maxCost))

    println("Unique phones: ")
    println(shopsManager.findUniquePhones())

}

