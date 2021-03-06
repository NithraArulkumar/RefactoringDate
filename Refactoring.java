package testing;

import java.util.Scanner;

public class Modify_Date {

	private String month;
	private int day;
	private int year; // a four digit number.

	public Modify_Date() {
		month = "January";
		day = 1;
		year = 1000;
	}

	public Modify_Date(int monthInt, int day, int year) {
		setDate(monthInt, day, year);
	}

	public Modify_Date(String monthString, int day, int year) {
		setDate(monthString, day, year);
	}

	public Modify_Date(int year) {
		setDate(1, 1, year);
	}

	public Modify_Date(Modify_Date aDate) {
		if (aDate == null)// Not a real date.
		{
			System.out.println("Fatal Error.");
			System.exit(0);
		}

		month = aDate.month;
		day = aDate.day;
		year = aDate.year;
	}

	public void setDate(int monthInt, int day, int year) {
		if (dateOK(monthInt, day, year)) {
			this.month = monthString(monthInt);
			this.day = day;
			this.year = year;
		} else {
			System.out.println("Fatal Error");
			System.exit(0);
		}
	}

	public void setDate(String monthString, int day, int year) {
		if (dateOK(monthString, day, year)) {
			this.month = monthString;
			this.day = day;
			this.year = year;
		} else {
			System.out.println("Fatal Error");
			System.exit(0);
		}
	}

	public void setDate(int year) {
		setDate(1, 1, year);
	}

	public void setYear(int year) {
		if ((year < 1000) || (year > 9999)) {
			System.out.println("Fatal Error");
			System.exit(0);
		} else
			this.year = year;
	}

	/*
	 * sets month field. this method was added for the testing
	 */
	public void setMonthString(String month) {

		this.month = month;
	}

	public void setMonth(int monthNumber) {
		if ((monthNumber <= 0) || (monthNumber > 12)) {
			System.out.println("Fatal Error");
			System.exit(0);
		} else
			month = monthString(monthNumber);
	}

	public void setDay(int day) {
		if ((day <= 0) || (day > 31)) {
			System.out.println("Fatal Error");
			System.exit(0);
		} else
			this.day = day;
	}

	// New java features changes on data variable(instead of int we used "var"
	public int getMonth() {

			return switch (month) {

			case "January" -> 1;

			case "February" -> 2;

			case "March" -> 3;

			case "April" -> 4;

			case "May" -> 5;

			case "June" -> 6;

			case "July" -> 7;

			case "August" -> 8;

			case "September" -> 9;

			case "October" -> 10;

			case "November" -> 11;

			case "December" -> 12;

			default -> {
				System.out.println("Fatal Error");
				System.exit(0);
				yield 0;
				// Needed to keep the compiler happy

			}

			};

		}

	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}

	public String toString() {
		return (month + " " + day + ", " + year);
	}

	public boolean equals(Modify_Date otherDate) {
		return ((month.equals(otherDate.month)) && (day == otherDate.day) && (year == otherDate.year));
	}

	public boolean precedes(Modify_Date otherDate) {
		return ((year < otherDate.year) || (year == otherDate.year && getMonth() < otherDate.getMonth())
				|| (year == otherDate.year && month.equals(otherDate.month) && day < otherDate.day));
	}

	// New java features changes on data variable(instead of int we used "var"
	public void read_Input() {

		var tryAgain = true;

		Scanner keyboard = new Scanner(System.in);

		while (tryAgain) {
			System.out.println("Enter month, day, and year.");
			System.out.println("Do not use a comma.");
			String monthInput = keyboard.next();
			var dayInput = keyboard.nextInt();
			var yearInput = keyboard.nextInt();

			if (dateOK(monthInput, dayInput, yearInput)) {
				setDate(monthInput, dayInput, yearInput);
				tryAgain = false;
			} else
				System.out.println("Illegal date. Reenter input.");
		}
	}

	private boolean dateOK(int monthInt, int dayInt, int yearInt) {
		return ((monthInt >= 1) && (monthInt <= 12) && (dayInt >= 1) && (dayInt <= 31) && (yearInt >= 1000)
				&& (yearInt <= 9999));
	}

	private boolean dateOK(String monthString, int dayInt, int yearInt) {
		return (monthOK(monthString) && (dayInt >= 1) && (dayInt <= 31) && (yearInt >= 1000) && (yearInt <= 9999));
	}

	// New java features changes on switch case JDk 14 version
	boolean monthOK(String month) {
		return switch (month) {
		case "January" -> true;
		case "February", "March" -> true;
		case "April" -> true;
		case "May", "June" -> true;
		case "July", "August" -> true;
		case "September", "October" -> true;
		case "November", "December" -> true;
		default -> false;
		};
	}
	// New java features changes on switch case

	public String monthString(int monthNumber) {

			return switch (monthNumber) {

			case 1 -> "January";

			case 2 -> "February";

			case 3 -> "March";

			case 4 -> "April";

			case 5 -> "May";

			case 6 -> "June";

			case 7 -> "July";

			case 8 -> "August";

			case 9 -> "September";

			case 10 -> "October";

			case 11 -> "November";

			case 12 -> "December";

			default -> {
				System.out.println("Fatal Error");
				System.exit(0);
				yield "Error";// Needed to keep the compiler happy

			}

			};

		}

}
