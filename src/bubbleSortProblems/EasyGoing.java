package bubbleSortProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class EasyGoing {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 int noOfTestCases = Integer.parseInt(br.readLine()); 
		 for(int i = 0 ;i< noOfTestCases;i++) {
			 String[] nm = br.readLine().split(" ");
			 int n = Integer.parseInt(nm[0]);
			 int m = Integer.parseInt(nm[1]);
			 String[] originalInput = br.readLine().split(" ");
		     int[] numberArray = new int[n];
		     for(int j = 0; j<n;j++) {
		    	 numberArray[j]=Integer.parseInt(originalInput[j]);
		     }
		     //With Bubble sort 
//			int counter = 0;
//			for(int j = 0; j<n-1;j++) {
//				for(int i1 = 0 ; i1 < n-1-j ; i1++) {
//					int temp = 0;
//					if(numberArray[i1]>numberArray[i1+1]) {
//						temp = numberArray[i1+1];
//						numberArray[i1+1] = numberArray[i1];
//						numberArray[i1] = temp;
//						counter +=1;
//					}
//				}
//				if(counter == 0) {
//					break;
//				}
//			}
//			for(int k =0;k<n;k++ ) {
//				System.out.println(numberArray[k]);
//			}
		     //With library sort
		     Arrays.sort(numberArray);
//			for(int k =n-1;k>=m;k-- ) {
//				maxSum = maxSum+numberArray[k];
//			}
			int maxSum=0,minSum = 0;
			for(int k =0;k<n;k++ ) {
				if(k<n-m)
				minSum = minSum+numberArray[k];
				if(k>=m)
				maxSum = maxSum+numberArray[k];
			}
			System.out.println(maxSum-minSum);
		 }
	}
}
