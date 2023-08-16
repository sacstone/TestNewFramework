import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArraySorts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ArrayList<Integer> rays;
//		
//		rays = new ArrayList<Integer>();
//		
//		rays.add(21);
//		rays.add(14);
//		rays.add(0,13);
//		rays.add(25);
//		
//		System.out.println(rays);
//		System.out.println(rays.indexOf(21));
//		System.out.println(rays.indexOf(17));
//		System.out.println(rays.indexOf(25));
//		System.out.println(rays.contains(25));
//		System.out.println(rays.contains(63));
//		
//		String s = "abcdefghijklmnop";
//		
//		System.out.println(s.indexOf(3));
//		
//		int[] ray = {3,4,5,6,11,18,91};
//		
//		System.out.println(Arrays.binarySearch(ray, 5));
//		System.out.println(Arrays.binarySearch(ray, 15));
		
//		int[] ray = {13,6,17,18,2,-5};
//		
//		Arrays.sort(ray);
//		
//		for(int i =0; i < ray.length; i++){
//			System.out.println(ray[i]);
//			
//		}
//		
		
		ArrayList<Integer> rays;
		
	rays = new ArrayList<Integer>();
//		
	rays.add(21);
	rays.add(2);
	rays.add(13);
	rays.add(-1);
	rays.add(3);
	
	Collections.sort(rays);
	
//	for(int nums: rays){
//		
//		System.out.println(nums);
//	}
//	
	int[] rq = {3, 5, 21, 54,88, 89};
	
	int [] stuff = {1,6,8,10,14,22,30,50};
	
	System.out.println(binarySearch(stuff, 25));
	
//	System.out.println(linearSearch(rq,55));;
//
		
	//System.out.println(linearSearchComparable(rq,55));;
	
	System.out.println(binarySearch(rq, 54));
	System.out.println(binarySearch(rq, 88, 0,6));
		

	}
	
	public static int linearSearch(int[] stuff, int val){
		
		for(int i = 0; i < stuff.length; i++) {
			
			if (stuff[i] == val) {
				return i;
			}
		}
		return -1;
		
		
	}

	public static int linearSearchComparable(Comparable[] stuff, Comparable item) {
		
		for(int i = 0; i < stuff.length; i ++){
			
			if(stuff[i].compareTo(item) == 0) {
				return 1;
			}
		}
		return -1;
		
	}
	
	public static int binarySearch(int [] stuff, int value){
		
		int bottom = 0 ; int top = stuff.length-1;
		
		while(bottom <=top) {
			
			int middle = (top + bottom) / 2;
			
			if(stuff[middle] == value){
				return middle;
			} else
				if (stuff[middle] > value) {
					top = middle - 1;
				} else {
					bottom = middle +1;
				}
			
		}
		
		
		
		return -1;
		
		
	}
	
	public static int binarySearch(int [] stuff, int value, int b, int t) {
		
		if(b <= t){
			
			int m = (b + t) / 2;
			
			if(stuff[m] == value) {
				return m;
				
			} 
			if (stuff[m] > value) {
				
				return binarySearch(stuff, value, b, m-1);
				
				
			} else {
				return binarySearch(stuff, value, m+1, t);
			}
			
			
		}
		
		
		
		return -1;
		
		
	}
	
}

