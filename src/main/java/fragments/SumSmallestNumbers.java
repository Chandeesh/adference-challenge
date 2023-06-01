package fragments;

import java.util.Arrays;

public class SumSmallestNumbers {
		
	public int sumSmallestNumbers(int[] numbers) {
		Arrays.sort(numbers);
		return numbers[0] + numbers[1];
	}
	
}
