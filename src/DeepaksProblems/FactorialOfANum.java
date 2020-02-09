package DeepaksProblems;

//prime Series
public class FactorialOfANum {

	public static void main(String[] args) {
		int number = 100;
		int[] array = new int[number];
		
		for(int i=2;i<number;i++) {
			if(isPrimeNo(i))
				System.out.println(""+i);
		}
	}
	public static boolean isPrimeNo(int checkPrime) {
		boolean isPrime = true;
		for(int j=2;j<checkPrime;j++) {
			if(checkPrime%j == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
