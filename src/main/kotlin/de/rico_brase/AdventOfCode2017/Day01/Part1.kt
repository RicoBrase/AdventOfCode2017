package de.rico_brase.AdventOfCode2017.Day01

import java.io.InputStream

fun main(args: Array<String>) {
    Part1().run()
}

class Part1 {
    var input: String = ""

    fun calcCaptcha(input: String): Int {

        var sum = 0

        for (i in input.indices) {
            // Did we reach the end of the input?
            if (i == input.length - 1) {
                // If the very last char matches the very first char, add it's value to the captcha.
                if (input[i] == input[0]) {
                    sum += input[i].toString().toInt()
                }
            } else {
                // Do the next char and the current char match? If yes, add the value of the current char to the captcha.
                if (input[i] == input[i + 1]) {
                    sum += input[i].toString().toInt()
                }
            }

        }

        return sum
    }
    
    fun run(){

        val inputStream: InputStream = javaClass.classLoader.getResource("Day01.txt").openStream()
        input = inputStream.bufferedReader().use { it.readText() }
        
        println(calcCaptcha(input))
    }
}