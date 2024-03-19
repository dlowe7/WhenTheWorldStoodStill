import java.util.List;
import java.util.Arrays;

public class Room
{
	//Here are all of my instance variables 
	int roomNum;
	String roomName;
	String description;
	boolean visited;
	List<Integer> exits;
	List<String> items;
	private int northExit;
	private int eastExit;
	private int southExit;
	private int westExit;

	//Constructor for all room elements. Its going to take in all of the instance variables and initialize them. 
	public Room(int roomNum, String roomName, String description, List<Integer> exits, List<String> items)
		{
			//Values of my instances assigned
			this.roomNum = roomNum;
			this.roomName = roomName;
			this.description = description;
			this.visited = false;
			this.exits = exits;
			this.items = items;
			this.northExit = exits.get(0);
			this.eastExit = exits.get(1);
			this.southExit = exits.get(2);
			this.westExit = exits.get(3);
		}

	//Here are the getters and setters for the instance variables. This will allow for other classes/parts of the program to allow access and modify
	public int getRoomNum()
		{
			return roomNum;
		}

	public void setRoomNum(int roomNum)
		{
			this.roomNum = roomNum;
		}

	public String getRoomName()
		{
			return roomName;
		}

	public void setRoomName(String roomName)
		{
			this.roomName = roomName;
		}

	public String getDescription()
		{
			return description;
		}

	public void setDescription(String description)
		{
			this.description = description;
		}

	public boolean isVisited()
		{
			return visited;
		}

	public void setVisited(boolean visited)
		{
			this.visited = visited;
		}

	public List<Integer> getExits()
		{
			return Arrays.asList(northExit, eastExit, southExit, westExit);
		}

	public void setExits(List<Integer> exits)
		{
			this.exits = exits;
		}

	public List<String> getItems()
		{
			return items;
		}

	public void setItems(List<String> items)
		{
			this.items = items;
		}
}
