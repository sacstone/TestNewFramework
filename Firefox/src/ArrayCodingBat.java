
public class ArrayCodingBat {

	public static void main(String[] args) {
		
		int [] nums = {1,2,3,4};
		
		System.out.println(asending(nums));
		

	}
	
	public static boolean asending(int[] scores){
		
		for(int i = 0; i < scores.length-1; i ++){
			
			int min = i;
			
			for(int j = i +1; j < scores.length; j ++){
				if (scores[j] < scores[i]){
					return true;
				}
			}
		}
		
		
		
		
		return false;
		
		
	}

}
