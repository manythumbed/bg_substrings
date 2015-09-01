package substring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UtilitiesTest {

	@Test
	public void raiseExceptionWithNullArrayOrPattern() {
		try {
			Utilities.subStringIndex(null, new int[]{});
			fail("Illegal argument exception should be thrown");
		}
		catch (final IllegalArgumentException ignored) {
		}

		try {
			Utilities.subStringIndex(new int[]{}, null);
			fail("Illegal argument exception should be thrown");
		}
		catch (final IllegalArgumentException ignored) {
		}
	}

	@Test
	public void raiseExceptionWithEmptyArrayOrPattern()	{
		try	{
			Utilities.subStringIndex(new int[]{}, new int[]{1});
			fail("Illegal argument exception should be thrown");
		}
		catch (final IllegalArgumentException ignored)	{
		}

		try	{
			Utilities.subStringIndex(new int[]{1}, new int[]{});
			fail("Illegal argument exception should be thrown");
		}
		catch (final IllegalArgumentException ignored)	{
		}
	}

	@Test
	public void raiseExceptionWithPatternLargerThanArray()	{
		try	{
			Utilities.subStringIndex(new int[]{1}, new int[]{1, 2, 3});
			fail("Illegal argument exception should be thrown");
		}
		catch (final IllegalArgumentException ignored)	{
		}
	}

	@Test
	public void noPatternFound()	{
		assertEquals(-1, Utilities.subStringIndex(new int[]{1}, new int[]{2}));
		assertEquals(-1, Utilities.subStringIndex(new int[]{1, 1, 1, 1}, new int[]{2}));
		assertEquals(-1, Utilities.subStringIndex(new int[]{1, 1}, new int[]{2, 2}));
		assertEquals(-1, Utilities.subStringIndex(new int[]{1, 2}, new int[]{2, 2}));
		assertEquals(-1, Utilities.subStringIndex(new int[]{1, 3}, new int[]{2, 3}));
	}

	@Test
	public void patternFound()	{
		assertEquals(0, Utilities.subStringIndex(new int[]{1}, new int[]{1}));
		assertEquals(7, Utilities.subStringIndex(new int[]{2, 2, 2, 2, 2, 2, 2, 1}, new int[]{1}));
		assertEquals(6, Utilities.subStringIndex(new int[]{2, 2, 2, 2, 2, 2, 2, 1}, new int[]{2, 1}));
		assertEquals(4, Utilities.subStringIndex(new int[]{2, 2, 2, 2, 2, 2, 2, 1}, new int[]{2, 2, 2, 1}));
	}
}
