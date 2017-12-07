package de.rico_brase.AdventOfCode2017.Day03

fun main(args: Array<String>) {
    Part2().run()
}

class Part2 {
    
    val input = 277678

    fun calcNumberBiggerThan(input: Int): Int {
        // Calculate the number of rows & columns of the square
        var sqLength = 1
        while((sqLength * sqLength) < input){
            sqLength += 2 // each "layer" of the square has two additional rows/columns: top & bottom; left & right
        }
        
        // ^ square size is way too oversized; not optimized for part 2. Might change, if I know a better way to solve that problem

        val centerRowColumn = (sqLength - 1) / 2 // calculate the center (0-indexed)
        
        val square: Array<IntArray> = Array(sqLength, { i -> IntArray(sqLength)})
        square[centerRowColumn][centerRowColumn] = 1
        
        var currentRow = centerRowColumn
        var currentCol = centerRowColumn+1
        var steps = 1
        var stepsLeft = steps
        var dir = 0 // 0 = up, 1 = left, 2 = down, 3 = right
        
        while(true){
            
            var currentValue = 0
            
            // Field isn't left edge
            if(currentCol > 0){
                currentValue += square[currentRow][currentCol-1]
            }
            
            //Field isn't right edge
            if(currentCol < (square[currentRow].size - 1)){
                currentValue += square[currentRow][currentCol+1]
            }
            
            //Field isn't top edge
            if(currentRow > 0){
                currentValue += square[currentRow-1][currentCol]
    
                // Field isn't top-left corner
                if(currentCol > 0){
                    currentValue += square[currentRow-1][currentCol-1]
                }
                
                //Field isn't top-right corner
                if(currentCol < (square[currentRow].size - 1)){
                    currentValue += square[currentRow-1][currentCol+1]
                }
            }
            
            //Field isn't bottom edge
            if(currentRow < (square.size - 1)){
                currentValue += square[currentRow+1][currentCol]

                // Field isn't bottom-left corner
                if(currentCol > 0){
                    currentValue += square[currentRow+1][currentCol-1]
                }

                //Field isn't bottom-right corner
                if(currentCol < (square[currentRow].size - 1)){
                    currentValue += square[currentRow+1][currentCol+1]
                }
            }
            
            square[currentRow][currentCol] = currentValue

            if(currentValue > input){
                break
            }else{
                when (dir){
                    0 -> currentRow-- // up
                    1 -> currentCol-- // left
                    2 -> currentRow++ // down
                    3 -> currentCol++ // right
                }

                stepsLeft--

                if(stepsLeft == 0){

                    dir++
                    
                    when (dir){
                        1 -> steps++
                        3 -> steps++
                        4 -> dir = 0
                    }

                    stepsLeft = steps
                }
            }
            
        }
        
        return square[currentRow][currentCol]
    }
    
    fun run(){
        println(calcNumberBiggerThan(input))
    }
}