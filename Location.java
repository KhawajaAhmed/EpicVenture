import java.util.ArrayList;
import java.util.HashMap;

public class Location
{
    private String name;
    private String description;
    private ArrayList<Item> ArrayList;

    private HashMap<String,Location> connections = new HashMap<String,Location>();

    public Location(String name, String description)
    {
        this.name = name;
        this.description = description;
        ArrayList = new ArrayList<Item>(); 
        connections = new HashMap<>();
    }
    
    public void connect(String direction, Location nextLocation)
    {
        connections.put(direction,nextLocation);
    }

    public boolean canMove(String direction)
    {
        return connections.containsKey(direction);
    }

    public Location getLocation(String direction)
    {
        return connections.get(direction);
    }

    
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

    public void addItem(Item newItem) 
    {
       ArrayList.add(newItem); 
    }

    public boolean hasItem(String findName)
    {
        for(int i = 0; i < ArrayList.size(); i++)
        {
            if(findName.equalsIgnoreCase( ArrayList.get(i).getName() ) )
                return true;
        }

        return false;

    }

    public Item getItem(String name)
    {
        for(int i = 0; i <  ArrayList.size(); i++)
        {
            if(name.equalsIgnoreCase( ArrayList.get(i).getName() ) )
                return ArrayList.get(i);        
        }
        return null;
    }

    public Item getItem(int index)
    {
        if( index >= 0 && index < ArrayList.size() ) 
            return ArrayList.get(index);

        return null;
    }

    public int numItems()
    {
        return ArrayList.size();
    }

    public Item removeItem(String name)
    {
        if( hasItem(name) )
        {
            Item temp = getItem(name);
            ArrayList.remove( temp );

            return temp;
        }
        return null;
    }

    

    

}
