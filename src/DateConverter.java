import java.util.*;

public class DateConverter {
	
	public static int daysInTheMonth(int month){
		if (month == 1|| month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
			return 31;
		}
		else if (month == 2){
			return 28;
		}
		else {
			return 30;
		}
	}
	
	
	public static int dayNumber(int month) throws DayException{
		Scanner keyboard = new Scanner(System.in);
		int day;
		
		System.out.println("Enter the day");
		
		try{
			day = keyboard.nextInt();
			if (day <= 0 || day > daysInTheMonth(month) && month != 2){
				throw new DayException();
			}
		}
		catch(InputMismatchException e){
			throw new DayException();
		}
		return day;
	}
	
	
	public static int monthNumber() throws MonthException{
		Scanner keyboard = new Scanner(System.in);
		int month;
		
		System.out.println("Enter the number of the month");
		try{
			month = keyboard.nextInt();
			if(month > 12 || month <= 0){
				throw new MonthException();}
		}
			catch(InputMismatchException e){
				throw new MonthException();
			}
		return month;
	}

	
	public static int yearNumber() throws YearException{
		Scanner keyboard = new Scanner(System.in);
		int year; 
		
		System.out.println("Enter the year");
		try{
			year = keyboard.nextInt();
			if(year <= 1000 || year > 3000)
				throw new YearException();
		}
		catch(InputMismatchException e){
			throw new YearException();
		}
		return year;
	}
	
	
	public static int leapYear(int day, int year) throws DayException{
		int daysInMonth = daysInTheMonth(2);
		if (year % 4 == 0)
			daysInMonth++;
		if (day<= 0 || day > daysInMonth)
		{
			throw new DayException();
		}
		else return day;
	}
	
	
	public static String monthAsString(int month){
		if (month == 1)
			return "January";
		else if (month == 2)
			return "February";
		else if (month == 3)
			return "March";
		else if (month == 4)
			return "April";
		else if (month == 5)
			return "May";
		else if (month == 6)
			return "June";
		else if (month == 7)
			return "July";
		else if (month == 8)
			return "August";
		else if (month == 9)
			return "September";
		else if (month == 10)
			return "October";
		else if (month == 11)
			return "November";
		else if (month == 12)
			return "December";
		else return "Error";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month = 1;
		int day = 1;
		int year = 2000;
		
		
		
		boolean validMonth = false;
		while(!validMonth){
			try{
				month = monthNumber();
				validMonth = true;
			}
			catch (MonthException e){
				System.out.println(e.getMessage());
			}
		}
		boolean validYear = false;
		while(!validYear){
			try{
				year = yearNumber();
				validYear = true;
			}
			catch (YearException e){
				System.out.println(e.getMessage());
			}
		}
		
		boolean validDay = false;
		while(!validDay){
			try{
				day = dayNumber(month);
				validDay = true;
			}
			catch (DayException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		if(month == 2){
			boolean februaryDateCheck = false;
			while(!februaryDateCheck){
				System.out.println("Checking February");
				try{
					day = leapYear(day, year);
					februaryDateCheck = true;
				}
				catch(DayException e) {
					System.out.println(e.getMessage());
				}
				try{
					day = dayNumber(month);
				}
				catch(DayException e){
					
				}
			}
		}
		System.out.println("The date is: " + monthAsString(month) + " " + day + ", " + year);
	}

}
