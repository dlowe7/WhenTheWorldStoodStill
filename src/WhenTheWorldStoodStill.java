//Importing the classes from the java util package (List & Scanner)
import java.util.List;
import java.util.Scanner;

public class WhenTheWorldStoodStill 
{
	//sc id declared for the user inout later in code
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) 
		{
			// Asking the user if they would like to play the game
			System.out.println("Would you like to start the game?");
			// Receiving user's input
			String startChoice = sc.nextLine().toLowerCase();

			if ("yes".equals(startChoice)) 
				{
					// Allow the user to choose a map
					System.out.println("\nPlease choose your map selection: (1 = Map 1 or 2 = Map 2)");
					String mapChoiceString = sc.nextLine().trim();
					int mapChoice;

					try 
						{
							//Program will attempted to parse the mapChoiceString
							mapChoice = Integer.parseInt(mapChoiceString);
						} 
					catch (NumberFormatException e) 
						{
							System.out.println("Invalid map choice. Exiting the game... Please re-run.");
							return;
						}

					String filePath = null;
					if (mapChoice == 1) 
						{
							filePath = "Rooms.txt";
						} 
					else if (mapChoice == 2) 
						{
							filePath = "Rooms2.txt";
						} 
					else 
						{
							System.out.println("Invalid map choice. Exiting the game...");
							return;
						}

					// This will read the rooms from the user's selected map file and store them in a List of Room objects
					List<Room> rooms = RoomFileReader.readRoomsFile(filePath);

					// Game controller object has been created and the list of rooms is set using the setRooms() method
					GameController gameController = new GameController();
					Player player = new Player();
					gameController.setRooms(rooms); //setting the rooms from chosen txt file
					gameController.setPlayer(player);
					gameController.startGame(); //Game is started by calling this method. If the user enters yes then the game will proceed, if not the exit message will be given.
				}
			else 
				{
					System.out.println("You saved yourself from despair... Exiting game. Goodbye!");
				}

			sc.close(); //Scanner is closed
		}
}