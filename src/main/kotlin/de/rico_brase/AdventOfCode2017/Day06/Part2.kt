package de.rico_brase.AdventOfCode2017.Day06

import java.io.InputStream

fun main(args: Array<String>) {
    Part2().run()
}

class Part2 {
    val input = mutableListOf<Int>()
    
    fun redistribute(input: List<Int>): Pair<Int, Int>{
        val seenStates = mutableListOf<List<Int>>()
        var cycles = 0
        val currentState = input.toMutableList()
        
        while (!seenStates.contains(currentState)){
            seenStates.add(currentState.toList())
            var currMax = 0
            for(i in 1 until currentState.size){
                currMax = compare(currentState, currMax, i)
            }
            val steps = currentState[currMax]
            currentState[currMax] = 0
            for(j in 1..steps){
                currentState[(currMax+j) % (currentState.size)]++
            }
            cycles++
        }
        
        val loopSize = cycles - seenStates.indexOf(currentState)
        
        return Pair(loopSize, cycles)
    }
    
    fun compare(bank: List<Int>, pos1: Int, pos2: Int): Int{
        if(bank[pos1] > bank[pos2]){
            return pos1
        }else if(bank[pos1] < bank[pos2]){
            return pos2
        }else{
            return minOf(pos1, pos2)
        }
    }
    
    fun run(){

        var fileContent = ""
        
        val inputStream: InputStream = javaClass.classLoader.getResource("Day06.txt").openStream()
        inputStream.bufferedReader().use { it -> fileContent = it.readText() }

        val integers = fileContent.split("\t")
        for(i in integers){
            input.add(i.toInt())
        }
        
        val result = redistribute(input)
        println("LoopSize: ${result.first} | Cycles: ${result.second}")
    }
}