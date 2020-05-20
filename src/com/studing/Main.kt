package com.studing

fun main(args: Array<String>) {
    // Task 1
    val first = 10
    val second = 12
    val third = 19
    val result = when {
        first > third && second > third -> sqr(first) + sqr(second)
        first > second -> sqr(first) + sqr(third)
        else -> sqr(second) + sqr(third)
    }
    println("Result: $result")

    // Task 2
    val hex = 0xffea00
    println(
        when (hex) {
            0x000000 -> "black"
            0xffea00 -> "yellow"
            0xff0000 -> "red"
            0x000dff -> "blue"
            0x15ff00 -> "green"
            else -> "error"
        }
    )

    // Task 3
    val inVal = "30.02.2000"
    val inStr = inVal.split(".")
    val inDate = Integer.parseInt(inStr[0])
    val inMonth = Integer.parseInt(inStr[1])
    val inYear = Integer.parseInt(inStr[2])
    var error = false
    when (inMonth) {
        1, 3, 5, 7, 8, 10, 12 -> if (inDate > 31) error = true
        4, 6, 9, 11 -> if (inDate > 30) error = true
        2 -> {
            if (inYear % 4 == 0 && inDate > 29) error = true
            if (inYear % 4 != 0 && inDate > 28) error = true
        }
    }
    println(if (error) "value is not valid" else "ok!")
}

fun sqr(x: Int): Int = x * x