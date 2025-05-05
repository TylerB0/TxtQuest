package TxtQuest;

/*
 * Items in general
 * Framework for all types of items
 * Generally every item falls under Usable, Accessory, Armor, or Weapon so theres no real
 * need to make a standalone Item obj
 */
public class Item {
    String itemName;
    int price;
    int sellPrice;
    String descrptn;

    /*
     * constructor for Item obj
     * Paramter(s): String for item names, int price, int selling price, String description
     */
    Item(String itemName, int price, int sellPrice, String descrptn) {
        this.itemName = itemName;
        this.price = price;
        this.sellPrice = sellPrice;
        this.descrptn = descrptn;
    }

    public String get_name() {
        return itemName;
    }
    public int price() {
        return price;
    }
    public int sellPrice() {
        return sellPrice;
    }
    public String desc() {
        return descrptn;
    }
}