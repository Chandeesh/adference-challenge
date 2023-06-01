package fragments;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testFragments {
	
	private OddOccurrenceNumber oddOccurrenceNumber;
	private SameCharAmountXO sameCharAmountXO;
	private SumSmallestNumbers smallestNumbers;
	
	@Before
	public void setup() {
		oddOccurrenceNumber = new OddOccurrenceNumber();
		sameCharAmountXO = new SameCharAmountXO();
		smallestNumbers = new SumSmallestNumbers();
	}
	
	@Test
	public void testOddOccurrence() {
		Assert.assertEquals(smallestNumbers.sumSmallestNumbers(new int[] {1, 2, 3, 4}), 3);
		Assert.assertEquals(smallestNumbers.sumSmallestNumbers(new int[] {6, 7, 56, 2, 9, 34, 3}), 5);
		Assert.assertEquals(smallestNumbers.sumSmallestNumbers(new int[] {4, 4}), 8);
		Assert.assertEquals(smallestNumbers.sumSmallestNumbers(new int[] {5, 38, 15, 1, 1, -19, 9}), -18);
		Assert.assertEquals(smallestNumbers.sumSmallestNumbers(new int[] {1, 1, 1, 1}), 2);
	}
	
	@Test
	public void testSameXOAmount( ) {
		Assert.assertEquals(sameCharAmountXO.sameXOAmount("xXoO"), true);
		Assert.assertEquals(sameCharAmountXO.sameXOAmount("aAxXXbBoOo"), true);
		Assert.assertEquals(sameCharAmountXO.sameXOAmount("abc"), true);
		Assert.assertEquals(sameCharAmountXO.sameXOAmount("OaAxXbBoO"), false);
		Assert.assertEquals(sameCharAmountXO.sameXOAmount("xgXoXsdxOxz"), false);
		Assert.assertEquals(sameCharAmountXO.sameXOAmount("aaAmmMxMM"), false);

	}
	
	@Test
	public void testOddOccurrenceNumber() {
		Assert.assertEquals(oddOccurrenceNumber.findOddAmount(new int[] {1, 2, 2, 3, 3}), 1);
		Assert.assertEquals(oddOccurrenceNumber.findOddAmount(new int[] {8, 8, 7, 7, 7}), 7);
		Assert.assertEquals(oddOccurrenceNumber.findOddAmount(new int[] {10, 3, 3, 10, 6, 10, 6, 1, 1}), 10);
	}
}
