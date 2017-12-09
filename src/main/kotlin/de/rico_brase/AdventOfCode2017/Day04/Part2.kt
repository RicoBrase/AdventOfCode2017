package de.rico_brase.AdventOfCode2017.Day04

import java.io.InputStream

fun main(args: Array<String>) {
    Part2().run()
}

fun List<String>.breakStringsDown(): List<Map<Char, Int>> {
    val words = mutableListOf<Map<Char, Int>>()

    for(word in this){
        val chars = mutableMapOf<Char, Int>()

        for(char in word){
            var count = 0
            if(chars.containsKey(char)){
                count = chars.get(char)!!
            }
            chars.put(char, ++count)
        }

        words.add(chars)
    }

    return words
}

class Part2 {
    val input = mutableListOf<String>()

    fun countValidPassphrases(input: List<String>): Int {

        var count = 0

        for (line in input) {
            val words: List<Map<Char, Int>> = line.split(" ").breakStringsDown()
            val checkedWords = mutableListOf<Map<Char, Int>>()

            for(word: Map<Char, Int> in words){
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