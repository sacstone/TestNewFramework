import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListExamples {

	public static void main(String[] args) {

		ArrayList<String> str1 = new ArrayList<>(Arrays.asList("four", "score", "and", "seven", "years", "ago", "Ramesh", "Thanvi", "Goldie"));

//		System.out.println(str1);
		swapWords1(str1);
		
		
//		ArrayList<String> str = new ArrayList<String>();
//
//		str.add("four");
//		str.add("score");
//		str.add("and");
//		str.add("seven");
//		str.add("years");
//		str.add("ago");
//		str.add("Ramesh");
//		str.add("Thanvi");

		// System.out.println(str);

		// String temp = str.get(0);
		// str.set(0, str.get(1));
		// str.set(1, temp);
		//
		// String temp1 = str.get(2);
		// str.set(2, str.get(3));
		// str.set(3, temp1);
		//
		// String temp2 = str.get(4);
		// str.set(4, str.get(5));
		// str.set(5, temp2);
		//
		// System.out.println(str);

		// swapWords(str);

	}

	public static void swapWords(ArrayList<String> str) {

		for (int i = 0; i < str.size(); i++) {

			String temp = str.get(i);
			str.set(i, str.get(i + 1));
			str.set(i + 1, temp);
			i++;

		}

		System.out.println(str);

	}

	public static void swapWords1(ArrayList<String> str) {

		if (str.size() % 2 == 0) {

			for (int i = 0; i < str.size(); i++) {

				String temp = str.get(i);
				str.set(i, str.get(i + 1));
				str.set(i + 1, temp);
				i++;

			}

		//	System.out.println(str);

		} else {

			for (int i = str.size() -2; i >0; i--) {

				String temp = str.get(i);
				str.set(i, str.get(i -1 ));
				str.set(i - 1, temp);
				i--;

			}

			
		}
		System.out.println(str);

	}

}
