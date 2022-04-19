
private List<DirectoryEntry> theDirectory = new ArrayList<>();

//temp file to create methods
public DirectoryEntry searchEntry(String name)
{
	// search the entry referenced by name; return the entry searched or null if 
	// there is no entry for name
	Iterator<DirectoryEntry> iter = theDirectory.iterator();
    while(iter.hasNext())
    {
      DirectoryEntry next = iter.next();
      if(next.getName().equalsIgnoreCase(name))
        return iter;
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
		return entry.remove();
}

public void displayAllEntries()
{
	//display all entries in a nice and readable format
	Iterator<DirectoryEntry> iter = theDirectory.iterator();
	while(iter.hasNext)
		println(iter.next().toString()); 
}
