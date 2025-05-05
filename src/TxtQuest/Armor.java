package TxtQuest;

/*
 * armor items
 * they affect player defense
 * extends Item obj
 */
public class Armor extends Item {
    int def; // used to boost player def
    ItemTypes type = ItemTypes.ARMOR;

    /*
     * constructor for Armor objects
     * Paramter(s): String name, int price, int selling price, String description, int defense
     * 
     */
    Armor(String itemName, int price, int sellPrice, String descrptn, int def) {
        super(itemName, price, sellPrice, descrptn);
        this.def = def;
    }
    public int get_def() {
        return this.def;
    }
}