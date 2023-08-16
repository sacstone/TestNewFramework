public class MartixSumming{
   public static void main(String[] args){
       int [][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}, {6, 7, 1, 2, 5}, {5, 4, 3, 2, 1}};
       
       for (int row = 0; row < arr.length; row++){
    	   
    	   for (int col=0; col < arr[row].length; col++){
    		   System.out.print(arr[row][col] + " ");
    	   }
    	   System.out.println();
    	   
       }
       
       System.out.println("sum of 2,2 is " + sumAround(arr, 2, 2));
       
       System.out.println("The sum of 0,0 is " + sumAround(arr, 0, 0));
       System.out.println("The sum of 1,1 is " + sumAround(arr, 1, 1));
    }
   public static int sumAround(int[][] arr, int row, int col){
       int sum = 0;
       for(int r = row-1; r <= row + 1; r++){
           for(int c = col-1; c <= col + 1; c++)
                if(r >= 0 && c >= 0 && r < arr.length && c < arr[0].length)
                    sum += arr[r][c];
        }
       return sum;
    }
}

