package admin.models;

public class RingNumber {
	private int counter = 0,
		limit = 0;

	public RingNumber(int limit) {
		if (limit < 0)
			throw new IllegalArgumentException("Limit can not be negative");
		this.limit = limit;
	}

	public int inc() {
		if (counter == limit)
			counter = 0;
		else
			++counter;
		return counter;
	}

	public int dec() {
		if (counter == 0)
			counter = limit;
		else
			--counter;
		return counter;
	}
}
