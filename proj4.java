//driver program for prog4

import java.util.*;
import java.io.*;

public class proj4
{
	public static void main(String[] args) throws IOException
	{
		//declare varaibles
		Scanner sc = new Scanner(System.in);
		Boolean rerun = false;
		PhoneDirectory pd;
	
		//do while for rerun
		do
		{
		//display menu


		//user input for menu selection
		int input = sc.nextInt();
		while(input<1 || input>6)
		{
			System.out.println("\nError: Please enter a number 1-6");
			input = sc.nextInt();
		}

		//switch statement for selection
		switch(input)
		{
			case 1:
				//load previously saved directory from file
				System.out.println("\nPlease enter the file name:");
				sc.nextLine();
				String filename = sc.nextLine();
				BufferedReader br = new BufferedReader(new FileReader(filename));
				
				//read in lines
				pd = new PhoneDirectory();
				String line = br.readLine();
				while(line != null)
				{
					String[] lineList = line.split(",");
					pd.addOrChangeEntry(lineList[0],lineList[1]);
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				//quit
		}

	
		//user input for rerun
		}
		while(rerun);
	}
}
