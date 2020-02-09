package SelectionSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     int size = Integer.parseInt(br.readLine()); 
	     String[] originalInput = br.readLine().split(" ");
	     int[] numberArray = new int[size];
	     for(int j = 0; j<size;j++) {
	    	 numberArray[j]=Integer.parseInt(originalInput[j]);
	     }
	}
	
	public int findSmallestNumberIndex(int[] subIntgerArray,int startIndex) {
		int index= 0;
		for(int i = startIndex; i<subIntgerArray.length ; i ++ ) {
			int tempValue = subIntgerArray[i];
		}
		
		
		return index;
	}

}
