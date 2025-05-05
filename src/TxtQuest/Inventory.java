package TxtQuest;
import java.util.ArrayList;

/*
 * Your inventory
 * all your items gained or that you had on creation are stored here
 */
public class Inventory {
    ArrayList<Item> urInvtry; //using an arraylist of Item objects to store your items

    //constructor
    Inventory() {
        this.urInvtry = new ArrayList<Item>();
    }

    /*
     * adds an item to your inventory
     * 
     * Paramter(s): Item object
     * Output: None
     */
    public void addItem(Item item) {
        urInvtry.add(item);
    }

    /*
     * take out an item from your inventory
     * 
     * Paramter(s): Item object
     * Output: None
     */
    public void rmvItem(Item item) {
        boolean removed = urInvtry.remove(item);
        if (removed == true)
            return;
        else
            System.out.println("Something went wrong.");
        return;
    }

    /*
     * shows your current inventory
     * 
     * Paramter(s): None
     * Output: None
     */
    public void displayInv() {
        System.out.println("----INVENTORY----");
        if (urInvtry.isEmpty() == true) {
            System.out.println("Empty.");
            return;
        }
        System.out.println(urInvtry);
    }
}
