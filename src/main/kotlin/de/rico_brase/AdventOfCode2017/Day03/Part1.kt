package de.rico_brase.AdventOfCode2017.Day03

fun main(args: Array<String>) {
    Part1().run()
}

class Part1 {
    
    val input = 277678

    fun calcManhattanDistance(requestedSquare: Int): Int {
        var steps = 0
        
        // Calculate the number of rows & columns of the square
        var sqLength = 1
        while((sqLength * sqLength) < requestedSquare){
            sqLength += 2 // each "layer" of the square has two additional rows/columns: top & bottom; left & right
        }

        val centerRowColumn = (sqLength + 1) / 2 // calculate the center
        
        var wantedRow = sqLength
        var wantedCol = sqLength
        
        val diff = (sqLength * sqLength) - requestedSquare // how many steps from bottom right field to wanted field?
        
        for(i in 1..diff){ // walk anti-clockwise through the fields to get the coordinates of the wanted field
            if(wantedRow == sqLength && wantedCol > 1){
                wantedCol-- //bottom row -> walk left
            }else if(wantedCol == 1 && wantedRow > 1){
                wantedRow-- //left column -> walk up
            }else if(wantedRow == 1 && wantedCol < sqLength){
                wantedCol++ //top row -> walk right
            }else if(wantedCol == sqLength && wantedRow < (sqLength - 1)){
                wantedRow++ //right column -> walk down - one step further would be the starting point again
            }
        }
        
        //calculate the amount of steps needed to get from the wanted field to the center field
        //sum of the differences of the rows and the difference of the columns
        steps += (maxOf(wantedRow, centerRowColumn) - minOf(wantedRow, centerRowColumn))
        steps += (maxOf(wantedCol, centerRowColumn) - minOf(wantedCol, centerRowColumn))
        
        return steps
    }
    
    fun run(){
        println(calcManhattanDistance(input))
    }
}