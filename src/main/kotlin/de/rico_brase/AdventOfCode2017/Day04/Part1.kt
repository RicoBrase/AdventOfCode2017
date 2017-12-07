package de.rico_brase.AdventOfCode2017.Day04

import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    Part1().run()
}

class Part1 {
    val input = mutableListOf<String>()

    fun countValidPassphrases(input: List<String>): Int {

        var count = 0

        for (line in input) {
            val words = line.split(" ")
            val checkedWords = mutableListOf<String>()
            
            for(word in words){
                if(!checkedWords.contains(word)){
                    checkedWords.add(word)
                }
            }
            
            if(words.size == checkedWords.size){
                count++
            }
            
        }

        return count
    }
    
    fun run(){
        
        val inputStream: InputStream = javaClass.classLoader.getResource("Day04.txt").openStream()
        inputStream.bufferedReader().useLines { lines -> lines.forEach { input.add(it) } }
        
        println(countValidPassphrases(input))
    }
}