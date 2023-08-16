import java.util.Arrays;

public class ArrayExamples {

	public static void main(String[] args) {
		
//		int [] aplus = new int[5];
//		int[][] rayORays =  new int[3][3];
//		int [][]mat = {{6,9,2},{5,3,4,6}};
		
//		int[][] mat = {{6,5,7,9,2}, {5,3,4,6}, {7,0,8}};
//		
//		final int SIZE = 40;
//		
//		int[][] intMat = new int[SIZE][SIZE];
//		
//		String[][] words = new String[4][4];
		
//		int[][] mat = {{5,7,9,2,1,9}, {5,3,4}, {3,7,0,8,9}};
//		
//		
//		System.out.println(mat[7/4][0]);
//		System.out.println(mat[1*2][2]);
//		System.out.println(mat.length);
//		System.out.println(mat[0].length);
		
		//setting matrics values
		
	//	int [][] mat = new int[3][3];
	//	mat[0][1] = 2;
		
//		for(int r = 0; r <mat.length; r++){
//			
//			for (int c=0; c < mat[r].length; c++){
//				
//				mat[r][c] = r * c;
//				System.out.print(mat[r][c] + "\t");
//				
//				
//			}
//			System.out.println();
//			
//		}
		
//		int outer = 1;
//		
//		for(outer = 1; outer <=2; outer ++){
//			
//			for(int inner = 1; inner <= 2; inner ++){
//				
//				System.out.println(outer + " " +inner);
//			}
//			System.out.println();
//		}
		
		
		
	//processing arrays with loops
		
	//	int[][] mat = new int[3][3];
		
		int[][] mat = {{5,7}, {5,3,4,6},{0,8,9}};
		
//		System.out.println(Arrays.toString(mat[0]));
//		System.out.println(Arrays.toString(mat[1]));
		
		
//		int[] nums = {1,2,3,4,5,6,7,8,9};
//		
//		for(int i = 0; i < nums.length; i++) {
//			
//			System.out.println(nums[i]);
//		}
//		
		
//		for (int r = 0 ; r < mat.length ; r ++) {
//			
//			for(int c = 0; c < mat[r].length; c++) {
//				
//				System.out.print(mat[r][c] + " ");
//			}
//			System.out.println();
//		}
//		
//		for ( int[] row: mat) {
//			
//			for(int num : row) {
//				
//				System.out.print(num + " ");
//			}
//			System.out.println();
//			
//			
//		}
		
		//search for values in matrix
		
		int count = 0;
		
		for(int r = 0; r < mat.length; r++) {
			
			for(int c = 0; c < mat[r].length; c++){
				
				if (mat[r][c] == 5) {
					count++;
				}
			}
		}
		
		System.out.println("count of 5's in the array: " + count);
		
		int count1 = 0;
		
		for(int[] rows: mat) {
			
			for(int num: rows){
				
				if ( num == 5){
					count1++;
				}
			}
		}
		
		
		System.out.println("count1 of 5's in the array: " + count);
		
		
		
		int sum = 0;
		
		for(int[] row : mat){
			
			for(int num : row) {
				
				sum +=  num;
				
			}
		}
		
 		System.out.println("sum of all numbers in array is: " + sum);

		
	}

}
