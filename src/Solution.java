import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER_ARRAY wallPoints
     *  3. INTEGER_ARRAY lengths
     */

	public static int solve(int h, List<Integer> wallPoints, List<Integer> lengths) {
		int maxLadderHeight = 0;
		for (int i = 0; i < wallPoints.size(); i++) {
			double doubleHeight = wallPoints.get(i)+lengths.get(i)*0.25-(lengths.get(i)*0.5)-h;
			int height =(int) Math.ceil(doubleHeight);
			//System.out.println(doubleHeight);
			if(height > maxLadderHeight) {
				maxLadderHeight = height;
			}
		}
		return maxLadderHeight;
	}

}



public class Solution {
	
	public static void reversTheStringButNotSpecialChar() {

		String inputString = "#ss@i43";
		String specialChar = "~!@#$%^&*(){}<>?";
		char[] output = inputString.toCharArray();
		int i = 0 ;
		int k = output.length-1 ;
		for(i=0;i<output.length && k >=0 && i < k;) {
			if(specialChar.contains(Character.toString(output[i]))) {
				i++;
			}else if ( specialChar.contains(Character.toString(output[k]))) {
				k++;
			}else {
				char temp = output[k];
				output[k]= output[i];
				output[i]=temp;
				k--;
				i++;
			}
		}
		System.out.println(String.valueOf(output));

	}
    public static void main(String[] args) throws IOException {
    	String inputString = "the.string.....has.many.things";
    	String specialChar = ".";
    	char[] output = inputString.toCharArray();
    	int i = 0 ;
    	int specialCounter = 0;
    	int wordCounter = 0;
    	for(i=1;i<output.length-1;i++) {
    		if(specialChar.contains(Character.toString(output[i]))) {
    			specialCounter++;
    			if(!specialChar.contains(Character.toString(output[i-1])) || !specialChar.contains(Character.toString(output[i+1]))) {
    				wordCounter++;
    			}
    		}
    	}
    	System.out.println(specialCounter + "    " +wordCounter);
    }
}
