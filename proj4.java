//driver program for prog4

import java.util.*;
import java.io.*;

public class proj4
{
	public static void main(String[] args) throws IOException
	{
		//declare varaibles
		Scanner sc = new Scanner(System.in);
		Boolean rerun = false; //SHOULD THIS START AS TRUE?
		PhoneDirectory pd = new PhoneDirectory();
		PrintWriter writeFile;

		//do while for rerun
		do
		{
		//display menu
		System.out.println("Welcome to Cassidy and Madeleine's *Directory Program*\n"); 
		System.out.println("Please enter a number 1-7 \n");
		System.out.println("1. Load a previously saved phone directory from file");
		System.out.println("2. Add or change an entry");
		System.out.println("3. Remove an entry");
		System.out.println("4. Search for an entry");
		System.out.println("5. Display all entries");
		System.out.println("6. Save the current phone directory to a file");
		System.out.println("7. Quit the program");

		//user input for menu selection
		int input = sc.nextInt();
		while(input<1 || input>7)
		{
			System.out.println("\nError: Please enter a number 1-7");
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
				//COMMENTED OUT pd = new PhoneDirectory();
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
				try
				{
					//get user input
					System.out.println("\nPlease enter the file name:");
					filename = sc.nextLine();
					System.out.println("\nWould you like to replace (r) or append (a)?");
					String choice = sc.nextLine();
					
					while(!choice.equalsIgnoreCase("r") && !choice.equalsIgnoreCase("w"))
					{
						System.out.println("\nPlease enter r or a");
						sc.nextLine();
					}

					if(choice.equalsIgnoreCase("r"))
						writeFile = new PrintWriter(new FileOutputStream(filename));
					else
						writeFile = new PrintWriter(new FileOutputStream(filename, true));
					
					//TODO Fix line 86 because weird error
					Iterator<DirectoryEntry> iter = pd.iterator(); 
					while(iter.hasNext())
					{
						//get name
						//get number
						//write name and number to file
						DirectoryEntry next = iter.next();
						writeFile.println(next.getName() + "," + next.getNumber());
					}
					writeFile.close();
				}//end try
				catch (IOException e)
				{
					System.out.println(e.getMessage());
					System.exit(1);
				}//end catch
			default:
				//quit
				rerun = false;
		}

	
		//user input for rerun
		}
		while(rerun);
	}
}
