import java.util.Scanner;

public class SlyTightness {
    public static void main(String[] args){
        int[][] inputArray = {
            {1,2,1,3},
            {3,1,4,0},
            {2,4,2,1}
        };

        var outputArray = GetTightness(inputArray);

        Print2DArray(outputArray);
    }

    public static void Print2DArray(int[][] originMatrix){
        String[] length = new String[originMatrix.length];
        for(int i = 0; i < originMatrix.length; i++){
            String s = "";
            for(int j = 0; j < originMatrix[i].length; j++){
                s += "["+originMatrix[i][j]+"]";
            }
            length[i] = s;
        }

        for(String s : length){
            System.out.println(s);
        }
    }

    public static int[][] GetTightness(int[][] originMatrix){
        
        int[][] outputMatrix = new int[originMatrix.length][originMatrix[0].length]; 
        // i assume all positions are the same length.

        for(int i = 0; i < originMatrix.length; i++){
            for(int j = 0; j < originMatrix[i].length; j++){
                outputMatrix[i][j] = SumAroundPosition(originMatrix, i, j);
            }
        }

        return outputMatrix;
    }

    private static int SumAroundPosition(int[][] originMatrix, int positionX, int positionY){

        int positionSum = originMatrix[positionX][positionY] + GetUpperAndLowerPositions(originMatrix, positionX, positionY);

        if(positionX-1 >= 0){ // Left most position
            positionSum += originMatrix[positionX-1][positionY] + GetUpperAndLowerPositions(originMatrix, positionX-1, positionY);
        } 

        if(positionX+1 < originMatrix.length){ // Right most position
            positionSum += originMatrix[positionX+1][positionY] + GetUpperAndLowerPositions(originMatrix, positionX+1, positionY);
        }
        // Assuming that the matrix is the same length everywhere, if the left most position is null out of bounds then there will be no neighboring cells.

        return positionSum;
    }

    private static int GetUpperAndLowerPositions(int[][] originMatrix, int positionX, int positionY){

        int positionSum = 0;

        if(positionY-1 >= 0){
            positionSum += originMatrix[positionX][positionY-1];
        }
        
        if(positionY+1 < originMatrix[positionX].length){
            positionSum += originMatrix[positionX][positionY+1];
        }

        return positionSum;
    }
}
