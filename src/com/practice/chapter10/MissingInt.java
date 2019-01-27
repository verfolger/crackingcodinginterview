package com.practice.chapter10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MissingInt {

	long noOfInts = ((long) Integer.MAX_VALUE) + 1;
	byte[] bitFields = new byte[(int) (noOfInts / 8)];
	
	String fileName = "/Users/banashrimandal/Downloads/test.txt";
	
	
	void findOpenNumber() throws FileNotFoundException {
		
		Scanner in = new Scanner(new FileReader(fileName));
		
		while (in.hasNextInt()) {
			int n = in.nextInt();
			bitFields[n / 8] |= 1 << (n % 8);
			System.out.println("Value : " + n + " value : " + bitFields[n / 8]);
		}
		
		for (int i = 0; i < bitFields.length; i++) {
			
			for (int j = 0; j < 8; j++) {
				if ((bitFields[i] & (1 >> j)) == 0 ) {
					System.out.println(i * 8 + j);
					return;
				}
			}
		}	
	}
	public static void main(String[] args) throws Exception {
		
		MissingInt m = new MissingInt();
		m.findOpenNumber();
		
	}

}
