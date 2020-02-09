package bubbleSortProblems;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortItOut {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream out = new BufferedOutputStream(System.out);
		int arraySize = Integer.parseInt(br.readLine());
		String[] originalString = br.readLine().split(" ");
		IndexValue[] originIntArray = new IndexValue[arraySize];
		//int[] positionArray = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			originIntArray[i] = new IndexValue(Integer.parseInt(originalString[i]),i);
			//positionArray[i] = i;
		}
		//Bubble sort
		for (int j = arraySize - 1; j >=0 ; j--) {
			for (int i = arraySize - 1 - j; i >0 ; i--) {
				IndexValue temp;
				if (originIntArray[i-1].getValue() > originIntArray[i].getValue()) {
					temp = originIntArray[i - 1];
					originIntArray[i - 1] = originIntArray[i];
					originIntArray[i] = temp;
				}
			}
		}
		//Possible QuickSort . Use one of these.
		Arrays.sort(originIntArray);
		
		for(int i = 0;i<arraySize;i++) {
			out.write((originIntArray[i].getIndex()+" ").getBytes());
		}
		out.flush();
		out.close();
	}
	
	
}

class IndexValue implements Comparable<IndexValue> {
	int value;
	int index;
	
	IndexValue(){
		super();
	}
	IndexValue(int value,int index){
		this.value = value;
		this.index = index;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int compareTo(IndexValue o) {
		if(this.value > o.value) {
			return 1;
		}else if (this.value < o.value) {
			return -1;
		}
		return 0;
	}
}
