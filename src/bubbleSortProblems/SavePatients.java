package bubbleSortProblems;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SavePatients {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arraySize = Integer.parseInt(br.readLine());
		String[] originalVaccineString = br.readLine().split(" ");
		
		BigInteger vaccineTotal = BigInteger.ZERO;
		BigInteger patientTotal = BigInteger.ZERO;

		String[] originalPatientsString = br.readLine().split(" ");
			
		for (int i = 0; i < arraySize; i++) {
				vaccineTotal.add(new BigInteger(originalVaccineString[i]));
		}
		for (int i = 0; i < arraySize; i++) {
			patientTotal.add(new BigInteger(originalPatientsString[i]));
		}
		if(vaccineTotal.compareTo(patientTotal) == 1) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}

}
