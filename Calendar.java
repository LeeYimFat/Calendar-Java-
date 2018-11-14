package code;
import java.util.Scanner;

public class Calendar {

	public static boolean leap_year(int year)
	{
		if (year % 4 ==0 && year % 100 != 0 || year % 400 ==0){return true;}
		
		else {return false;}
	}
	
	public static int Monthdays(int year, int month) 
	{
		int Monthday = 0;
		if (month == 2)
		{
			if (leap_year(year))
			{
				Monthday = 29;
			}
			else 
			{
				Monthday = 28;
			}
		}
		if (month == 1 || month == 3 || month==5 || month==7|| month ==8 || month==10||month==12)
		{
			Monthday = 31;
		}
		if (month == 4 || month == 6 || month==9 || month==11)
		{
			Monthday = 30;
		}
		return Monthday;
	}
	
	public static int Totaldays(int year, int month)
	{
		int Totalday = 0;
		for (int i=1;i < year; i++)
		{
			if (leap_year(i))
			{
				Totalday += 366;
			}
			else {Totalday += 365;}
		}
		for (int i = 1; i < month; i++)
		{
			Totalday += Monthdays(year,i);
		}
		return Totalday;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner input = new Scanner(System.in);
		
		System.out.println("Year: ");
		int year = input.nextInt();
		System.out.println("Month: ");
		int month = input.nextInt();
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		System.out.println("--------------------------------------");
		
		int count = 0;
		/*The following two loops are the most important parts in the program.
		  Most calendar begins from Sunday while A.D. 1.1.1 is Monday. This is the reason for the "+1" in line 73.
		  The first loop is to determined the weekday of the first day of the input(year,month).
		  The second loop is to print days and when it comes to Saturday, change line.
		 */
		for (int i = 0; i < ((Totaldays(year,month)%7)+1); i++)
		{
			System.out.print("\t");
			count += 1;
		}
		for (int i =1 ; i < Monthdays(year,month)+1; i++)
		{
			System.out.print(i + "\t");
			count += 1;
			if (count % 7 ==0)
			{
				System.out.println(" ");
			}
		}
		input.close();
	}
}
