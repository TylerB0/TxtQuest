package TxtQuest;

/*
 * accessory items
 * they affect player speed
 * extends Item obj
 */
public class Accessory extends Item {
    int spd; // used to boost player spd
    ItemTypes type = ItemTypes.ACCESSORY;

    /*
     * constructor for accessory
     * Paramter(s): String for the name, int price, int selling price, int description, int speed stat
     */
    Accessory(String itemName, int price, int sellPrice, String descrptn, int spd) {
        super(itemName, price, sellPrice, descrptn);
        this.spd = spd;
    }
    public int get_spd() {
        return this.spd;
    }
}