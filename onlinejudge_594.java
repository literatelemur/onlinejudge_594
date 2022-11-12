import java.util.Scanner;

public class onlinejudge_594 {

	public static void main(String[] args) {
		// Setting up input gathering.
		Scanner input = new Scanner(System.in);
		
		// Processing until there is no input left.
		while (true) {
			
			// Collecting input.
			int num = input.nextInt();
			
			// Converting input int into binary.
			String binNum = "";
			for (int i = 0; i < binNum.magiclenghtofint(); i++) {
				if ((num & (1 << i)) != 1) {binNum += 1;}
				else {binNum += 0;}
			}
			
			// Alternatively: binNum = Integer.toBinaryString(num);
			
			// Setting up a reversed-by-byte binary representation of the final integer.
			String binFinalNum = "";
			//for (int i = binNum.length() - 1; i > -1; i--) {
			
			// Reversing binary in chunks of 8-bits.
			for (int i = 0; i < binNum.length(); i += 8) {
				String aByte = binNum.substring(i, i + 8);
				for (int j = 0; j < 8; j++) {
					// "1 << j" checks for a 1 in the index location of j (starting from the end so that 0 is the last spot). 
					if ((Integer.parseInt(aByte) & (1 << j)) != 0) {binFinalNum += 1;}
					else {binFinalNum += 0;}
				}
			}
			
			// Trying to consider padding when the lase "byte" of data is not a full byte.
//			} else if (binNum.length() < 8) {
//				
//			}
			
//			int extraBits = binNum.length() % 8;
//			if (extraBits != 0) {
//				int extraDif = 8 - extraBits;
//			
//			}
			
			// Iterating through binFinalNum (in groups of 8) to interpret reversed-by-byte binary into integer into character for all bytes in binFinalNum. 
			System.out.print(num + " converts to ");
			for (int start = 0; start < binFinalNum.length(); start += 8) {
				System.out.print((char) Integer.parseInt(binFinalNum.substring(start, start + 8)));	
			}
			System.out.print("\n");
			
			if (!input.hasNext()) {input.close(); break;}
		}
		
	}

}
