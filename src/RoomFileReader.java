//
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomFileReader 
{

	public static List<Room> readRoomsFile(String filePath) //Method is taking the chosen filePath as the input and returning a list of Room objects
		{
			List<Room> rooms = new ArrayList<>(); //Creating an empty list called "rooms" to store my Room objects

			try (Scanner sc = new Scanner(new File(filePath))) //Creating a scanner object to read the file chosen
			{
				while (sc.hasNextLine()) { //Creating a while loop to read each line in my text file and also separate info on each line later in code.
					String line = sc.nextLine(); //Reading each line (Declaring the "line" variable)
					String[] parts = line.split("#"); //This is my delimiter. The different room sections are going to be split up by this.

					
					//As the different room info is being recognized, the program will store by different room components into their own variables.
					int roomNum = Integer.parseInt(parts[0]); //roomNum is [0] in the array list which is the 1st components of the room.
					String roomName = parts[1];
					String description = parts[2];

					// Parse exits
					List<Integer> exits = parseExits(parts[3]); /*My exits will be parsed in the parseExits() mmethod which splits it 
					into individual exit numbers and converts them to integers. The resulting list of exit numbers is stored in the "exits" variable.*/

					
					List<String> items = parseItems(parts[4]); /*My items will be parsed in the parseItems() method which splits it into individual 
					item names and trims any whitespace. The resulting list of item names is stored in the "items" variable.*/

					rooms.add(new Room(roomNum, roomName, description, exits, items)); //A new Room object will be created and added to the rooms list.
				}
			} 
			catch (FileNotFoundException ex) //This occurs if the file is not found :( (Scanner will be automatically close if this were to occur)
				{
					ex.printStackTrace();
				}

			return rooms; //List will be returned
		}

	private static List<Integer> parseExits(String exitsStr) 
		{
			List<Integer> exits = new ArrayList<>();
			String[] exitTokens = exitsStr.split(",");

			for (String exitToken : exitTokens) 
				{
					exits.add(Integer.parseInt(exitToken));
				}

			return exits;
		}

	private static List<String> parseItems(String itemsString) 
		{
			List<String> items = new ArrayList<>();
			// Split items by comma and add to list
			for (String item : itemsString.split(",")) 
				{
					items.add(item.trim());
				}
			return items;
		}
}
