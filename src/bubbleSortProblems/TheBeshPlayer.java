package bubbleSortProblems;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheBeshPlayer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream out = new BufferedOutputStream(System.out);
		String[] arraySizeInput = br.readLine().split(" ");
		int arraySize = Integer.parseInt(arraySizeInput[0]);
		int thresholdQuotient = Integer.parseInt(arraySizeInput[1]);
		Fan[] originIntArray = new Fan[arraySize];
		//int[] positionArray = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			String[] originalString = br.readLine().split(" ");
			int fanQuotient = Integer.parseInt(originalString[1]);
			if(fanQuotient > thresholdQuotient ) {
				originIntArray[i] = new Fan(originalString[0],fanQuotient);
			}
			//positionArray[i] = i;
		}
		Arrays.sort(originIntArray);
		//Bubble sorting this
//		for(int i=0;i<arraySize;i++) {
//			for(int j=0;j<arraySize-i-1;i++) {
//				if(originIntArray[j+1].getFanQuotient() < originIntArray[j+1].getFanQuotient()) {
//					Fan temp = originIntArray[j+1];
//					originIntArray[j+1] = originIntArray[j];
//					originIntArray[j] = temp;
//				}else if(originIntArray[j+1].getFanQuotient() == originIntArray[j+1].getFanQuotient()) {
//					
//				}s
//			}
//		}
		for(int j=originIntArray.length-1;j>=0;j--) {
			if(originIntArray[j].isPrint() && originIntArray[j].getFanQuotient() > thresholdQuotient && originIntArray[j].getName().length() < 20)
			out.write((originIntArray[j].getName()+"\n").getBytes());
		}
		out.flush();
		out.close();
		
		
		
	}

}

class Fan implements Comparable<Fan>{
	String name;
	int fanQuotient;
	boolean print=true;
	
	
	public Fan() {
		super();
	}
	
	public Fan(String name,int fanQuotient) {
		this.name = name;
		this.fanQuotient = fanQuotient;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFanQuotient() {
		return fanQuotient;
	}
	public void setFanQuotient(int fanQuotient) {
		this.fanQuotient = fanQuotient;
	}
	public boolean isPrint() {
		return print;
	}
	public void setPrint(boolean print) {
		this.print = print;
	}

	@Override
	public int compareTo(Fan o) {
		if(this.fanQuotient > o.getFanQuotient()) {
			return 1;
		}else if(this.fanQuotient == o.getFanQuotient()) {
			if(this.name.length() < o.getName().length()) {
				return 1;
			}else {
				this.setPrint(false);
				return -1;
			}
		}
		return -1;
	}
	
	
}
