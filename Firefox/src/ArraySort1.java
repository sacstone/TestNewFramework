
public class ArraySort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] num = {4,356,99,0,-1,44,66,3};
		
		System.out.println("Numebr Is;:: " + num);
		
		for(int i =0; i < num.length; i ++) {
			
			System.out.println(num[i]);
		}
		
		selectionSort(num);
		
		for(int i =0; i < num.length; i ++) {
			
			System.out.println(num[i]);
		}
		

	}
	
	public static void selectionSort(int[] ray){
		
		for (int i =0; i < ray.length-1; i++){
			
			int min=i;
			
			for(int j= i+1; j < ray.length; j ++){
				
				if(ray[j] < ray[min]) 
					min = j;
				}
				
				if(min != i){
					
					int temp = ray[min];
					ray[min] = ray[i];
					ray[i] = temp;
				}
			
			
			
		}
		
		
	}

}
