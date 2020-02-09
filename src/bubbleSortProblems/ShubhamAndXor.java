package bubbleSortProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShubhamAndXor {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Date startTime = new Date();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int counter = 0;
		//BufferedOutputStream out = new BufferedOutputStream(System.out);
		int arraySize = Integer.parseInt(br.readLine());
		String[] originalString = br.readLine().split(" ");
		//List<Integer> uniList = new ArrayList<Integer>(arraySize);
		Map<Integer,Integer> uniList = new HashMap<Integer,Integer>(arraySize);
		for (int i = 1; i <= arraySize; i++) {
			//originIntArray[i] = Integer.parseInt(originalString[i]);
			Integer putThis = Integer.parseInt(originalString[i]);
			if(uniList.containsKey(putThis)) {
				counter +=1;
			} else {
				uniList.put(putThis,putThis);
			}
		}
		System.out.println(counter);
		//System.out.println("Time Diff "+(new Date().getTime()-startTime.getTime()));
		// Bubble sort
//		for (int j = 0; j < arraySize; j++) {
//			for (int i =j+1 ; i < arraySize; i++) {
//				if ((originIntArray[j] ^ originIntArray[i])==0) {
//					counter=counter+1;
//				}
//			}
//		}
		
		// Possible QuickSort . Use one of these.
		//Arrays.sort(originIntArray);
	}

}
