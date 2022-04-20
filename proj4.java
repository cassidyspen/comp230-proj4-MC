//driver program for prog4

import java.util.*;
import java.io.*;

public class proj4
{
	public static void main(String[] args) 
	{
		//declare varaibles
		Scanner sc = new Scanner(System.in);
		Boolean rerun = false; //SHOULD THIS START AS TRUE?  no a do while automatically goes once
		PhoneDirectory pd = new PhoneDirectory();
		PrintWriter writeFile;
		String name = "";
		String number = "";

		System.out.println("Welcome to Cassidy and Madeleine's *Directory Program*\n"); 
		//do while for rerun
		do
		{
		//display menu
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
		sc.nextLine();

		//switch statement for selection
		switch(input)
		{
			case 1:
			try{
				//load previously saved directory from file
				System.out.println("\nPlease enter the file name:");
				String filename = sc.nextLine();
				BufferedReader br = new BufferedReader(new FileReader(filename));
				
				//read in lines
				//COMMENTED OUT pd = new PhoneDirectory();
				String line = br.readLine();
				while(line != null)
				{
					if(count%3 == 0)
                         name = line;
                    else if(count%3 == 1)
                         number = line;
					else
						pd.addOrChangeEntry(name, number);
					count++;	
					line = br.readLine();
				}
				System.out.println("File added");
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
				System.exit(1);
			}
				break;
			case 2:
				//add or change entry
				//get user input
				System.out.print("\nEnter the name for the entry: ");
				name = sc.nextLine();
				System.out.print("Enter the number for the entry: ");
				String number = sc.nextLine();

				//use method from Phone Directory
				pd.addOrChangeEntry(name,number);
				break;
			case 3:
				//remove an entry
				//user input
				System.out.print("\nEnter the name to be removed: ");
				name = sc.nextLine();

				//remove with method
				DirectoryEntry entry = pd.removeEntry(name);

				//display
				if(entry==null)
					System.out.println("\nEntry not found");
				else
					System.out.println("\n"+entry+"\nhas been removed");
				break;
			case 4:
				//search for an entry
				System.out.print("\nEnter a name to search: ");
				name = sc.nextLine();

				//find entry
				DirectoryEntry entry2 = pd.searchEntry(name);
				
				//display message
				if(entry2==null)
					System.out.println("\nEntry not found");
				else
					System.out.println("\nEntry found:\n\t"+entry2.toString());
				break;
			case 5:
				//display all entries
				System.out.println("\nCurrent Phone Directory:\n");
				pd.displayAllEntries();
				break;
			case 6:
				try
				{
					//get user input
					System.out.print("\nPlease enter the file name: ");
					String filename = sc.nextLine();
					System.out.print("Would you like to replace (r) or append (a)? ");
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
					
					//use toString method to get entries
					writeFile.print(pd);
					writeFile.close();

				}//end try
				catch (IOException e)
				{
					System.out.println(e.getMessage());
					System.exit(1);
				}//end catch
				break;
			default:
				//quit
				System.out.println("\nGoodbye :)");
				System.exit(0);
		}

	
		//user input for rerun
		System.out.print("\nWould you like to see the menu again?(y for yes, n for no): ");
		String choice = sc.nextLine();

		while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"))
		{
			System.out.println("\nError: Please enter \"y\" or \"n\"");
			choice = sc.nextLine();
		}
		if(choice.equalsIgnoreCase("y"))
			rerun = true;
		else
			rerun = false;
		}
		while(rerun);
		System.out.println("\nGoodbye :)");
	}
}
