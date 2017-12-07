package de.rico_brase.AdventOfCode2017.Day02

import java.io.InputStream

fun main(args: Array<String>) {
    Part1().run()
}

class Part1 {
    
    var input = mutableListOf<List<Int>>()

    fun calcChecksum(input: List<List<Int>>): Int{
        var checksum = 0
        
        // Add the difference of the biggest and the smallest number of each row to the checksum
        for (row: List<Int> in input){
            val minNum: Int = row.min()!!
            val maxNum: Int = row.max()!!
            checksum += (maxNum - minNum)
            
        }
        return checksum
    }
    
    fun run(){

        val fileLines = mutableListOf<String>()
        
        val inputStream: InputStream = javaClass.classLoader.getResource("Day02.txt").openStream()
        inputStream.bufferedReader().useLines { lines -> lines.forEach { fileLines.add(it) } }
        
        for(line: String in fileLines){
            val integers = line.split("\t")
            val intList = mutableListOf<Int>()
            for(i in integers){
                intList.add(i.toInt())
            }
            input.add(intList)
        }
        
        println(calcChecksum(input))
    }
}