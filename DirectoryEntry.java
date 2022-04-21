/*Directory Entry class*/

public class DirectoryEntry
{
	//declare fields
	String name;
	String number;

	//constructors
	public DirectoryEntry()
	{
		name = "default";
		number = "0";
	}

	public DirectoryEntry(String name, String number)
	{
		this.name = name;
		this.number = number;
	}

	//accessor methods
	public String getName()
	{	return name;	}

	public String getNumber()
	{	return number;	}

	//mutator methods
	public void setName(String name)
	{	this.name = name;	}

	public void setNumber(String number)
	{	this.number = number;	}

	//isEquals method
	public boolean isEquals(Object d)
	{
		DirectoryEntry other = (DirectoryEntry)d;
		return (other.getName().equalsIgnoreCase(name) && other.getNumber().equalsIgnoreCase(number));
	}

	//toString
	public String toString()
	{
		return name + "\n" + number + "\n";
	}
}
