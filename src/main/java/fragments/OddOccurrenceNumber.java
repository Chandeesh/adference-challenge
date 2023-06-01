package fragments;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OddOccurrenceNumber {
	
	public int findOddAmount(int[] numbers) {
		Map<Integer, Integer> values = new HashMap<>();
		for(int i=0; i<numbers.length; i++) {
			if(values.containsKey(numbers[i])) {
				values.put(numbers[i], values.get(numbers[i])+1);
			} else {
				values.put(numbers[i], 1);
			}
		}
		Iterator<Integer> itr = values.keySet().iterator();
		while(itr.hasNext()) {
			int key = itr.next();
			if(values.get(key) %2 !=0) {
				return key;
			}
		}
		return 0;
	}
	
}
