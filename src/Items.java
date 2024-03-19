
public class Items
{
	private String name;
	private String description;
	private int location;


	//Here is my constructor for the items

	public Items(String name, String description, int location)
		{
			this.name = name;
			this.description = description;
			this.location = location;
		}

	
	//Getters and Setters
	public String getName()
		{
			return name;
		}


	public void setName(String name)
		{
			this.name = name;
		}


	public String getDescription()
		{
			return description;
		}


	public void setDescription(String description)
		{
			this.description = description;
		}


	public int getLocation()
		{
			return location;
		}


	public void setLocation(int location)
		{
			this.location = location;
		}
	
	
	
	
	
	
}



