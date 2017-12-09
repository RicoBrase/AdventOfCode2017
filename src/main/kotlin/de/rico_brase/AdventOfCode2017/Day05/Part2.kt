package de.rico_brase.AdventOfCode2017.Day05

import java.io.InputStream

fun main(args: Array<String>) {
    Part2().run()
}

class Part2 {
    val input = mutableListOf<Int>()

    fun countStepsTillEscape(input: List<Int>): Int {

        val instructions = input.toMutableList()

        var count = 0
        var index = 0
        var lastIndex: Int

        while(index < instructions.size && index >= 0){

            lastIndex = index
            index += instructions[index]

            if(instructions[lastIndex] >= 3){
                instructions[lastIndex]--
            }else{
                instructions[lastIndex]++
            }

            count++
        }

        return count
    }
    
    fun run(){
        
        val inputStream: InputStream = javaClass.classLoader.getResource("Day05.txt").openStream()
        inputStream.bufferedReader().useLines { lines -> lines.forEach { input.add(it.toInt()) } }
        
        println(countStepsTillEscape(input))
    }
}