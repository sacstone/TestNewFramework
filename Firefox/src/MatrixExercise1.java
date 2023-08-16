
public class MatrixExercise1 {

	public static void main(String[] args) {
		
		
		int[][] arr = {{47,3,12},{51,74,20}};
		
		
		
		for(int row = 0; row < arr.length; row++){
			
			for(int col = 0; col < arr[row].length; col++){
				if(arr[row][col] == 47) {
					System.out.print(arr[row][col] + " ");
				} else if(arr[row][col] == 51) {
					System.out.print(arr[row][col] + " ");
				}else if(arr[row][col] == 20) {
					System.out.print(arr[row][col] + " ");
				}
			}
		}
		
		
//		int [][] mat = {{1,2,3,4,5},{6,7,8,9,0},{6,7,1,2,5},{6,7,8,9,0},{5,4,3,2,1}};
//		
//		
//		int sum=0;
//		int[][] location;
//		
//		for(int r=0; r < mat.length; r++){
//			
//			for(int c=0; c < mat[r].length ; c++){
//				
//				sum += mat[r][c];
//			}
//		}
//		System.out.println("Sum of the element : " + sum);
		
//		
//		int[] a = {650,5686,767,404,67677, 1,220};
//		
//		int min = a[0];
//		int max = a[0];
//		
//		
//		for(int i = 1; i < a.length; i++){
//			
//			if (a[i] < min ) {
//				
//				min = a[i];
//			//	max = a[i+1];
//			}
//		//	min = a[i];
//		}
//		
//		
//		System.out.println(min);
//		
//		for(int i = 1; i < a.length; i++){
//			
//			if (a[i] >max ) {
//				
//				max = a[i];
//			//	max = a[i+1];
//			}
//		//	min = a[i];
//		}
//		
//		
//		System.out.println("Max is: " + max);

	}
	
	
//	public static boolean firstLast6(int[] nums){
//		
//		boolean result= true;
//		
//		if (nums.length < 1){
//			result = false;
//			return false;
//		}
//		if (nums[0] == 6){
//			
//			result = true;
//		//	return result;
//		}else
//		if (nums[nums.length - 1] == 6){
//			
//			result = true;
//		//	return result;
//		} else
//			result = false;
//
//		
//		return result;
//		
//		
//	}

}
