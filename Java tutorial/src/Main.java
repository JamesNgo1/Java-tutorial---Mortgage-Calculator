
import java.text.NumberFormat;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		//Declaration of constants for calculations.
		final int MONTHS_IN_YEAR = 12;
		final int PERCENT = 100;
		
		//These variables are placeholders as they would be form in the scope of the while loop.
		int loanAmount = 0;
		double monthlyRate = 0;
		int numberOfMonths = 0;
		
		//creation of scanner object.
		Scanner scnr = new Scanner(System.in);
		
		
		//First print statement and input for loan amount desire.
		//while block helps validate the range value of the loan.
		while(true) 
		{
			System.out.print("Enter desire loan amount: ");
			loanAmount = scnr.nextInt();
			if(loanAmount >= 1000 && loanAmount <= 1_000_000) 
			{
				break;
			}
			System.out.println("enter a value between 1000 and 1000000");
		}
		
		
		
		//second print statement ,input for annual interest rate , and variable to find monthly interest rate.
		//while loop helps validate the input of annual rate by the user.
		while(true) 
		{
			System.out.print("Enter Annual Interest Rate: ");
			double annualRate = scnr.nextDouble();
			if(annualRate >= 1 && annualRate <=30) 
			{
				monthlyRate = (annualRate / MONTHS_IN_YEAR) / PERCENT;
				break;
			}
			System.out.println("Enter annual rate between 1 and 30 percent");
		}
		
		//Third print statement , input for years , and int variable for total months.
		//while loop helps validate the input of years by the user.
		while(true) 
		{
			System.out.print("Period (Years): ");
			int years = scnr.nextInt();
			if(years >= 1 && years <= 30)
			{
				numberOfMonths = years * MONTHS_IN_YEAR;
				break;
			}
			System.out.println("Enter years within 1 and 30.");
			
		}
		
		//Below is the mathmatical formula of a mortgage.
		double mortgage = loanAmount * ((monthlyRate * Math.pow(monthlyRate + 1, numberOfMonths) / (Math.pow(monthlyRate + 1, numberOfMonths) - 1) ) );
		
		//formatted along with the USD currency symbol
		String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
		
		//printing out mortgage and closing scanner
		System.out.println(mortgageFormatted);
		scnr.close();
	}

}
