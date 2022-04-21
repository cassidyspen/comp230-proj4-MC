import java.util.*;

public class PhoneDirectory 
{
	private List<DirectoryEntry> theDirectory;
	
	//Constructor Methods
	public PhoneDirectory(List<DirectoryEntry> dir)
	{
		theDirectory = dir;
	}

	
	public PhoneDirectory()
	{
		theDirectory = new ArrayList<DirectoryEntry>();
	}

	//Accessor Method
	public List<DirectoryEntry> getDirectory()
	{
		return theDirectory;
	}

	//Mutator Methods
	public String addOrChangeEntry(String name, String number)
	{

		// add an entry to directory or change an existing entry; return the old number or 
		// null if it is a
		// new entry
		Iterator<DirectoryEntry> iter = theDirectory.iterator();
		while(iter.hasNext())
		{
		 	DirectoryEntry next = iter.next();
			if(next.getName().equalsIgnoreCase(name))
				{
					String old = next.getNumber();
					next.setNumber(number);
					return old;
				}
		}

		theDirectory.add(new DirectoryEntry(name, number));
		return null;
	}
   public DirectoryEntry searchEntry(String name)
   {
       // search the entry referenced by name; return the entry searched or null if 
       // there is no entry for name
       Iterator<DirectoryEntry> iter = theDirectory.iterator();
     while(iter.hasNext())
      {
        DirectoryEntry next = iter.next();
        if(next.getName().equalsIgnoreCase(name))
          return next;
      }
      return null;
  }
  
  
  public DirectoryEntry removeEntry(String name)
  {
      // remove the entry referenced by name; return the entry removed or
      // null if there is no entry for name
      DirectoryEntry entry = searchEntry(name);
      if(entry==null)
          return null;
      else
	  {
		  theDirectory.remove(entry);
          return entry;
	  }
  }
  
  public void displayAllEntries()
  {
      //display all entries in a nice and readable format
      Iterator<DirectoryEntry> iter = theDirectory.iterator();
      while(iter.hasNext())
          System.out.println(iter.next().toString());
  }
	
  public String toString()
  {
	String entries = "";
	Iterator<DirectoryEntry> iter = theDirectory.iterator();
	while(iter.hasNext())
		entries += iter.next().toString() + "\n";
	return entries;

  }


}
