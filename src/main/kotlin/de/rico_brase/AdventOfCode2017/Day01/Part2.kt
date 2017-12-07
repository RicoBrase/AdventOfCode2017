package de.rico_brase.AdventOfCode2017.Day01

import java.io.InputStream

fun main(args: Array<String>) {
    Part2().run()
}

class Part2 {
    var input: String = ""

    fun calcCaptcha(input: String): Int {

        var sum = 0

        for (i in input.indices) {
            // calculate the index of the char to match(half the length of input added to current index)
            val newIndex: Int = if((i + (input.length / 2)) >= input.length){
                        (i + (input.length / 2)) - input.length // subtract length of input if necessary
                    } else {
                        (i + (input.length / 2))
                    }
            
            // if both chars match eachother, add the current chars value to the captcha
            if (input[i] == input[newIndex]) {
                sum += input[i].toString().toInt()
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