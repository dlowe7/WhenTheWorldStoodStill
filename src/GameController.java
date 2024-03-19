import java.util.List;
import java.util.Scanner;

public class GameController 
{
	//Just random code
	private final Scanner sc = new Scanner(System.in); //for user input
	private List<Room> rooms; //List of my rooms
	private Player player;

	public void setRooms(List<Room> rooms) //sets the list of rooms for the game
		{
			this.rooms = rooms;
		}

	public void setPlayer(Player player)
		{
			this.player = player;
		}

	public void startGame() 
		{
			pause(2000);
			System.out.print("\u001B[44m");
			System.out.print("\u001B[1m");
			System.out.println("\n\n\n                                                                                                                                                                       ");
			System.out.println("                                                                WELCOME TO WHEN THE WORLD STOOD STILL                                                                  ");
			System.out.println("                                                                                                                                                                       \n\n\n");
			System.out.print("\u001B[0m");
			pause(2000);
			System.out.println("Please enter player name: ");
			String playerName = sc.nextLine();

			Player player = new Player();
			player.setName(playerName);
			player.setCurrentRoomIndex(0);
			setPlayer(player);

			pause(2000);
			System.out.print("\u001B[36;1m");
			System.out.println("\n\n\n                                                                             Loading ....\n\n");   
			System.out.print("\u001B[0m");
			pause(3000);

			System.out.print("\u001B[1m");
			System.out.print("\n\nThe ");
			pause(200);
			System.out.print("world ");
			pause(200);
			System.out.print("is ");
			pause(200);
			System.out.print("dark ");
			pause(200);
			System.out.print("here.\n");
			pause(2000);

			System.out.print("At ");
			pause(200);
			System.out.print("least ");
			pause(200);
			System.out.print("for ");
			pause(200);
			System.out.print("them ");
			pause(200);
			System.out.print("it ");
			pause(200);
			System.out.print("was...\n\n\n\n");
			pause(4000);
			playGame();
			sc.close();
		}

	private void playGame() 
		{
			System.out.print("\u001B[44m");
			System.out.print("\u001B[1m");
			System.out.println("\n                                                                                                                                                                       ");
			System.out.println("                                                                                 TIPS!                                                                                 ");
			System.out.println("                                                                                                                                                                       \n\n\n");
			System.out.print("\u001B[0m");
			pause(4000);
			System.out.println("Hello " + player.getName() + ",\n" + "Your adventure has just begun ..\n" 
					+ "You want tips? Hmm .. carefully choose you inventory, think critically, and \n"
					+ "WATCH OUT FOR THOSE MONSTERS! \n\n\n");
			pause(7500);
			System.out.print("\u001B[44m");
			System.out.print("\u001B[1m");
			System.out.println("\n                                                                                                                                                                       ");
			System.out.println("                                                                       PHASE ONE - THE BEGINNING                                                                       ");
			System.out.println("                                                                                                                                                                       \n\n\n");
			System.out.print("\u001B[0m");
			pause(6500);

			
			while (true) 
				{

					int currentRoomIndex = player.getCurrentRoomIndex();
					if (currentRoomIndex >= 0 && currentRoomIndex < rooms.size()) 
						{
							Room currentRoom = rooms.get(currentRoomIndex);

							if (currentRoom.getRoomNum() == 1 && !currentRoom.isVisited()) 
								{
									displayRoom(currentRoom);
									askToReadNote();
								}

							String direction = getUserInput("\nWhich direction would you like to go " + player.getName() + " ? (N, E, S, W)");
							currentRoomIndex = navigate(direction, currentRoomIndex); // Update current room index here
							player.setCurrentRoomIndex(currentRoomIndex);
						} 
					else 
						{
							System.out.println("Error: Invalid room index.");
							break; // Exit the loop if the room index is invalid
						}
				}
		}

	private int navigate(String direction, int currentRoomIndex) 
		{
			// Get the current room
			Room currentRoom = rooms.get(currentRoomIndex);

			// Convert direction to uppercase to ensure consistency
			direction = direction.toUpperCase();


			// Get the next room index based on the direction
			int nextRoomIndex = getExitIndex(direction, currentRoom);


			if (nextRoomIndex == -1) 
				{
					System.out.println("\nYou can't go in that direction. Try again.");
					// Prompt the user for a new direction input
					String newDirection = getUserInput("Which direction would you like to go? (N, E, S, W)");
					return navigate(newDirection, currentRoomIndex); // Recursive call with the new direction
				}

			// Check if the next room is already visited
			Room nextRoom = rooms.get(nextRoomIndex);
			if (!nextRoom.isVisited()) 
				{
					// Display the room information only if it's the first time visiting
					displayRoom(nextRoom);
					nextRoom.setVisited(true); // Mark the room as visited
				} 
			else 
				{
					System.out.println("\n\nHmm.. You've been here before.");
					System.out.println("You're at the " + nextRoom.getRoomName() + ".\n");
				}

			return nextRoomIndex;
		}

	private int getExitIndex(String direction, Room room) 
		{
			// Assuming the directions are always N, E, S, W
			List<Integer> exits = room.getExits();


			// Converting my direction into uppercase so that there are no errors
			switch (direction) 
			{
				/*Switch statement assuming that exits are in N, E, S, W. Receives list of exits from Room object
				 * so for example, if the user inserts N then the program takes from the index of the northExit.
				 */
			case "N":
				return exits.get(0) - 1;
			case "E":
				return exits.get(1) - 1;
			case "S":
				return exits.get(2) - 1;
			case "W":
				return exits.get(3) - 1;
			default:
				return -1; // Invalid direction

			}

		}

	//Once this method is called after program mentions the note. User has choice to read note or not.
	private void askToReadNote() 
		{
			System.out.println("Would you like to read the note? (yes/no)");
			String readNoteChoice = sc.nextLine().toLowerCase();

			if ("yes".equals(readNoteChoice)) 
				{
					displayNote();
				}
		}

	private void displayNote() 
		{
			System.out.println("\n\nYou read the note on your nightstand:");
		    System.out.println("_____________________________________________________");
		    System.out.println("|                                                   |");
		    System.out.println("|  Hello Our Child,                                 |");
		    System.out.println("|                                                   |");
		    System.out.println("| We had an unexpected work trip as usual. Your     |");
		    System.out.println("| lunch and dinner is left as we suspect that we    |");
		    System.out.println("| will not be back soon. You have the neighbors'    |");
		    System.out.println("| number, so if anything goes wrong, PLEASE call    |");
		    System.out.println("| them and ask for HELP. They told US to tell you   |");
		    System.out.println("| to call IMMEDIATELY. We hope to see you real      |");
		    System.out.println("| soon. We know it's really dark here when we are   |");
		    System.out.println("| not there. Things just go wrong sometimes, but    |");
		    System.out.println("| we know you will find a way to make the best of   |");
		    System.out.println("| the situation..                                   |");
		    System.out.println("|                                                   |");
		    System.out.println("| Love,                                             |");
		    System.out.println("| Mom and Dad                                       |");
		    System.out.println("|___________________________________________________|\n");

			pause(10000);
		}

	private static void pause(int duration) 
		{
			try 
				{
					Thread.sleep(duration);
				} 
			catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
		}

	public void displayRoom(Room room) 
		{
			System.out.println("\n\n\nYou are at the " + room.getRoomName() + ":\n");
			// Get the description and items from the room object
			String formattedDescription = room.getDescription().replace(". ", ".\n");
			List<String> items = room.getItems();

			// Display the formatted description
			System.out.println(formattedDescription);
			pause(1000);

			// Display the items in the room
			System.out.println("\nItems in the room: " + items);
		}

	private String getUserInput(String prompt) 
		{
			String input;
			do 
				{
					System.out.println(prompt);
					input = sc.nextLine().toUpperCase();
				} 
			while (!input.equals("N") && !input.equals("E") && !input.equals("S") && !input.equals("W"));

			return input;
		}
}