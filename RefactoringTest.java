package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class Modify_DateTest {

	// Declare default Date object use in all test methods
	Modify_Date testing = new Modify_Date();
	int testDay = 1;
	int testMonth = 1;
	int testYear = 2002;

	@Test
	public void testGetMonth() {
		Modify_Date date = new Modify_Date(1, 1, 2002);
		date.getMonth();
		Assert.assertTrue(testing.getMonth() == testMonth);

	}

	@Test
	public void testDay() {
		Modify_Date testing = new Modify_Date(testMonth, testDay, testYear);
		Assert.assertTrue(testing.getDay() == testDay);
	}

	@Test
	public void testYear() {
		Modify_Date testing = new Modify_Date(testMonth, testDay, testYear);
		Assert.assertTrue(testing.getYear() == testYear);
	}

	@Test
	public void testEquals() {
		Modify_Date testing = new Modify_Date(testMonth, testDay, testYear);

		Modify_Date date1 = new Modify_Date(3, 3, 2005);
		Modify_Date date2 = new Modify_Date("March", 3, 2005);
		Modify_Date dateDiffer = new Modify_Date(1, 1, 2000);

		assertTrue(date1.equals(date2));
		assertFalse(date1.equals(dateDiffer));
	}

	@Test
	public void getMonthTest() {

		testing.getMonth();
		Assert.assertEquals(2, 2);
	}

	@Test
	public void testmonthString() {

		Assert.assertTrue(testing.monthString(3).equalsIgnoreCase("March"));
	}

	@Test
	public void testmonthOK() {

		String testMonth = "July";

		Assert.assertTrue(testing.monthOK(testMonth) == true);
	}

}
