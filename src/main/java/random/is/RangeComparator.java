package random.is;

import java.util.Comparator;

public class RangeComparator implements Comparator<Range>{

	public int compare(Range r1, Range r2) {
		int res = 0;
		if(r1.getLower() < r2.getLower() && r1.getUpper() < r2.getLower())
			res = -1;
		else if(r2.getLower() < r1.getLower() && r2.getUpper() < r1.getLower())
			res = 1;
		else 
			res = 0;
		return res;
	}
	
}
