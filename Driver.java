import java.util.Scanner;

public class Driver
{
    static Location currLocation;
    static ContainerItem myInventory;

    public static void createWorld()
    {
        ContainerItem desk = new ContainerItem("Desk", "Furniture", "An old chestnut Desk") ; 
        ContainerItem vault = new ContainerItem("Vault", "Object", "A safety vault.");
        ContainerItem box = new ContainerItem("Box", "Object", "A cardboard box.");

        desk.addItem(new Item("Pen", "Stationery", "A black Pen."));
        desk.addItem(new Item("Tissue","Object", "Tissue Paper."));

        vault.addItem(new Item("Cash", "Money", "Bills of $100."));
        vault.addItem(new Item("Gold", "Jewellery", "A gold necklace."));
        vault.addItem(new Item("USB", "Hardware", "A Samsung flash drive."));

        box.addItem(new Item("Paper", "Stationery", "Some scrap paper."));
        box.addItem(new Item("Watch", "Object","An old silver pocket watch."));

        Location kitchen = new Location("Kitchen", "A dilapidated Kitchen with an old, dusty wooden table. To the East of the Kitchen is a Hallway.");
        Location hallway = new Location("Hallway", "Dimly lit Hallway that leads to a Bedroom to the North and the Kitchen to the West.");
        Location bedroom = new Location("Bedroom", "A Bedroom with a single bed and a table lamp. To the East is a Bathroom and to the South is a Hallway.");
        Location bathroom = new Location("Bathroom", "A Bathroom with a sink and a window. To the West is a bedroom.");

        hallway.addItem(desk);
        bedroom.addItem(vault);
        kitchen.addItem(box);

        kitchen.connect("east", hallway);
        hallway.connect("west",kitchen);
        hallway.connect("north", bedroom);
        bedroom.connect("south", hallway);
        bedroom.connect("east", bathroom);
        bathroom.connect("west", bedroom);

        bathroom.addItem(new Item("Hairbrush", "Object", "A dirty Hairbrush with blood on it."));
        bedroom.addItem(new Item("Gatorade","Beverage", "A bottle of blueberry Gatorade."));
        kitchen.addItem(new Item( "Knife", "Weapon","A dull rusted knife."));
        hallway.addItem(new Item("Lamp", "Object", "An old lamp that does not turn on."));

        

        currLocation = bedroom;


    }

    public static void help()
    {
        System.out.println("\n------------------------------------------------------------");
        System.out.println("take (NAME): Adds the item to your inventory.\ndrop (NAME): Drops the item from your inventory. \nhelp: Prints the list of all commands available.\ninventory: Prints a list of items in your backpack.\nlook: Prints a description of your surroundings.\nexamine (NAME): Examines the item.\ngo (DIRECTION): Moves the player in a direction.\nquit: Exits the game.");
        System.out.println("------------------------------------------------------------\n");
    }

    public static void er_command()
    {
        System.out.println("I don't know how to do that!");
    }

    public static boolean isvalid(String word)
    {
        switch(word)
        {
            case "north":
                return true;
            case "east":
                return true;
            case "west":
                return true;
            case "south":
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) 
    {

        createWorld();
        myInventory = new ContainerItem("Backpack", "Inventory", "An inventory of the items you have in your backpack");

        /*
        ContainerItem inventory = new ContainerItem("Bagpack", "Inventory", "Bagpack to carry  your Items that contains");

        inventory.addItem(new Item("Knife","Weapon", "A dull rusted blade."));
        inventory.addItem(new Item("Tootbrush", "Object", "A toothbrush."));

        System.out.println( inventory.toString() );
        */

        /*
        currLocation = new Location("Warehouse","A shady warehouse near a corn field ");

        currLocation.addItem( new Item("Forklift","Vehicle","Can be used to move boxes around.") );
        currLocation.addItem( new Item("Box","Object","Contains stuff you can use") );
        currLocation.addItem(new Item("Knife","Weapon", "A sharp knife!") );
        */


        
        Scanner input = new Scanner(System.in);

        while(true)
        {
            System.out.println("Enter command: ");
            String command = input.nextLine().toLowerCase();

            String[] words = command.split(" ");

            switch(words[0])
            {
                case "inventory":
                    if(words.length == 1)
                        System.out.println(myInventory.getItemName());
                    else
                        Driver.er_command();
                    break;
                
                case "help":
                    help();
                break;

                case "take":
                    if(words.length == 2 )
                    {
                        if(currLocation.hasItem(words[1]))
                            myInventory.addItem(currLocation.removeItem(words[1]));
                        else
                            System.out.println(words[1]+" does not exist at this Location");
                    }
                    else if(words.length == 4)
                    {
                        if(currLocation.hasItem(words[3]))
                        {
                            ContainerItem cItem = (ContainerItem)(currLocation.getItem(words[3]));
                            
                            if(cItem.hasItem(words[1]))
                                myInventory.addItem(cItem.removeItem(words[1]));
                            else
                                System.out.println("The item does not exist in the Container Item provided.");

                        }
                        else
                            System.out.println("This Container item does not exist.");
                    }
                    else 
                        System.out.println("You need to type an Item's name.");

                    break;
                
                    case "drop":
                        if(words.length == 2 )
                        {
                            if(myInventory.hasItem(words[1]))
                                currLocation.addItem(myInventory.removeItem(words[1]));
                            else
                                System.out.println(words[1]+" is not in your inventory.");
                        }
                        else 
                            System.out.println("You need to type an Item's name.");
                            
                        break;

                case "go":
                    if(words.length == 2 )
                    {
                        if( isvalid(words[1]) )
                        {
                            if( currLocation.canMove(words[1]) )
                                currLocation = currLocation.getLocation(words[1]);
                            else
                                System.out.println("No location to move to in this direction.");  
                        }
                        else
                            System.out.println("Not a valid Direction!"); 
                    }    
                    else
                        System.out.println("You need to type direction name.");

                    break;

                case "quit":
                    if(words.length == 1)
                        System.exit(0);
                    else
                        Driver.er_command();

                    break;

                case "look":
                    if(words.length == 1)
                    {
                        System.out.println(currLocation.getName() + " - " + currLocation.getDescription() + "The following items can be seen:");
                        for(int i = 0; i < currLocation.numItems(); i++)
                            System.out.println("+ " + currLocation.getItem(i).getName());
                    }
                    else
                        Driver.er_command();

                    break;

                case "examine":
                    if(words.length == 2)
                    {
                        if(currLocation.hasItem(words[1]))
                            System.out.println(currLocation.getItem(words[1]).toString());
                        else
                            System.out.println(words[1] +" does not exist.");
                    }
                    else
                        System.out.println("You need to type an Item's name.");

                    break;

                default:
                    System.out.println("I don't know how to do that");
            }


        } 

    }    
}
