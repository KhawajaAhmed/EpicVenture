import java.util.ArrayList;

public class ContainerItem extends Item
{
    private ArrayList<Item> items ;

    public ContainerItem(String name, String type,String description )
    {
        //Call to base constructor
        super(name,type,description);
        items = new ArrayList<>();
    }

    public void addItem(Item objItem)
    {
        items.add(objItem);
    }

    public boolean hasItem(String name)
    {
        for(int i = 0; i < items.size(); i++ )
            if(items.get(i).getName().equalsIgnoreCase(name) )
                return true;

        return false;   
    }

    public Item removeItem(String name)
    {
        if(!items.isEmpty())
        {
            for(int i = 0; i < items.size(); i++ )
            {
                if(items.get(i).getName().equalsIgnoreCase(name))
                    return items.remove(i);
            }
        }       
        return null;
    }

    public String getItemName()
    {
        String name = "";

        for(int i = 0; i < items.size(); i++) 
        { 
            name = name + "+ " + items.get(i).getName() + "\n";
        }

        return name;
    }

    @Override
    public String toString()
    {
        return (super.toString() + ":\n" + getItemName());
    }


}
