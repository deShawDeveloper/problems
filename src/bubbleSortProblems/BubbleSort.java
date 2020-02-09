package bubbleSortProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort {
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     int size = Integer.parseInt(br.readLine()); 
	     String[] originalInput = br.readLine().split(" ");
	     int[] numberArray = new int[size];
	     for(int j = 0; j<size;j++) {
	    	 numberArray[j]=Integer.parseInt(originalInput[j]);
	     }
		int counter = 0;
		for(int j = 0; j<size-1;j++) {
			for(int i = 0 ; i < size-1-j ; i++) {
				int temp = 0;
				if(numberArray[i]>numberArray[i+1]) {
					temp = numberArray[i+1];
					numberArray[i+1] = numberArray[i];
					numberArray[i] = temp;
					counter +=1;
				}
			}
		}
			System.out.println(counter);
	}
}
