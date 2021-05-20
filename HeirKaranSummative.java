import java.util.Scanner;

public class HeirKaranSummative 
{

	public static int dmg, mdmg, maxhealth;
	public static int mondmg, monhealth;
	public static String PName, Name, Action;
	public static Scanner userinput = new Scanner(System.in);
	public static double chance, dodgechance;
	
	public static void Battle()
	{
		
		String monster[][] = {
				{"Fire", "Wulf"},
				{"Frost", "Wyrm"},
				{"Wood", "Kobold"},
				{"Storm", "Goblin"},
				{"Earth", "Barbarian"},
				{"Shadow", "Orc"},
				{"Holy", "Ogre"},
				{"Normal", "Troll"},
				{"Water", "Giant"}
				};
		
		int x = (int)(Math.random()*9);
		int y = (int)(Math.random()*9);
		System.out.println("\n\nYou have encountered a " +monster[x][0] + " " +monster[y][1]);
		monhealth = 60 + y*12;
		mondmg = 15 + y*2;
		int health = maxhealth;
		System.out.println(monster[x][0] + " " +monster[y][1] +" has " +monhealth + " points of health"
				+ " and deals " +mondmg + " points of damage.");
		String Attack = "Attack";
		String Attack2 = "Hit";
		String Flee = "Flee";
		String Spell = "Spell";
		int spellcount = 0;
		do {
			System.out.print(PName + "'s turn"
					+ "\nWhat action would you like " +Name + " to perform?\n> ");
			Action = userinput.nextLine();
			if (Action.contains(" "))
			{
				Action.substring(0, Action.indexOf(' '));
			}
			
			if (Action.equalsIgnoreCase(Attack) || Action.equalsIgnoreCase(Attack2))
			{
				System.out.println(Name + " attacks!");
				chance = Math.random();
				if (chance > 0.2)
				{
					System.out.println(Name + " hits!"
							+ "\n" +Name + " deals " +dmg + " points of damage.\n");
					monhealth = monhealth - dmg;
					if (monhealth > 0)
					{
						System.out.println(monster[x][0] + " " +monster[y][1] +" has " +monhealth + " points of health remaining");
					}
				}
				else
				{
					System.out.println(Name + " misses!");
				}
			}
			else if (Action.equalsIgnoreCase(Flee))
			{
				chance = Math.random()+4*dodgechance;
				if (chance > 0.25)
				{
					System.out.println(Name + " flees!");
				}
				else
				{
					System.out.println(Name + " can't flee!");
				}
				
			}
			else if (Action.equalsIgnoreCase(Spell) && spellcount >= 3)
			{
				System.out.print("What spell would you like " +Name + " to perform?\nHeal\nFireball\nLight\nFrost\n>  ");
				String Heal = "Heal";
				String Fire =  "Fireball";
				String Fire2 = "Fire";
				String Shock = "Lightning Bolt";
				String Shock2 = "Lightning";
				String Shock3 = "Shock";
				String Ice = "Frost";
				String Ice2 = "Ice";
				String Cast = userinput.nextLine();
				int healthhealed;
				if (Cast.equalsIgnoreCase(Heal))
				{
					
					if (health + 20 < maxhealth)
					{
						healthhealed = 20;
					}
					else
					{
						healthhealed = maxhealth - health;
					}
					System.out.println(Name + " casts Heal!\n" +healthhealed + " points of health healed!");
					health = health + healthhealed;
					System.out.println(Name + " now has " +health + " points of health remaining.");
				}
				
				else if (Cast.equalsIgnoreCase(Fire) || Cast.equalsIgnoreCase(Fire2))
				{
					System.out.println(Name + " casts Fireball!");
					if (x == 0 || x == 4)
					{
						System.out.println("Fireball was ineffective!");
						if (x == 0)
						{
							if (monhealth + 20 < (60 + y*12))
							{
								healthhealed = 20;
							}
							else
							{
								healthhealed = (60 + y*12) - monhealth;
							}
							System.out.println("Fireball healed " +monster[x][0] + " " +monster[y][1] +healthhealed + " points of health instead!");
						}
						else
						{
							System.out.println("Fireball dealt no damage!");
						}
					}
					else if (x == 2)
					{
						System.out.println("Fireball was doubly effective!");
						monhealth = monhealth - 2*mdmg;
						System.out.println("Fireball dealt " + (2*mdmg) + " points of damage.");
					}
					else if (x == 5 || x == 6)
					{
						System.out.println("Fireball was only half efective!");
						monhealth = monhealth - mdmg/2;
						System.out.println("Fireball dealt " + (mdmg/2) + " points of damage.");
					}
					else
					{
						System.out.println("Fireball did " +mdmg + " points of damage.");
					}
					System.out.println(monster[x][0] + " " +monster[y][1] + " has " +monhealth + " points of health remaining");
				}
			}
			spellcount++;
			
			/* Monster Turn */
			chance = Math.random();
			if (chance > dodgechance)
			{
				System.out.println(monster[x][0] + " " +monster[y][1] +" hits!"
						+ "\n" +monster[x][0] + " " +monster[y][1] + " deals " +mondmg + " points of damage to " +Name +"\n");
				health = health - mondmg;
				if (health > 0)
				{
					System.out.println(Name + " has " +health + " points of health remaining");
				}
			}
			else
			{
				System.out.println(monster[x][0] + " " +monster[y][1] + " misses!");
			}
			
			
		}while (monhealth > 0 && health > 0);
		
		if (monhealth < 0)
		{
			System.out.println(monster[x][0] + " " +monster[y][1] + " is defeated!");
		}
		else
		{
			System.out.println(Name + " dies!\nGame Over.");
			System.exit(0);
		}
		
	}
	
	public static void Loot()
	{
		String loot[][] = {
				{"Fire", "Knife"},
				{"Frost", "Sword"},
				{"Wood", "Spear"},
				{"Storm", "Axe"},
				{"Earth", "Bow"},
				{"Shadow", "Dirk"},
				{"Holy", "Pike"},
				{"Normal", "Greatsword"},
				{"Water", "Hammer"}
				};
		int x = (int)(Math.random()*9);
		int y = (int)(Math.random()*9);
		System.out.println("You have found a " +loot[x][0] + " " +loot[y][1]);
	}

	
	

	
	public static void main(String[] args) 
	{
		
		System.out.print("Welcome player to korZ!"
				+ "\nPlease enter your name:\n> ");
		
	
		PName = userinput.nextLine();
		
		if (PName.contains(" "))
		{
			PName = PName.substring(0, (PName.indexOf(' ')));
		}
		System.out.println("Welcome " +PName + "!");
		
		System.out.print(PName + ", please enter your character's name:\n> ");
		Name = userinput.nextLine();
		String FirstName;
		if (Name.contains(" "))
		{
			FirstName = Name.substring(0, (Name.indexOf(' ')));
		}
		else
		{
			FirstName = Name;
		}
		
		int stattotal = 0;
		int statpoints = 6;
		System.out.println(PName + ", please enter " +FirstName + "'s Character Stats."
				+ " (" +statpoints + " Stat points total, no more than 4 per category)\n");
		

		
		
		/* Stat Assignment*/
		System.out.print("Strength (" +statpoints + " remaining): ");
		int str = userinput.nextInt();
		while(0 > str || 4 < str)
		{
			System.out.print("Please enter a valid number: ");
			str = userinput.nextInt();
		}
		statpoints = statpoints - str;
		
		System.out.print("Agility (" +statpoints + " remaining): ");
		double SPEED = userinput.nextDouble();
		while(SPEED < 0 || SPEED > 4 || SPEED > statpoints)
		{
			System.out.print("Please enter a valid number: ");
			SPEED = userinput.nextDouble();
		}
		statpoints = (int) (statpoints - SPEED);
		
		System.out.print("Intelligence (" +statpoints + " remaining): ");
		int Int = userinput.nextInt();
		while (Int < 0 || Int > 4 || Int > statpoints)
		{
			System.out.print("Please enter a valid number: ");
			Int = userinput.nextInt();
		}
		statpoints = statpoints - Int;
			
			
		System.out.print("Endurance (" +statpoints + " remaining): ");
		int end = userinput.nextInt();
		while (end < 0 || end > 4 || end > statpoints)
		{
			System.out.print("Please enter a valid number: ");
			end = userinput.nextInt();
		}
		statpoints = statpoints - end;
		
		System.out.println();
		System.out.println(FirstName + "'s character card"
				+ "\nName: " +Name
				+ "\nStrength: " +str
				+ "\nAgility: " +(int)SPEED
				+ "\nIntelligence: " +Int
				+ "\nEndurance: " +end);
		
		maxhealth = 100 + 20*end;
		dmg = 15 + 2*str;
		dodgechance = 0.5 + SPEED/100*15;
		mdmg = 30 + 2*Int;
		
		
		/* Game Start */
		String [][] map = {
				{"Goblin Village", "Wilderness", "Daemonheim"},
				{"Barbarian Village", "Varrock", "Coal Mine"},
				{"Draynor Manor", "Farm", "Al-Kharid Desert"}
		};                   
		int NS= 1;
		int EW = 1;
		System.out.println("~         ~~          __"
				+ "\n       _T      .,,.    ~--~ ^^"
				+ "\n ^^   // \\                    ~"
				+ "\n      ][O]    ^^      ,-~ ~"
				+ "\n   /''-I_I         _II____"
				+ "\n__/_  /   \\ ______/ ''   /'\\_,__"
				+ "\n  | II--'''' \\,--:--..,_/,.-{ },"
				+ "\n; '/__\\,.--';|   |[] .-.| O{ _ }"
				+ "\n:' |  | []  -|   ''--:.;[,.'\\,/"
				+ "\n'  |[]|,.--'' '',   ''-,.    |"
				+ "\n  ..    ..-''    ;       ''. '");
		
		System.out.println();
		
		System.out.println("Welcome to the Kingdom of Misthalin, you are currently in the town of " +map[NS][EW] +".");
		
		String Explore = "Explore";
		boolean objFound = false;
		double chance;
		String Quit = "Quit";
		do 
		{
			
			
			
			
			System.out.print("Perform an action\n> ");
			Action = userinput.next();
			if (Action.equalsIgnoreCase(Explore))
			{
				chance = Math.random();
				if (chance > 0.5)
				{
					System.out.println("You found an object");
				}
				else
				{
					System.out.println("Nothing found");
				}
			}
			String Move = "Move";
			if (Action.equalsIgnoreCase(Move))
			{
				String N = "North";
				String S = "South";
				String E = "East";
				String W = "West";
				boolean canmove = true;
				System.out.println("You are currently in " +map[NS][EW]);
				do
				{
					System.out.println("In which direction would you like to move?");
					String direction = userinput.next();
					canmove = true;
					if (direction.equalsIgnoreCase(N) && NS > 0)
					{
						NS--;
					}
					else if (direction.equalsIgnoreCase(S) && NS < 2)
					{
						NS++;
					}
					else if (direction.equalsIgnoreCase(E) && EW < 2)
					{
						EW++;
					}
					else if (direction.equalsIgnoreCase(W) && EW > 0)
					{
						EW--;
					}
					else
					{
						System.out.println("You cannot move in that direction..");
						canmove = false;
					}	
				}while (canmove == false);
				chance = Math.random();
				System.out.println("You are now in " +map[NS][EW] + "\n\n");
				if (chance > 0.7)
				{
					Battle();
				}
				canmove = true;
				
			}
		}while(!Action.equalsIgnoreCase(Quit));	
	}



}

