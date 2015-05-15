package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class CurrentLoadPercentageMatcher extends TypeSafeMatcher<Server>{
	private double expectedLoadPercentage;
	private static final double EPSILON = 0.01d;
	
	public CurrentLoadPercentageMatcher(double expectedLoadPercentage) {
		this.expectedLoadPercentage = expectedLoadPercentage;
	}

	public void describeTo(Description description) {
		description.appendText("a server with load percentage of ")
				.appendValue(expectedLoadPercentage);

	}

	@Override
	protected void describeMismatchSafely(Server item, Description description) {
		description.appendText("a server with load perentage of ")
				.appendValue(item.currentLoadPercentage);
	}

	@Override
	protected boolean matchesSafely(Server server) {
		return equalsDouble(server.currentLoadPercentage, this.expectedLoadPercentage);
	}

	private boolean equalsDouble(double d1, double d2) {
		return d1 == d2 || Math.abs(d1 - d2) < EPSILON;
	}

	public static CurrentLoadPercentageMatcher hasLoadPercentageOf(
			double expectedLoadPercentage) {
		return new CurrentLoadPercentageMatcher(expectedLoadPercentage);
	}
}
