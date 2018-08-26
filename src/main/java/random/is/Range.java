package random.is;

public class Range {

	private int lower;
	private int upper;
	
	public Range(int lower,int upper) {
		this.lower = lower;
		this.upper = upper;
	}
	
	public int getLower() {
		return lower;
	}
	public void setLower(int lower) {
		this.lower = lower;
	}
	public int getUpper() {
		return upper;
	}
	public void setUpper(int upper) {
		this.upper = upper;
	}
	
	@Override
	public String toString() {
		return String.format("(%d,%d)",lower,upper);
	}
}
