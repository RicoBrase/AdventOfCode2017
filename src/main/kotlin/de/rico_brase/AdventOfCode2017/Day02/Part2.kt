package de.rico_brase.AdventOfCode2017.Day02

import java.io.InputStream

fun main(args: Array<String>) {
    Part2().run()
}

class Part2 {

    val input = mutableListOf<List<Int>>()
    
    fun calcChecksum(input: List<List<Int>>): Int{
        var checksum = 0
        
        // Check each possible combination in each row
        // If one number of them can be divided evenly by another number of the combinations - add the division result to the checksum 
        
        for(row: List<Int> in input){
            for(i: Int in row.indices){
                
                var j = i + 1
                
                while (j < row.size){
                    
                    val maxCurr = maxOf(row[i], row[j])
                    val minCurr = minOf(row[i], row[j])
                    
                    if(maxCurr % minCurr == 0){
                        checksum += (maxCurr / minCurr)
                    }
                    
                    j++
                }
            }
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