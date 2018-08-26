package random.is;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class App {
	
	
	public static void main(String[] args) {
		int n = 100;
		List<Range> ranges = new ArrayList<Range>();
		ranges.add(new Range(0,n-1));
		int[] arr = populateArr(n);
		int[] results = new int[n];
		for(int i=0; i<n; i++) {
			Range range = getRangeToInsert(ranges);
			insertToRangeAndUpdateRangeToRangesList(ranges,range,results,arr[i]);
		}
		for(int res : results)
			System.out.println(res);
	}
	
	private static void insertToRangeAndUpdateRangeToRangesList(List<Range> ranges, Range range, int[] results, int num) {
		int index = getRandomInRange(range);
		results[index] = num;
		List<Range> rangesToAdd = new ArrayList<Range>();
		if(index == range.getLower() && index == range.getUpper()) {
			ranges.remove(ranges.indexOf(range));
		}
		else if(index == range.getLower()) {
			rangesToAdd.add(new Range(index+1,range.getUpper()));
			ranges.remove(ranges.indexOf(range));
		}
		else if(index == range.getUpper()) {
			rangesToAdd.add(new Range(range.getLower(), index - 1));
			ranges.remove(ranges.indexOf(range));
		}
		else {
			Range lowerRange = new Range(range.getLower(),index - 1);
			Range upperRange = new Range(index + 1,range.getUpper());
			rangesToAdd.add(lowerRange);
			rangesToAdd.add(upperRange);
			ranges.remove(ranges.indexOf(range));
		}
		ranges.addAll(rangesToAdd);
	}

	private static Range getRangeToInsert(List<Range> ranges) {
		return ranges.get(getRandomInRange(new Range(0,ranges.size() - 1)));
	}

	private static int[] populateArr(int n) {
		Random rand = new Random();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = rand.nextInt(n);
		return arr;
	}
	
	private static int getRandomInRange(Range range) {
		return ThreadLocalRandom.current().nextInt(range.getLower(), range.getUpper() + 1);
	}
	
	
}
