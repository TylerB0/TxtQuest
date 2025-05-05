package TxtQuest;

/*
 * usable items
 * can be used in battle or in shops
 * or can be for show
 * extends Item obj
 */
public class Usable extends Item {
    int healAmnt = 0;
    ItemTypes type = ItemTypes.USABLE;

    /*
     * constructor for Usable obj
     * Paramter(s): String for the name, int price, int selling price, String description, int healing amount
     * 
     * these can be healing items, but if made to heal they'll be deleted from the inventory
     */
    Usable(String itemName, int price, int sellPrice, String descrptn, int healAmnt) {
        super(itemName, price, sellPrice, descrptn);
        this.healAmnt = healAmnt;
    }
    public int get_healAmnt() {
        return this.healAmnt;
    }
}
