/**
 * Write a description of class Grid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grid  
{
    int[][] grid;
    int cellSize;
    int noiseDens = 42;
    public Grid(int rows, int cols, int cs){
        grid = new int[rows][cols];
        cellSize = cs;
        generateGrid();
        smoothGrid(6);
    }

    public int getCS(){
        return cellSize;
    }

    public int[][] getGrid(){
        return grid;
    }

    public void generateGrid(){
        for(int i = 0; i < grid.length; i++){
            for(int k = 0; k < grid[0].length; k++){
                if((int)(Math.random() * 100 + 1) > noiseDens){
                    grid[i][k] = 0;
                } else{
                    grid[i][k] = 1;
                }
            }
        }
    }

    public void smoothGrid(int iter){
        
        int count = 0;
        int[][] tempGrid = new int[grid.length][grid[0].length];
        while(count != iter){
            for(int i = 0; i < grid.length; i++){
                for(int k = 0; k < grid[0].length; k++){
                    
                    if(countNeighbors(i,k) < 4){
                        tempGrid[i][k] = 0;
                    } else if( countNeighbors(i,k) > 4){
                        tempGrid[i][k] = 1;
                    }
                }
               
            }
            
            for(int i = 0; i < grid.length; i++){
                for(int k = 0; k < grid[0].length; k++){
                    
                    grid[i][k] = tempGrid[i][k];
                }
                
            }
            
            count++;
            
        }
        
    }

    public int countNeighbors(int x, int y){
        int count = 0;
        for(int i = x- 1; i <= x+1; i++){
            for(int k = y - 1; k<=y+1;k++){
                if(i == x && k == y){

                }else
                if(i>= 0 && k >= 0 && i < grid.length && k < grid[0].length){
                    if(grid[i][k]== 1){
                        count++;
                    }
                } else
                    count++;
            }
        }
        return count;
    }
}
