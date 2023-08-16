
public class DogRunner {

	public static void main(String[] args) {
		
		Dog[][] herd;
		
		herd = new Dog[3][3];
		herd[0][0]= new Dog("Ramesh", 11);
		herd[1][2] = new Dog("Thanvi", 21);
		
		System.out.println(herd[2][2]);
		System.out.println(herd[1][2]);

	}

}
